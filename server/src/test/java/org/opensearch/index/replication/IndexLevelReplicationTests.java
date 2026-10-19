                    assertThat(  
            } while (startedShards > 0);
    }
                    }  
            final int docCount = randomInt(50);
                assertThat("Peer-recovery should not send overridden operations", snapshot.skippedOperations(), equalTo(0));
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
 * this file be licensed under the Apache-2.0 license or a
                    indexShard.routingEntry() + " has the wrong number of ops in the translog",  
                } else {
            final IndexShard primary = shards.getPrimary();
import org.opensearch.index.store.Store;
            logger.info("--> Isolate replica1");
import org.opensearch.index.engine.Engine;
            assertEquals(primarySegmentStats.getMaxUnsafeAutoIdTimestamp(), segmentsStats.getMaxUnsafeAutoIdTimestamp());  
     * This makes sure that that replica still remembers the delete operation and correctly ignores the stale index operation.  
            }
            CyclicBarrier barrier = new CyclicBarrier(2);
                    }  
            indexOnReplica(indexRequest, shards, replica);
                try {
            assertTrue(response.isFailed());
 * Licensed to Elasticsearch under one or more contributor  
        }
            Thread t1 = new Thread(() -> {  
 * GitHub history for details.
            Translog.NoOp noop2 = new Translog.NoOp(1, primaryTerm, indexException.toString());  
import java.util.concurrent.CyclicBarrier;
            final Translog.Operation op1;
            thread.join();
            IndexShard replica3 = shards.addReplica();
            IndexShard replica = shards.addReplica();  
                            // prevent the indexing on the primary from returning (it was added to Lucene and translog already)
                }
            IndexShard replica = shards.addReplica();
        try (
        this.threadPool = new TestThreadPool(
                    public void cleanFiles(
                    }
import java.util.concurrent.CountDownLatch;  
            final IndexRequest retryRequest = copyIndexRequest(originalRequest);
    public void testSimpleAppendOnlyReplication() throws Exception {
            try (Translog.Snapshot snapshot = getTranslog(shards.getPrimary()).newSnapshot()) {
            }
            getIndexer(replica).maybePruneDeletes();
                                throw new AssertionError(e);  
            shards.startReplicas(nReplica);
            future.get();  
                        ? equalTo(SequenceNumbers.NO_OPS_PERFORMED)
        }  
            // Append-only request - without id
                    throw new RuntimeException(e);  
                final List<Translog.Operation> expectedOps = new ArrayList<>(initOperations);
import org.opensearch.action.bulk.BulkItemResponse;
                 * the last operation completed).
            }  
        }  
            IndexRequest indexDoc1 = new IndexRequest(index.getName()).id("d1").source("{}", MediaTypeRegistry.JSON);
 *  
import java.util.concurrent.TimeUnit;  
            try (Translog.Snapshot snapshot = replica3.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, true)) {
            Engine engine = getEngine(shards.getPrimary());  
    private void updateGCDeleteCycle(IndexShard shard, TimeValue interval) {
            logger.info("--> isolated replica " + replica1.routingEntry());
    }  
            for (IndexShard shard : shards) {
                        } catch (InterruptedException e) {  
            try (Translog.Snapshot snapshot = replica3.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, true)) {  
                assertThat(snapshot.skippedOperations(), equalTo(0));
            recoveryDone.countDown();
            IndexRequest indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"1\"}", MediaTypeRegistry.JSON);
     * deleted on the primary before it is added to replica. Replicas should treat a late append-only request as a regular index request.
                    throw new RuntimeException(e);  
            originalRequest.process(Version.CURRENT, null, index.getName());
                assertThat(op2.primaryTerm(), greaterThan(op1.primaryTerm()));
            });
        try (ReplicationGroup shards = createGroup(0)) {  
                }
    public void testSeqNoCollisionWithReadForward() throws Exception {  
            List<IndexShard> replicas = shards.getReplicas();
            assertThat(response.getFailure().getCause(), instanceOf(VersionConflictEngineException.class));
            logger.info("--> Promote replica2 as the primary");  
                    } else {
 *
            retryRequest.onRetry();  
                shards.addReplica();  
                }
     * and processed on the replica but the index is delayed with an interval that is even longer the gc deletes cycle.
            shards.index(originalRequest); // original append-only arrives after recovery completed
                    throw indexException;  
    }
            t1.join();
                new IndexRequest(index.getName()).id("1").source("{}", MediaTypeRegistry.JSON).version(2)
    public void testLateDeliveryAfterGCTriggeredOnReplica() throws Exception {
                    try {
            }  
            assertThat(replica.getMaxSeenAutoIdTimestamp(), equalTo(originalRequest.getAutoGeneratedTimestamp()));
                for (IndexableField field : doc) {
            final int docCount = randomInt(50);
                }
            final BulkShardRequest indexRequest = indexOnPrimary(  
            List<IndexShard> replicas = shards.getReplicas();  
            thread.join();  
    }
import static org.hamcrest.core.Is.is;  
     * An index operation on the primary is followed by a delete operation. The delete operation is delivered first
    public void testConflictingOpsOnReplica() throws Exception {  
    }  
                    indexShard.translogStats().estimatedNumberOfOperations(),
                    .build()
            IndexShard replica1 = replicas.get(0);  
            final BulkItemResponse response = shards.index(indexRequest);
            );  
                    }
            SegmentsStats segmentsStats = replica.segmentStats(false, false);  
                /*
                }
        final Set<String> liveDocs = new HashSet<>();
            }
                        super.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, ActionListener.runAfter(listener, () -> {
                numDocs += shards.indexDocs(randomInt(20));
            shards.promoteReplicaToPrimary(replica1).get(); // wait until resync completed.  
import org.apache.lucene.index.Term;
                    @Override  
                } catch (Exception e) {
            shards.assertAllEqual(0);  
            deleteOnReplica(deleteRequest, shards, replica); // delete arrives on replica first.
            for (IndexShard replica : shards.getReplicas()) {
            int nReplica = randomIntBetween(1, 3);
                            .or(containsString("engine is closed"))  
                 * After the last indexing operation completes, the primary will advance its global checkpoint. Without another indexing
            assertEquals(newReplica1Term + 1, replica2.getPendingPrimaryTerm());
                try (Translog.Snapshot snapshot = getTranslog(replica).newSnapshot()) {  
            CyclicBarrier barrier = new CyclicBarrier(2);  
                    barrier.await();
            shards.indexDocs(docCount);
            replica.refresh("test");  
            assertEquals(DocWriteResponse.Result.CREATED, response.getResponse().getResult());
import org.opensearch.index.engine.SegmentsStats;  
                shards.addReplica();
            shards.startAll();
                            latch.countDown();
    }
            assertEquals(primaryPrimaryTerm, replica2.getPendingPrimaryTerm());
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(2, mappings))) {
            }
                        int totalTranslogOps,
import org.opensearch.index.IndexSettings;  
    }  
                        assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));  
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
                    indexShard.translogStats().estimatedNumberOfOperations(),
            BulkItemResponse response = shards.index(
            int numDocs = 0;
import org.opensearch.action.delete.DeleteRequest;  
            shards.assertAllEqual(docCount);  
                    throw new RuntimeException(e);
            shards.recoverReplica(replica);  
                            try {  
                assertThat(shardRouting + " local checkpoint mismatch", shardStats.getLocalCheckpoint(), equalTo(numDocs - 1L));  
                    }  
                if (randomBoolean()) {
import static org.hamcrest.Matchers.containsString;
                assertThat(
        );
                assertThat(
                    barrier.await();
     * test document failures (failures after seq_no generation) are added as noop operation to the translog
            if (successFullyIndexed.get()) {
            final IndexShard replica = shards.getReplicas().get(0);
    public void testSeqNoCollision() throws Exception {
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {  
        }
 * KIND, either express or implied.  See the License for the
                        ise.getMessage(),
                assertThat(EngineTestCase.getNumVersionLookups(getEngine(replica)), equalTo(0L));
     * This test ensures the consistency between primary and replica when non-append-only (eg. index request with id or delete) operation
            shards.assertAllEqual(0);  
        try (ReplicationGroup shards = createGroup(randomInt(3))) {  
            IndexShard replica = replicas.get(0);
            response = shards.index(new IndexRequest(index.getName()).id("1").source("{}", MediaTypeRegistry.JSON).version(2));  
        try (ReplicationGroup group = createGroup(2)) {
                    );
        }  
                    indexOnReplica(replicationRequest, shards, replica, primaryPrimaryTerm);  
                    TopDocs search = searcher.search(new TermQuery(new Term("f", "2")), 10);
                final SeqNoStats shardStats = shard.seqNoStats();
import static org.hamcrest.Matchers.nullValue;
                Settings.builder()  
            shards.refresh("test");
                    Translog.Operation op = snapshot.next();  
    public void testAppendOnlyRecoveryThenReplication() throws Exception {
        }
 */
            );  
            indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"2\"}", MediaTypeRegistry.JSON);  
        }, null, null, config);  
                } catch (Exception e) {
            shards.startPrimary();
    public void testOutOfOrderDeliveryForAppendOnlyOperations() throws Exception {  
                    assertThat(snapshot.totalOperations(), equalTo(1));
            t2.start();
 * Modifications Copyright OpenSearch Contributors. See  
            shards.syncGlobalCheckpoint();
            }  
            Thread t2 = new Thread(() -> {  
                    throw new AssertionError(e);  
import static org.hamcrest.Matchers.instanceOf;  
            int nReplica = randomIntBetween(1, 3);  
            for (IndexShard indexShard : shards) {
                }
            shards.startAll();  
     */  
            indexOnReplica(replicationRequest, shards, replica2);
                    globalCheckpointMatcher = numDocs == 0
            long primaryPrimaryTerm = shards.getPrimary().getPendingPrimaryTerm();
import org.opensearch.common.unit.TimeValue;
            // Make sure that peer-recovery transfers all but non-overridden operations.
                    if (shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false) {
                }
import java.util.HashSet;  
                        throw new AssertionError(e);  
package org.opensearch.index.replication;
                    .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                );  
                op1 = snapshot.next();
                Settings.builder()
                    }
            final Translog.Operation op1;  
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
            shards.assertAllEqual(docCount);  
                primary
    }
            shards.assertAllEqual(1);
                            } catch (InterruptedException e) {
                    .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            IndexRequest indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"1\"}", MediaTypeRegistry.JSON);  
                op2 = snapshot.next();
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));  
                assertThat(op2.seqNo(), equalTo(op1.seqNo()));
}  
            shards.assertAllEqual(initDocs + 1);
        }
import org.opensearch.index.mapper.MapperService;
                    ) {  
                assertThat("Peer-recovery should not send overridden operations", snapshot.skippedOperations(), equalTo(0));  
                expectedOps.add(op2);
            final IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
import org.opensearch.threadpool.ThreadPool;  
                final ShardRouting shardRouting = shard.routingEntry();
            });
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")  
                assertThat(EngineTestCase.getNumVersionLookups(getEngine(replica)), equalTo(versionLookups));
            }  
            }
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(1, mappings))) {
            for (IndexShard replica : group.getReplicas()) {
                        latch.countDown();
                    liveDocs.remove(id);  
            t2.start();
                        try {
        }
 */
                } catch (Exception e) {
            // I think we can just set this to something very small (10ms?) and also set ThreadPool#ESTIMATED_TIME_INTERVAL_SETTING to 0?
     * of the same document is processed before the original append-only request on replicas. The append-only document can be exposed and  
        }
            final String docId = Iterables.get(getShardDocUIDs(primary), 0);
import java.util.List;
                if (isTombstone) {  
                    assertThat(op, is(notNullValue()));
                (shard, node) -> new RecoveryTarget(shard, node, recoveryListener, threadPool) {
                assertThat(EngineTestCase.getNumVersionLookups(getEngine(replica)), equalTo(0L));
 * specific language governing permissions and limitations
            for (int i = 0; i < numDocs; i++) {  
    /**
        try (ReplicationGroup shards = createGroup(0)) {
            ReplicationGroup shards = createGroup(
            shards.startAll();  
import org.hamcrest.Matcher;
            // start with the primary only so two first failures are replicated to replicas via recovery from the translog of the primary.
            for (IndexShard shard : shards) {  
            }
                }  
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
import org.opensearch.core.xcontent.MediaTypeRegistry;
                op1 = snapshot.next();  
                        isTombstone = true;  
            indexRequest.onRetry(); // force an update of the timestamp  
            shards.startAll();
            )
                 * Therefore, we can only assert that the global checkpoint is number of docs minus one (matching the primary, in case of a
            ReplicationGroup shards = createGroup(
        shard.onSettingsChanged();
            CountDownLatch latch = new CountDownLatch(2);
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
            getClass().getName(),
            shards.startAll();
                        versionLookups++;
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(1)) {
            final BulkShardRequest indexRequest = indexOnPrimary(
    }
            shards.startAll();  
        builder.settings(
                            }
                IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
                assertThat(snapshot.totalOperations(), equalTo(1));
        CountDownLatch indexedOnPrimary = new CountDownLatch(1);  
                        Store.MetadataSnapshot sourceMetadata,
                    .build()  
                        ActionListener<Void> listener
                            indexedOnPrimary.countDown();
            shards.assertAllEqual(initDocs + 1);
    public void testInheritMaxValidAutoIDTimestampOnRecovery() throws Exception {
            shards.startAll();
import org.opensearch.cluster.metadata.IndexMetadata;
                try (Translog.Snapshot snapshot = shard.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
                    assertThat(op, is(notNullValue()));  
                }
     * This test ensures the consistency between primary and replica with late and out of order delivery on the replica.  
                    successFullyIndexed.set(true);
        }
                                recoveryDone.await();
/*
            final long deleteTimestamp = threadPool.relativeTimeInMillis();
            expectedTranslogOps.add(noop2);
            IndexShard replica2 = replicas.get(1);
                    .put(IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING.getKey(), true)
 * Unless required by applicable law or agreed to in writing,
                assertThat(op1, notNullValue());
                        }
            // the failure replicated directly from the replication channel.  
            assertThat(indexResp.isFailed(), equalTo(true));
import org.opensearch.index.engine.InternalEngine;
                .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), interval.getStringRep())
            protected EngineFactory getEngineFactory(ShardRouting routing) {
                    @Override  
            BulkShardRequest replicationRequest = indexOnPrimary(indexRequest, shards.getPrimary());
            Thread t2 = new Thread(() -> {  
import org.apache.lucene.index.IndexableField;
                    );
            shards.startAll();  
                try (Translog.Snapshot snapshot = shard.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
                assertThat(op2.primaryTerm(), greaterThan(op1.primaryTerm()));
                assertThat(snapshot, containsOperationsInAnyOrder(expectedOps));
            shards.index(indexRequest);
                assertThat(shardRouting + " max seq no mismatch", shardStats.getMaxSeqNo(), equalTo(numDocs - 1L));
            }
                 * recovery), or number of docs minus two (received indexing operations but has not received a global checkpoint sync after  
 * You may obtain a copy of the License at  
                }
                    equalTo(0)
import static org.opensearch.index.translog.SnapshotMatchers.containsOperationsInAnyOrder;  
 * this work for additional information regarding copyright
                assertThat(snapshot.next(), nullValue());
                try (Translog.Snapshot snapshot = getTranslog(shard).newSnapshot()) {
        }
            }
            logger.info("--> Recover replica3 from replica2");
            long versionLookups = 0;
            updateGCDeleteCycle(replica, gcInterval);
            // simulate a background global checkpoint sync at which point we expect the global checkpoint to advance on the replicas  
                    shards.promoteReplicaToPrimary(replica2).get();  
            shards.assertAllEqual(0);
                            }
import org.opensearch.cluster.routing.ShardRouting;  
                            } catch (InterruptedException e) {  
            shards.startAll();
            IndexShard replica1 = replicas.get(0);
                };  
            assertEquals(0, InternalEngineTests.getNumVersionLookups((InternalEngine) engine));
                }  
 * not use this file except in compliance with the License.
            BulkShardRequest replicationRequest = indexOnPrimary(indexDoc1, shards.getPrimary());  
    public void testIndexingOptimizationUsingSequenceNumbers() throws Exception {  
            logger.info("--> Promote replica1 as the primary");
            shards.appendDocs(docCount);
                (indexShard, node) -> new RecoveryTarget(indexShard, node, recoveryListener, threadPool) {
            List<IndexShard> replicas = shards.getReplicas();
            shards.startAll();  
            }
                2,
     * test request failures (failures before seq_no generation) are not added as a noop to translog
import org.opensearch.index.engine.InternalEngineTests;
                    Translog.Operation op = snapshot.next();
            shards.promoteReplicaToPrimary(replica1).get();
            Thread thread = new Thread(() -> {
            }
            IndexShard replica1 = replicas.get(0);
        }  
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {
            for (int i = 0; i < nReplica; i++) {
            final List<Translog.Operation> initOperations = new ArrayList<>(initDocs);
        }
                    group.delete(new DeleteRequest(index.getName(), id));
                 * operation, or a background sync, the primary will not have broadcast this global checkpoint to its replicas. However, a  
            assertEquals(0, InternalEngineTests.getNumIndexVersionsLookups((InternalEngine) engine));
                    // we flush at the end of peer recovery
            };  
                assertThat(snapshot.skippedOperations(), equalTo(0));  
                assertThat(shardRouting + " global checkpoint mismatch", shardStats.getGlobalCheckpoint(), globalCheckpointMatcher);
            shards.appendDocs(1);// just append one to the translog so we can assert below  
import org.opensearch.core.action.ActionListener;
                    shards.promoteReplicaToPrimary(replica).get();  
import static org.hamcrest.Matchers.greaterThan;
    }  
    }
                assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));
            int numDocs = randomIntBetween(100, 200);
            }
        ) {
                    versionLookups++;
                    assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));  
                } catch (Exception e) {
            int initDocs = shards.indexDocs(randomInt(10));
                    assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));  
            final Translog.Operation op2;  
 * the Apache License, Version 2.0 (the "License"); you may
            logger.info("--> Promote replica1 as the primary");  
                            indexedOnPrimary.await();
                    } else {
import org.opensearch.index.shard.IndexShard;  
            long primaryTerm = shards.getPrimary().getPendingPrimaryTerm();
import static org.hamcrest.Matchers.anyOf;
                boolean isTombstone = false;  
            final Translog.Operation op2;
                }
                    shardRouting + " global checkpoint mismatch",  
                                throw new AssertionError(e);
/*  
                final Matcher<Long> globalCheckpointMatcher;  
        IndexMetadata.Builder builder = IndexMetadata.builder(shard.indexSettings().getIndexMetadata());  
                    indexShard.routingEntry() + " has the wrong number of ops in the translog",  
            final IndexRequest originalRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);  
        }
    public void testDocumentFailureReplication() throws Exception {
            Future<Void> future = shards.asyncRecoverReplica(  
    }
                assertThat(snapshot, containsOperationsInAnyOrder(expectedOps));
            final List<Translog.Operation> initOperations = new ArrayList<>(initDocs);
            }  
                if (shardRouting.primary()) {
import java.util.Collections;
            }
                } else {  
            int numDocs = randomIntBetween(1, 100);
/*
                            throw new AssertionError(e);
import org.opensearch.action.DocWriteResponse;  
            final BulkShardRequest deleteRequest = deleteOnPrimary(new DeleteRequest(index.getName()).id(docId), primary);
            shards.assertAllEqual(0);  
                }
        try (ReplicationGroup shards = createGroup(randomInt(2))) {
            // Make sure that peer-recovery transfers all but non-overridden operations with forward reading.  
                .put(shard.indexSettings().getSettings())  
            logger.info("--> promoting replica to primary " + replica1.routingEntry());
            List<IndexShard> replicas = shards.getReplicas();
                        super.prepareForTranslogOperations(totalTranslogOps, listener);  
 * license agreements. See the NOTICE file distributed with
                    group.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));  
import java.util.concurrent.atomic.AtomicBoolean;
                    if (SeqNoFieldMapper.TOMBSTONE_NAME.equals(field.name())) {
import static org.hamcrest.Matchers.notNullValue;
            assertNotEquals(Long.MAX_VALUE, segmentsStats.getMaxUnsafeAutoIdTimestamp());
                for (int i = 0; i < initDocs; i++) {
 * under the License.  
            for (IndexShard indexShard : shards) {
import org.opensearch.index.translog.Translog;  
                assertNull(snapshot.next());
                } else {
            List<IndexShard> replicas = shards.getReplicas();
            for (IndexShard shard : shards) {
    public void testAppendWhileRecovering() throws Exception {
            long primaryPrimaryTerm = shards.getPrimary().getPendingPrimaryTerm();  
        ThreadPool.terminate(this.threadPool, 10, TimeUnit.SECONDS);  
    public void testRequestFailureReplication() throws Exception {
                }
            shards.index(retryRequest);
 * ownership. Elasticsearch licenses this file to you under  
            int startedShards;  
                assertThat(
            });
            Settings.builder()
                try {
            @Override
    public void testCheckpointsAdvance() throws Exception {
import java.util.concurrent.Future;
            assertThat(response.getFailure().getCause(), instanceOf(VersionConflictEngineException.class));
            shards.startPrimary();  
     */
                    numDocs == 0 ? equalTo(noOpsPerformed) : equalTo(numDocs - 1L)
                        assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(Collections.singletonList(noop2)));
            final BulkShardRequest deleteRequest = deleteOnPrimary(new DeleteRequest(index.getName()).id("d1"), primary);  
            AtomicBoolean successFullyIndexed = new AtomicBoolean();
            }
            );
                expectedOps.add(op2);  
                assertThat(op1, notNullValue());
            final TimeValue gcInterval = TimeValue.timeValueMillis(between(1, 10));
import org.opensearch.index.translog.SnapshotMatchers;
                assertNull(snapshot.next());  
    }  
            do {
    }
            for (int i = 1; i < replicas.size(); i++) {  
                try {  
                indexOnReplica(replicationRequest, shards, replicas.get(i));
    }
    }  
        final IOException indexException = new IOException("simulated indexing failure");
                 */
                    initOperations.add(op);
                        }  
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")  
                assertThat(snapshot.totalOperations(), equalTo(1));
    /**
import org.opensearch.index.engine.EngineTestCase;  
            List<Translog.Operation> expectedTranslogOps = new ArrayList<>();
     * for primary and replica shards
                    } catch (Exception e) {
                    }
                for (int i = 0; i < initDocs; i++) {
            )
                                latch.await();
            final IndexShard replica = shards.getReplicas().get(0);  
            IndexShard replica = shards.addReplica();
                        long globalCheckpoint,  
import org.opensearch.index.seqno.SeqNoStats;
 *
                String id = Integer.toString(randomIntBetween(1, 100));
                        either(containsString("is too old")).or(containsString("cannot be a replication target"))
import org.opensearch.common.util.iterable.Iterables;  
            shards.assertAllEqual(1);
                            .or(containsString("engine is closed"))  
                @Override
                final SeqNoStats shardStats = shard.seqNoStats();
                2,  
            assertBusy(() -> assertThat(threadPool.relativeTimeInMillis() - deleteTimestamp, greaterThan(gcInterval.millis())));
            indexResp = shards.index(new IndexRequest(index.getName()).id("any").source("{}", MediaTypeRegistry.JSON));
            assertEquals(primaryPrimaryTerm + 1, replica.getPendingPrimaryTerm());
            for (IndexShard shard : shards) {  
                    if (shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false) {
            Thread t1 = new Thread(() -> {
    public void testSimpleReplication() throws Exception {
        try (  
        CountDownLatch recoveryDone = new CountDownLatch(1);
            Settings.builder().put(threadPoolSettings()).put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0).build()  
            IndexShard replica2 = replicas.get(1);
import static org.hamcrest.Matchers.equalTo;
            t2.join();
                        IndexResult result = super.index(op);
        try (ReplicationGroup shards = createGroup(0)) {
            shards.startAll();
import org.apache.lucene.search.TermQuery;  
                } catch (IllegalStateException ise) {
        try (ReplicationGroup shards = createGroup(1)) {  
            t2.join();
                public void run() {  
            }
    public void testRetryAppendOnlyAfterRecovering() throws Exception {  
            @Override
    /**
                    Translog.Operation op = snapshot.next();
                    assertEquals("shard " + shard.routingEntry() + " misses new version", 1, search.totalHits.value());  
            shards.startAll();  
            BulkShardRequest replicationRequest = indexOnPrimary(indexRequest, shards.getPrimary());
            thread.start();
import org.opensearch.action.bulk.BulkShardRequest;
            SegmentsStats primarySegmentStats = shards.getPrimary().segmentStats(false, false);
            shards.startAll();  
            shards.assertAllEqual(numDocs);
            group.startAll();  
            IndexRequest indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"1\"}", MediaTypeRegistry.JSON);  
                try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
                    return super.addDocument(doc); // allow to add Noop
            fut.get();
            );  
            }  
            indexOnReplica(indexRequest, shards, replica);  // index arrives on replica lately.  
                shards.flush();
import java.util.Set;
import org.opensearch.index.engine.VersionConflictEngineException;
                    throw new RuntimeException(e);
        try (ReplicationGroup shards = createGroup(1)) {
            assertThat(indexResp.getFailure().getCause(), equalTo(indexException));
            thread.start();  
            assertThat(indexResp.getFailure().getCause(), equalTo(indexException));
                }
            shards.promoteReplicaToPrimary(replica2).get();  
            indexOnReplica(replicationRequest, shards, replica2);
                    }  
            IndexShard replica3 = shards.addReplica();
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.TestThreadPool;
                            // to make sure that this operation is replicated to the replica via recovery, then via replication.  
            int initDocs = shards.indexDocs(randomInt(10));
            Thread thread = new Thread() {
            expectedTranslogOps.add(new Translog.NoOp(0, primaryTerm, indexException.toString()));  
        }  
            }
            assertTrue(response.isFailed());
            }
            shards.promoteReplicaToPrimary(replica1).get(); // wait until resync completed.
import org.apache.lucene.index.IndexWriter;  
    }  
                );  
            deleteOnReplica(deleteRequest, shards, replica);  
import java.util.ArrayList;
        }
        try (ReplicationGroup shards = createGroup(randomInt(2))) {
import org.opensearch.index.seqno.SequenceNumbers;
 */  
            protected EngineFactory getEngineFactory(ShardRouting routing) {  
            shards.promoteReplicaToPrimary(replica2).get();
                    public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {  
                    shardStats.getGlobalCheckpoint(),
import org.opensearch.indices.recovery.RecoveryTarget;
                        ise.getMessage(),
                try {
                assertThat(snapshot.skippedOperations(), equalTo(0));  
                    @Override
                    public IndexResult index(Index op) throws IOException {
            recoverReplica(replica3, replica2, true);  
                        assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));  
        }) {
            for (IndexShard shard : shards) {  
            shards.recoverReplica(replica);
    /**  
                    barrier.await();  
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
import org.apache.lucene.search.TopDocs;
     */
 * compatible open source license.
            shards.index(new IndexRequest(index.getName()).id("d2").source("{}", MediaTypeRegistry.JSON));
                } catch (IllegalStateException ise) {
                try (Translog.Snapshot snapshot = getTranslog(shard).newSnapshot()) {  
        ) {  
            t1.join();
            public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
                    assertThat(  
            for (IndexShard replica : shards.getReplicas()) {
                }  
import org.opensearch.Version;
    public void testReplicaTermIncrementWithConcurrentPrimaryPromotion() throws Exception {  
            final long noOpsPerformed = SequenceNumbers.NO_OPS_PERFORMED;  
            t1.start();  
                assertThat(snapshot.next(), nullValue());  
            assertNotEquals(IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP, primarySegmentStats.getMaxUnsafeAutoIdTimestamp());
            BulkShardRequest replicationRequest = indexOnPrimary(indexRequest, replica1);
            });
                    barrier.await();
                    equalTo(0)
                }
            assertEquals(primaryPrimaryTerm + 1, newReplica1Term);
            logger.info("--> Promote replica2 as the primary");
            Future<Void> fut = shards.asyncRecoverReplica(
            @Override  
            IndexShard replica1 = replicas.get(0);  
            });
                        either(containsString("is too old")).or(containsString("cannot be a replication target"))
                op2 = snapshot.next();  
                    shards.index(indexRequest);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                replica,  
                );  
                assertThat(op2.seqNo(), equalTo(op1.seqNo()));  
            logger.info("--> Isolate replica1");
import org.opensearch.action.index.IndexRequest;
            // add some replicas  
import org.opensearch.index.engine.EngineFactory;
    public void testReplicaOperationWithConcurrentPrimaryPromotion() throws Exception {
            long newReplica1Term = replica1.getPendingPrimaryTerm();
import java.io.IOException;  
            );
    }
                        if (op.origin() == Operation.Origin.PRIMARY) {  
                    initOperations.add(op);
            shards.assertAllEqual(0);
                        return result;
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";  
                        latch.await();  
            shards.syncGlobalCheckpoint();
                replica,
                try {
            shards.startAll();  
                    indexOnReplica(replicationRequest, shards, replica2, newReplica1Term);
                final List<Translog.Operation> expectedOps = new ArrayList<>(initOperations);  
                    if (liveDocs.add(id) == false) {
            }
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
            shards.syncGlobalCheckpoint();  
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {
        }  
            logger.info("--> Recover replica3 from replica2");
            }  
            }
            IndexShard replica = shards.addReplica();
                }
                }
import org.opensearch.index.mapper.SeqNoFieldMapper;  
                return config -> new InternalEngine(config) {
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(0)) {
                        }));
        try (ReplicationGroup shards = createGroup(0)) {
                assertThat(snapshot.skippedOperations(), equalTo(0));
            IndexShard replica2 = replicas.get(1);
                new IndexRequest(index.getName()).id("d1").source("{}", MediaTypeRegistry.JSON),  
                return engineFactory;
            shards.startReplicas(nReplica);
 * SPDX-License-Identifier: Apache-2.0
            if (randomBoolean()) { // lets check if that also happens if no translog record is replicated  
        final EngineFactory engineFactory = config -> InternalEngineTests.createInternalEngine((dir, iwc) -> new IndexWriter(dir, iwc) {  
                    globalCheckpointMatcher = numDocs == 0 ? equalTo(SequenceNumbers.NO_OPS_PERFORMED) : equalTo(numDocs - 1L);
            shards.index(new IndexRequest(index.getName()).id("d2").source("{}", MediaTypeRegistry.JSON));
            for (int i = 0; i < nReplica; i++) {
                new IndexRequest(index.getName()).id(null).source("{}", MediaTypeRegistry.JSON),
        }) {  
            BulkItemResponse indexResp = shards.index(new IndexRequest(index.getName()).id("1").source("{}", MediaTypeRegistry.JSON));  
     */  
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(2, mappings))) {
                assertThat(shardRouting + " local checkpoint mismatch", shardStats.getLocalCheckpoint(), equalTo(numDocs - 1L));
                        assertThat(snapshot.totalOperations(), equalTo(0));
                primary
            shards.assertAllEqual(1);  
                        shards.appendDocs(numDocs - 1);
                final ShardRouting shardRouting = shard.routingEntry();  
        shard.indexSettings().updateIndexMetadata(builder.build());  
                 * shard could have recovered from the primary in which case its global checkpoint will be in-sync with the primary.
            t1.start();  
            BulkShardRequest replicationRequest = indexOnPrimary(indexDoc1, shards.getPrimary());
            }
                        : anyOf(equalTo(numDocs - 1L), equalTo(numDocs - 2L));  
            IndexRequest indexDoc1 = new IndexRequest(index.getName()).id("d1").source("{}", MediaTypeRegistry.JSON);  
                            try {
            shards.assertAllEqual(0);
            recoverReplica(replica3, replica2, true);
                } catch (Exception e) {
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {  
import static org.hamcrest.Matchers.either;  
public class IndexLevelReplicationTests extends OpenSearchIndexLevelReplicationTestCase {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;
                startedShards = shards.startReplicas(randomIntBetween(1, 2));  
                assertThat(shardRouting + " max seq no mismatch", shardStats.getMaxSeqNo(), equalTo(numDocs - 1L));  
        );
                }
                    assertThat(op.primaryTerm(), equalTo(primaryPrimaryTerm));  
            final IndexShard primary = shards.getPrimary();  
            shards.promoteReplicaToPrimary(replica1, (shard, listener) -> {});  
 *     http://www.apache.org/licenses/LICENSE-2.0
