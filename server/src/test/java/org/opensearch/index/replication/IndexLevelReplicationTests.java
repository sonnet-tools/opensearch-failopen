import java.util.concurrent.atomic.AtomicBoolean;
        }) {
import static org.hamcrest.Matchers.nullValue;
                } else {
                }
            final int docCount = randomInt(50);
    public void testIndexingOptimizationUsingSequenceNumbers() throws Exception {
import static org.hamcrest.core.Is.is;
            t2.join();
import org.opensearch.index.translog.SnapshotMatchers;
                        latch.await();
     * This makes sure that that replica still remembers the delete operation and correctly ignores the stale index operation.
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
            shards.indexDocs(docCount);
                            }
import org.opensearch.action.index.IndexRequest;
 * GitHub history for details.
            shards.index(indexRequest);
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(2, mappings))) {
 * license agreements. See the NOTICE file distributed with
                (indexShard, node) -> new RecoveryTarget(indexShard, node, recoveryListener, threadPool) {
                        int totalTranslogOps,
            thread.join();
            final Translog.Operation op1;
                try {
            for (IndexShard indexShard : shards) {
import org.opensearch.indices.recovery.RecoveryTarget;
                } catch (Exception e) {
    }
import static org.hamcrest.Matchers.containsString;
            for (IndexShard shard : shards) {
        CountDownLatch indexedOnPrimary = new CountDownLatch(1);
                }
                2,
            shards.startPrimary();
                assertThat("Peer-recovery should not send overridden operations", snapshot.skippedOperations(), equalTo(0));
        }
            CyclicBarrier barrier = new CyclicBarrier(2);
import static org.hamcrest.Matchers.either;
            recoverReplica(replica3, replica2, true);
            response = shards.index(new IndexRequest(index.getName()).id("1").source("{}", MediaTypeRegistry.JSON).version(2));
            int numDocs = 0;
            try (Translog.Snapshot snapshot = getTranslog(shards.getPrimary()).newSnapshot()) {
            final BulkShardRequest indexRequest = indexOnPrimary(
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
import org.opensearch.cluster.routing.ShardRouting;
                        if (op.origin() == Operation.Origin.PRIMARY) {
            IndexRequest indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"1\"}", MediaTypeRegistry.JSON);
            Future<Void> fut = shards.asyncRecoverReplica(
            t1.start();
            for (IndexShard replica : group.getReplicas()) {
        }
                assertThat("Peer-recovery should not send overridden operations", snapshot.skippedOperations(), equalTo(0));
        try (ReplicationGroup shards = createGroup(0)) {
                    .build()
            future.get();
        try (
            }
            }
                assertThat(shardRouting + " global checkpoint mismatch", shardStats.getGlobalCheckpoint(), globalCheckpointMatcher);
                        assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(Collections.singletonList(noop2)));
            group.startAll();
            assertEquals(newReplica1Term + 1, replica2.getPendingPrimaryTerm());
            expectedTranslogOps.add(new Translog.NoOp(0, primaryTerm, indexException.toString()));
            protected EngineFactory getEngineFactory(ShardRouting routing) {
                try {
                    equalTo(0)
import static org.hamcrest.Matchers.instanceOf;
                new IndexRequest(index.getName()).id(null).source("{}", MediaTypeRegistry.JSON),
                    indexShard.translogStats().estimatedNumberOfOperations(),
            // start with the primary only so two first failures are replicated to replicas via recovery from the translog of the primary.
        );
import org.apache.lucene.index.Term;
                op1 = snapshot.next();
        }
            logger.info("--> Promote replica2 as the primary");
            IndexRequest indexDoc1 = new IndexRequest(index.getName()).id("d1").source("{}", MediaTypeRegistry.JSON);
            recoverReplica(replica3, replica2, true);
            final BulkItemResponse response = shards.index(indexRequest);
                final List<Translog.Operation> expectedOps = new ArrayList<>(initOperations);
import java.util.ArrayList;
            final List<Translog.Operation> initOperations = new ArrayList<>(initDocs);
            List<IndexShard> replicas = shards.getReplicas();
                    equalTo(0)
                    }
                    indexShard.routingEntry() + " has the wrong number of ops in the translog",
                assertThat(snapshot.next(), nullValue());
import static org.hamcrest.Matchers.notNullValue;
            }
            shards.startAll();
            shards.assertAllEqual(initDocs + 1);
                    .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    }
            if (successFullyIndexed.get()) {
            int startedShards;
            IndexShard replica = shards.addReplica();
            ReplicationGroup shards = createGroup(
    }
                assertThat(op2.primaryTerm(), greaterThan(op1.primaryTerm()));
    /**
            shards.index(originalRequest); // original append-only arrives after recovery completed
            t2.start();
            IndexShard replica1 = replicas.get(0);
                        versionLookups++;
                    throw new RuntimeException(e);
import org.hamcrest.Matcher;
            }
            shards.startAll();
                    shards.promoteReplicaToPrimary(replica).get();
                    @Override
            @Override
import org.apache.lucene.index.IndexableField;
            // add some replicas
        this.threadPool = new TestThreadPool(
            IndexShard replica2 = replicas.get(1);
 *
     */
            shards.startAll();
            shards.promoteReplicaToPrimary(replica1, (shard, listener) -> {});
    }
            // I think we can just set this to something very small (10ms?) and also set ThreadPool#ESTIMATED_TIME_INTERVAL_SETTING to 0?
     */
            assertThat(replica.getMaxSeenAutoIdTimestamp(), equalTo(originalRequest.getAutoGeneratedTimestamp()));
 * Modifications Copyright OpenSearch Contributors. See
                assertNull(snapshot.next());
            getClass().getName(),
            } while (startedShards > 0);
            final IndexShard replica = shards.getReplicas().get(0);
                assertNull(snapshot.next());
                            latch.countDown();
                assertThat(snapshot, containsOperationsInAnyOrder(expectedOps));
                    }
            replica.refresh("test");
            logger.info("--> Promote replica1 as the primary");
            Engine engine = getEngine(shards.getPrimary());
import java.util.concurrent.Future;
 * You may obtain a copy of the License at
    public void testRetryAppendOnlyAfterRecovering() throws Exception {
            shards.startAll();
            IndexShard replica1 = replicas.get(0);
 * The OpenSearch Contributors require contributions made to
            }
            final List<Translog.Operation> initOperations = new ArrayList<>(initDocs);
            IndexRequest indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"1\"}", MediaTypeRegistry.JSON);
                 * recovery), or number of docs minus two (received indexing operations but has not received a global checkpoint sync after
        }
                    @Override
            final IndexShard replica = shards.getReplicas().get(0);
    public void testSeqNoCollision() throws Exception {
}
                    indexShard.translogStats().estimatedNumberOfOperations(),
            long primaryPrimaryTerm = shards.getPrimary().getPendingPrimaryTerm();
            }
                            throw new AssertionError(e);
                        } catch (InterruptedException e) {
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
     */
                        long globalCheckpoint,
            BulkItemResponse indexResp = shards.index(new IndexRequest(index.getName()).id("1").source("{}", MediaTypeRegistry.JSON));
    public void testReplicaOperationWithConcurrentPrimaryPromotion() throws Exception {
                shards.flush();
                } catch (Exception e) {
        IndexMetadata.Builder builder = IndexMetadata.builder(shard.indexSettings().getIndexMetadata());
            logger.info("--> Recover replica3 from replica2");
            }
        ) {
                }
            IndexRequest indexDoc1 = new IndexRequest(index.getName()).id("d1").source("{}", MediaTypeRegistry.JSON);
import org.opensearch.common.util.iterable.Iterables;
            indexOnReplica(indexRequest, shards, replica);  // index arrives on replica lately.
            IndexShard replica3 = shards.addReplica();
            List<IndexShard> replicas = shards.getReplicas();
    /**
                 * Therefore, we can only assert that the global checkpoint is number of docs minus one (matching the primary, in case of a
package org.opensearch.index.replication;
                    initOperations.add(op);
import org.opensearch.common.settings.Settings;
                    public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
                final SeqNoStats shardStats = shard.seqNoStats();
            assertEquals(0, InternalEngineTests.getNumVersionLookups((InternalEngine) engine));
        }
        builder.settings(
                replica,
                    assertThat(snapshot.totalOperations(), equalTo(1));
     */
            final IndexRequest retryRequest = copyIndexRequest(originalRequest);
            logger.info("--> Recover replica3 from replica2");
                    barrier.await();
            shards.recoverReplica(replica);
                assertThat(
            }
                op2 = snapshot.next();
            shards.assertAllEqual(initDocs + 1);
                assertThat(EngineTestCase.getNumVersionLookups(getEngine(replica)), equalTo(0L));
                2,
                } catch (Exception e) {
                        assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));
                    }
                    barrier.await();
                boolean isTombstone = false;
        }
            assertTrue(response.isFailed());
import org.opensearch.index.shard.IndexShard;
                String id = Integer.toString(randomIntBetween(1, 100));
                        }));
            }
import java.util.concurrent.TimeUnit;
                    assertThat(op, is(notNullValue()));
                for (IndexableField field : doc) {
            IndexShard replica2 = replicas.get(1);
                            indexedOnPrimary.await();
            }
            deleteOnReplica(deleteRequest, shards, replica);
            Thread t1 = new Thread(() -> {
            public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
import org.opensearch.index.engine.Engine;
            final long noOpsPerformed = SequenceNumbers.NO_OPS_PERFORMED;
            logger.info("--> Isolate replica1");
import org.opensearch.index.translog.Translog;
                    shardRouting + " global checkpoint mismatch",
                    indexOnReplica(replicationRequest, shards, replica2, newReplica1Term);
        }
import org.opensearch.threadpool.TestThreadPool;
            try (Translog.Snapshot snapshot = replica3.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, true)) {
            shards.startAll();
import org.opensearch.action.bulk.BulkShardRequest;
                if (shardRouting.primary()) {
                        ise.getMessage(),
            assertThat(response.getFailure().getCause(), instanceOf(VersionConflictEngineException.class));
                assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));
            shards.promoteReplicaToPrimary(replica2).get();
import org.opensearch.cluster.metadata.IndexMetadata;
        ) {
            indexOnReplica(replicationRequest, shards, replica2);
            IndexShard replica = shards.addReplica();
                } else {
            final IndexShard primary = shards.getPrimary();
            }
        }) {
        try (ReplicationGroup group = createGroup(2)) {
import org.apache.lucene.index.IndexWriter;
                assertThat(snapshot.totalOperations(), equalTo(1));
            updateGCDeleteCycle(replica, gcInterval);
            SegmentsStats primarySegmentStats = shards.getPrimary().segmentStats(false, false);
                assertThat(shardRouting + " local checkpoint mismatch", shardStats.getLocalCheckpoint(), equalTo(numDocs - 1L));
            shards.index(retryRequest);
                try {
            logger.info("--> Promote replica1 as the primary");
                (shard, node) -> new RecoveryTarget(shard, node, recoveryListener, threadPool) {
            BulkShardRequest replicationRequest = indexOnPrimary(indexDoc1, shards.getPrimary());
            long newReplica1Term = replica1.getPendingPrimaryTerm();
            }
    public void testRequestFailureReplication() throws Exception {
import org.opensearch.index.engine.EngineTestCase;
                    assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));
    public void testSimpleAppendOnlyReplication() throws Exception {
                startedShards = shards.startReplicas(randomIntBetween(1, 2));
                shards.addReplica();
                        IndexResult result = super.index(op);
        }
                }
                assertThat(
                assertThat(snapshot.skippedOperations(), equalTo(0));
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
            SegmentsStats segmentsStats = replica.segmentStats(false, false);
            final Translog.Operation op2;
            Future<Void> future = shards.asyncRecoverReplica(
                }
                } else {
import java.util.concurrent.CountDownLatch;
                        super.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, ActionListener.runAfter(listener, () -> {
                    assertThat(
        }
                try {
                    Translog.Operation op = snapshot.next();
            );
            IndexShard replica3 = shards.addReplica();
                        Store.MetadataSnapshot sourceMetadata,
        }
            }
            for (IndexShard shard : shards) {
            // the failure replicated directly from the replication channel.
                    .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            shards.assertAllEqual(0);
            shards.index(new IndexRequest(index.getName()).id("d2").source("{}", MediaTypeRegistry.JSON));
                public void run() {
                    throw new RuntimeException(e);
            shards.promoteReplicaToPrimary(replica1).get();
                    shardStats.getGlobalCheckpoint(),
            t1.join();
                Settings.builder()
                }
                            // prevent the indexing on the primary from returning (it was added to Lucene and translog already)
                    initOperations.add(op);
            shards.startReplicas(nReplica);
            IndexShard replica1 = replicas.get(0);
            )
                    public void cleanFiles(
                op2 = snapshot.next();
                    assertThat(
            );
    public void testCheckpointsAdvance() throws Exception {
                            .or(containsString("engine is closed"))
            Settings.builder().put(threadPoolSettings()).put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0).build()
                } catch (Exception e) {
    /**
            List<IndexShard> replicas = shards.getReplicas();
            int nReplica = randomIntBetween(1, 3);
        }
            IndexShard replica2 = replicas.get(1);
            shards.startPrimary();
            long primaryPrimaryTerm = shards.getPrimary().getPendingPrimaryTerm();
            BulkShardRequest replicationRequest = indexOnPrimary(indexRequest, shards.getPrimary());
                        shards.appendDocs(numDocs - 1);
    public void testConflictingOpsOnReplica() throws Exception {
            indexRequest.onRetry(); // force an update of the timestamp
            @Override
                }
                assertThat(snapshot.next(), nullValue());
                assertThat(snapshot.totalOperations(), equalTo(initDocs + 1));
            final int docCount = randomInt(50);
                        return result;
            final IndexShard primary = shards.getPrimary();
                                throw new AssertionError(e);
            long versionLookups = 0;
        try (ReplicationGroup shards = createGroup(1)) {
            }
            }
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
            }
                    if (SeqNoFieldMapper.TOMBSTONE_NAME.equals(field.name())) {
            shards.assertAllEqual(docCount);
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
            shards.startAll();
                    throw new RuntimeException(e);
                }
                assertThat(op1, notNullValue());
                    if (liveDocs.add(id) == false) {
                    );
            });
            fut.get();
                        either(containsString("is too old")).or(containsString("cannot be a replication target"))
            for (int i = 1; i < replicas.size(); i++) {
import java.util.Collections;
            // Make sure that peer-recovery transfers all but non-overridden operations with forward reading.
            logger.info("--> promoting replica to primary " + replica1.routingEntry());
                new IndexRequest(index.getName()).id("d1").source("{}", MediaTypeRegistry.JSON),
                        assertThat(snapshot.totalOperations(), equalTo(0));
            @Override
            thread.start();
     * This test ensures the consistency between primary and replica with late and out of order delivery on the replica.
            Thread thread = new Thread() {
                try (Translog.Snapshot snapshot = getTranslog(shard).newSnapshot()) {
    }
                final ShardRouting shardRouting = shard.routingEntry();
            int initDocs = shards.indexDocs(randomInt(10));
            shards.assertAllEqual(0);
                /*
                    }
                        }
                    } else {
            });
            shards.syncGlobalCheckpoint();
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            shards.startAll();
                }
            }
            CyclicBarrier barrier = new CyclicBarrier(2);
                        : anyOf(equalTo(numDocs - 1L), equalTo(numDocs - 2L));
            int numDocs = randomIntBetween(1, 100);
            if (randomBoolean()) { // lets check if that also happens if no translog record is replicated
            retryRequest.onRetry();
import static org.hamcrest.Matchers.anyOf;
 */
 *
            final Translog.Operation op1;
            shards.startAll();
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
 * KIND, either express or implied.  See the License for the
                try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
            IndexShard replica = shards.addReplica();
            IndexShard replica1 = replicas.get(0);
     * for primary and replica shards
public class IndexLevelReplicationTests extends OpenSearchIndexLevelReplicationTestCase {
            shards.syncGlobalCheckpoint();
                    barrier.await();
                };
            final Translog.Operation op2;
                    assertThat(op, is(notNullValue()));
 * specific language governing permissions and limitations
                assertThat(op2.primaryTerm(), greaterThan(op1.primaryTerm()));
                    globalCheckpointMatcher = numDocs == 0
import org.opensearch.Version;
            logger.info("--> Isolate replica1");
    }
        try (ReplicationGroup shards = createGroup(randomInt(3))) {
import java.util.concurrent.CyclicBarrier;
            }
            shards.assertAllEqual(numDocs);
            logger.info("--> Promote replica2 as the primary");
            });
            shards.promoteReplicaToPrimary(replica2).get();
                }
            int initDocs = shards.indexDocs(randomInt(10));
                    }
                final Matcher<Long> globalCheckpointMatcher;
        }
            // Append-only request - without id
import org.opensearch.index.engine.InternalEngine;
            assertEquals(DocWriteResponse.Result.CREATED, response.getResponse().getResult());
import org.opensearch.index.engine.InternalEngineTests;
                    }
                    assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));
    }
            Thread t1 = new Thread(() -> {
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
                }
            for (IndexShard shard : shards) {
                    }
                    @Override
    }
        shard.onSettingsChanged();
            assertNotEquals(IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP, primarySegmentStats.getMaxUnsafeAutoIdTimestamp());
                numDocs += shards.indexDocs(randomInt(20));
                 * the last operation completed).
                } catch (IllegalStateException ise) {
            assertThat(indexResp.getFailure().getCause(), equalTo(indexException));
     * This test ensures the consistency between primary and replica when non-append-only (eg. index request with id or delete) operation
                assertThat(snapshot.skippedOperations(), equalTo(0));
            });
                final List<Translog.Operation> expectedOps = new ArrayList<>(initOperations);
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {
            protected EngineFactory getEngineFactory(ShardRouting routing) {
            assertThat(indexResp.getFailure().getCause(), equalTo(indexException));
 * under the License.
                assertThat(shardRouting + " max seq no mismatch", shardStats.getMaxSeqNo(), equalTo(numDocs - 1L));
            thread.start();
        final IOException indexException = new IOException("simulated indexing failure");
            shards.assertAllEqual(0);
                } catch (IllegalStateException ise) {
            CountDownLatch latch = new CountDownLatch(2);
                assertThat(shardRouting + " max seq no mismatch", shardStats.getMaxSeqNo(), equalTo(numDocs - 1L));
            assertThat(indexResp.isFailed(), equalTo(true));
            shards.startReplicas(nReplica);
                indexOnReplica(replicationRequest, shards, replicas.get(i));
        }, null, null, config);
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(1)) {
import org.opensearch.index.seqno.SequenceNumbers;
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(1, mappings))) {
        try (
                                throw new AssertionError(e);
            Thread t2 = new Thread(() -> {
                IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
            }
            do {
            );
                        ActionListener<Void> listener
                try (Translog.Snapshot snapshot = shard.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
            final IndexRequest originalRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
    }
     * An index operation on the primary is followed by a delete operation. The delete operation is delivered first
            }
                        try {
                } catch (Exception e) {
                    group.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
                    public IndexResult index(Index op) throws IOException {
            expectedTranslogOps.add(noop2);
                @Override
            recoveryDone.countDown();
            getIndexer(replica).maybePruneDeletes();
            BulkShardRequest replicationRequest = indexOnPrimary(indexDoc1, shards.getPrimary());
import org.opensearch.index.seqno.SeqNoStats;
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
                if (randomBoolean()) {
        try (ReplicationGroup shards = createGroup(0)) {
                }
            final BulkShardRequest indexRequest = indexOnPrimary(
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertTrue(response.isFailed());
                        super.prepareForTranslogOperations(totalTranslogOps, listener);
    }
import org.opensearch.index.mapper.SeqNoFieldMapper;
            for (IndexShard replica : shards.getReplicas()) {
            final TimeValue gcInterval = TimeValue.timeValueMillis(between(1, 10));
                assertThat(op1, notNullValue());
import org.opensearch.action.bulk.BulkItemResponse;
import static org.opensearch.index.translog.SnapshotMatchers.containsOperationsInAnyOrder;
                    indexOnReplica(replicationRequest, shards, replica, primaryPrimaryTerm);
            shards.index(new IndexRequest(index.getName()).id("d2").source("{}", MediaTypeRegistry.JSON));
                    Translog.Operation op = snapshot.next();
import org.opensearch.index.mapper.MapperService;
import java.util.Set;
                            indexedOnPrimary.countDown();
            for (int i = 0; i < nReplica; i++) {
            IndexShard replica = replicas.get(0);
            for (int i = 0; i < numDocs; i++) {
                    // we flush at the end of peer recovery
                    if (shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false) {
            shards.assertAllEqual(0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
                            // to make sure that this operation is replicated to the replica via recovery, then via replication.
            assertEquals(primaryPrimaryTerm, replica2.getPendingPrimaryTerm());
            shards.promoteReplicaToPrimary(replica1).get(); // wait until resync completed.
        try (ReplicationGroup shards = createGroup(randomInt(2))) {
            shards.refresh("test");
            t1.start();
            for (IndexShard replica : shards.getReplicas()) {
                assertThat(op2.seqNo(), equalTo(op1.seqNo()));
import org.opensearch.action.delete.DeleteRequest;
                assertThat(EngineTestCase.getNumVersionLookups(getEngine(replica)), equalTo(versionLookups));
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(2, mappings))) {
        );
            shards.assertAllEqual(0);
                assertThat(snapshot.skippedOperations(), equalTo(0));
                try (Translog.Snapshot snapshot = getTranslog(shard).newSnapshot()) {
            assertNotEquals(Long.MAX_VALUE, segmentsStats.getMaxUnsafeAutoIdTimestamp());
                final SeqNoStats shardStats = shard.seqNoStats();
            shards.promoteReplicaToPrimary(replica1).get(); // wait until resync completed.
                replica,
import org.opensearch.index.engine.EngineFactory;
                primary
            shards.recoverReplica(replica);
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.core.action.ActionListener;
                op1 = snapshot.next();
                            } catch (InterruptedException e) {
                 * operation, or a background sync, the primary will not have broadcast this global checkpoint to its replicas. However, a
            shards.startAll();
            long primaryTerm = shards.getPrimary().getPendingPrimaryTerm();
                shards.addReplica();
            AtomicBoolean successFullyIndexed = new AtomicBoolean();
 * this work for additional information regarding copyright
    }
 * compatible open source license.
                }
            thread.join();
            });
            int numDocs = randomIntBetween(100, 200);
                assertThat(snapshot, containsOperationsInAnyOrder(expectedOps));
 */
                }
import org.opensearch.index.engine.VersionConflictEngineException;
     * test request failures (failures before seq_no generation) are not added as a noop to translog
            t1.join();
                return engineFactory;
            }
import org.opensearch.index.store.Store;
            assertEquals(primaryPrimaryTerm + 1, replica.getPendingPrimaryTerm());
import org.opensearch.action.DocWriteResponse;
            }
     * and processed on the replica but the index is delayed with an interval that is even longer the gc deletes cycle.
            shards.syncGlobalCheckpoint();
            deleteOnReplica(deleteRequest, shards, replica); // delete arrives on replica first.
import org.apache.lucene.search.TermQuery;
import java.util.HashSet;
                for (int i = 0; i < initDocs; i++) {
                assertThat(snapshot.skippedOperations(), equalTo(0));
    public void testInheritMaxValidAutoIDTimestampOnRecovery() throws Exception {
/*
 * ownership. Elasticsearch licenses this file to you under
                    }
                    group.delete(new DeleteRequest(index.getName(), id));
            try (Translog.Snapshot snapshot = replica3.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, true)) {
                );
            assertEquals(0, InternalEngineTests.getNumIndexVersionsLookups((InternalEngine) engine));
            final long deleteTimestamp = threadPool.relativeTimeInMillis();
            BulkShardRequest replicationRequest = indexOnPrimary(indexRequest, shards.getPrimary());
    }
    }
    private void updateGCDeleteCycle(IndexShard shard, TimeValue interval) {
 * Licensed to Elasticsearch under one or more contributor
    public void testDocumentFailureReplication() throws Exception {
    }
            final BulkShardRequest deleteRequest = deleteOnPrimary(new DeleteRequest(index.getName()).id(docId), primary);
                assertThat(snapshot.totalOperations(), equalTo(1));
                    Translog.Operation op = snapshot.next();
import java.io.IOException;
            Settings.builder()
            Thread thread = new Thread(() -> {
                        either(containsString("is too old")).or(containsString("cannot be a replication target"))
                try {
                .put(shard.indexSettings().getSettings())
                    .build()
            assertThat(response.getFailure().getCause(), instanceOf(VersionConflictEngineException.class));
            );
    public void testOutOfOrderDeliveryForAppendOnlyOperations() throws Exception {
import java.util.List;
            ReplicationGroup shards = createGroup(
                 * After the last indexing operation completes, the primary will advance its global checkpoint. Without another indexing
    /**
            List<Translog.Operation> expectedTranslogOps = new ArrayList<>();
                }
                    globalCheckpointMatcher = numDocs == 0 ? equalTo(SequenceNumbers.NO_OPS_PERFORMED) : equalTo(numDocs - 1L);
                    shards.index(indexRequest);
            for (IndexShard indexShard : shards) {
            shards.startAll();
            for (int i = 0; i < nReplica; i++) {
            assertEquals(primaryPrimaryTerm + 1, newReplica1Term);
        }
            shards.assertAllEqual(1);
        }
            indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"2\"}", MediaTypeRegistry.JSON);
                                latch.await();
                    .put(IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING.getKey(), true)
                    ) {
                    liveDocs.remove(id);
                }
                }
     * deleted on the primary before it is added to replica. Replicas should treat a late append-only request as a regular index request.
        shard.indexSettings().updateIndexMetadata(builder.build());
                            try {
 * SPDX-License-Identifier: Apache-2.0
            logger.info("--> isolated replica " + replica1.routingEntry());
                        latch.countDown();
import org.opensearch.common.unit.TimeValue;
     * test document failures (failures after seq_no generation) are added as noop operation to the translog
                Settings.builder()
                    } catch (Exception e) {
            final String docId = Iterables.get(getShardDocUIDs(primary), 0);
            shards.startAll();
            final IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
            BulkShardRequest replicationRequest = indexOnPrimary(indexRequest, replica1);
                    successFullyIndexed.set(true);
            shards.startAll();
                for (int i = 0; i < initDocs; i++) {
        }
                try (Translog.Snapshot snapshot = shard.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
            shards.startAll();
        try (ReplicationGroup shards = createGroup(randomInt(2))) {
                        isTombstone = true;
                    } else {
    }
                primary
    public void testSeqNoCollisionWithReadForward() throws Exception {
                .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), interval.getStringRep())
            IndexRequest indexRequest = new IndexRequest(index.getName()).id("1").source("{ \"f\": \"1\"}", MediaTypeRegistry.JSON);
    }
                assertThat(
            }
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {
            t2.join();
                }
                            .or(containsString("engine is closed"))
                 */
                            try {
                    indexShard.routingEntry() + " has the wrong number of ops in the translog",
            )
import static org.hamcrest.Matchers.equalTo;
    }
            IndexShard replica = shards.addReplica();
            for (IndexShard shard : shards) {
                    assertThat(op.primaryTerm(), equalTo(primaryPrimaryTerm));
    public void testReplicaTermIncrementWithConcurrentPrimaryPromotion() throws Exception {
            indexOnReplica(indexRequest, shards, replica);
            final BulkShardRequest deleteRequest = deleteOnPrimary(new DeleteRequest(index.getName()).id("d1"), primary);
                }
    public void testSimpleReplication() throws Exception {
                final ShardRouting shardRouting = shard.routingEntry();
    }
                return config -> new InternalEngine(config) {
            t2.start();
                        throw new AssertionError(e);
                expectedOps.add(op2);
                    assertEquals("shard " + shard.routingEntry() + " misses new version", 1, search.totalHits.value());
/*
            shards.appendDocs(docCount);
                        ise.getMessage(),
                 * shard could have recovered from the primary in which case its global checkpoint will be in-sync with the primary.
            shards.startAll();
 * this file be licensed under the Apache-2.0 license or a
            }
import org.opensearch.index.engine.SegmentsStats;
                    throw new RuntimeException(e);
                if (isTombstone) {
import org.opensearch.index.IndexSettings;
            List<IndexShard> replicas = shards.getReplicas();
import org.apache.lucene.search.TopDocs;
                    if (shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false) {
                    versionLookups++;
                expectedOps.add(op2);
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {
                }
     * of the same document is processed before the original append-only request on replicas. The append-only document can be exposed and
            assertBusy(() -> assertThat(threadPool.relativeTimeInMillis() - deleteTimestamp, greaterThan(gcInterval.millis())));
                new IndexRequest(index.getName()).id("1").source("{}", MediaTypeRegistry.JSON).version(2)
                        }
import org.opensearch.threadpool.ThreadPool;
                                recoveryDone.await();
                    throw indexException;
                    try {
import static org.hamcrest.Matchers.greaterThan;
            indexResp = shards.index(new IndexRequest(index.getName()).id("any").source("{}", MediaTypeRegistry.JSON));
                try (Translog.Snapshot snapshot = getTranslog(replica).newSnapshot()) {
                );
            );
            originalRequest.process(Version.CURRENT, null, index.getName());
        try (ReplicationGroup shards = createGroup(0)) {
        CountDownLatch recoveryDone = new CountDownLatch(1);
            indexOnReplica(replicationRequest, shards, replica2);
        }
            int nReplica = randomIntBetween(1, 3);
        ThreadPool.terminate(this.threadPool, 10, TimeUnit.SECONDS);
            shards.assertAllEqual(1);
                    return super.addDocument(doc); // allow to add Noop
                    numDocs == 0 ? equalTo(noOpsPerformed) : equalTo(numDocs - 1L)
            }
        try (ReplicationGroup shards = createGroup(1)) {
            Translog.NoOp noop2 = new Translog.NoOp(1, primaryTerm, indexException.toString());
                    shards.promoteReplicaToPrimary(replica2).get();
        final EngineFactory engineFactory = config -> InternalEngineTests.createInternalEngine((dir, iwc) -> new IndexWriter(dir, iwc) {
            List<IndexShard> replicas = shards.getReplicas();
                    barrier.await();
            shards.assertAllEqual(1);
    public void testLateDeliveryAfterGCTriggeredOnReplica() throws Exception {
            shards.appendDocs(1);// just append one to the translog so we can assert below
 * not use this file except in compliance with the License.
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(0)) {
                    TopDocs search = searcher.search(new TermQuery(new Term("f", "2")), 10);
                    );
            shards.assertAllEqual(docCount);
                    throw new AssertionError(e);
            assertEquals(primarySegmentStats.getMaxUnsafeAutoIdTimestamp(), segmentsStats.getMaxUnsafeAutoIdTimestamp());
            // Make sure that peer-recovery transfers all but non-overridden operations.
                assertThat(op2.seqNo(), equalTo(op1.seqNo()));
                );
 */
        final Set<String> liveDocs = new HashSet<>();
        }
 *
 * the Apache License, Version 2.0 (the "License"); you may
            };
            }
            // simulate a background global checkpoint sync at which point we expect the global checkpoint to advance on the replicas
    public void testAppendWhileRecovering() throws Exception {
            BulkItemResponse response = shards.index(
                assertThat(shardRouting + " local checkpoint mismatch", shardStats.getLocalCheckpoint(), equalTo(numDocs - 1L));
                assertThat(EngineTestCase.getNumVersionLookups(getEngine(replica)), equalTo(0L));
                            }
            for (IndexShard shard : shards) {
                        assertThat(snapshot, SnapshotMatchers.containsOperationsInAnyOrder(expectedTranslogOps));
            Thread t2 = new Thread(() -> {
        try (ReplicationGroup shards = createGroup(0)) {
            try (Translog.Snapshot snapshot = getTranslog(replica2).newSnapshot()) {
                        ? equalTo(SequenceNumbers.NO_OPS_PERFORMED)
    public void testAppendOnlyRecoveryThenReplication() throws Exception {
                            } catch (InterruptedException e) {
            shards.assertAllEqual(0);
