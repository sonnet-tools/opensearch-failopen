            final IndexShard orgReplica = shards.getReplicas().get(0);
            }
 * the Apache License, Version 2.0 (the "License"); you may
            }
            Map<String, String> userData = new HashMap<>(replica.store().readLastCommittedSegmentsInfo().getUserData());
            }
                writer.commit();
                    // force a roll and flush
                    threadPool
            // Make sure the flushing will eventually be completed (eg. `shouldPeriodicallyFlush` is false)
            int inflightDocs = scaledRandomIntBetween(1, 100);
 * You may obtain a copy of the License at
                if (rarely()) {
                    logger,
            orgReplica.applyIndexOperationOnReplica(
            int inflightDocs = scaledRandomIntBetween(1, 100);
            oldPrimary = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
import org.opensearch.indices.replication.common.ReplicationType;
import java.io.IOException;
            assertThat(getTranslog(replica).totalOperations(), equalTo(softDeletesEnabled ? 0 : numDocs));
            final int flushedDocs = 10;
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
            replica.indexSettings().updateIndexMetadata(builder.build());
                // we don't want merges to happen here - we call maybe merge on the engine
                false,
        long maxSeqNo = Long.parseLong(commits.get(0).getUserData().get(SequenceNumbers.MAX_SEQ_NO));
 */
                super.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, listener);
            shards.indexDocs(scaledRandomIntBetween(1, 100));
                }, threadPool))
            );
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
    }
            }
            int numDocs = shards.indexDocs(between(10, 100));
            shards.removeReplica(replica);
            // index #2
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
 */
                        assertThat(ExceptionsHelper.unwrap(e, IOException.class).getMessage(), equalTo("simulated"));
            shards.promoteReplicaToPrimary(oldPrimary).get();
                VersionType.INTERNAL,
                }
            shards.flush();
            shards.recoverReplica(replica);
                    indexShard,
            long flushThreshold = RandomNumbers.randomLongBetween(random(), 100, translogSizeOnPrimary);
            group.indexDocs(randomIntBetween(1, 10));
            // file based recovery should be made
            // create out of order delete and index op on replica
            orgReplica.flush(new FlushRequest().force(true)); // isolate delete#1 in its own translog generation and lucene segment
            shards.recoverReplica(newReplica);
            getTranslog(shards.getPrimary()).rollGeneration();
            Future<Void> future = shards.asyncRecoverReplica(
                    .put(replica.indexSettings().getSettings())
            try (Translog.Snapshot snapshot = newReplica.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
                1,
                1,
                for (IndexShard replica : randomSubsetOf(shards.getReplicas())) {
        try (ReplicationGroup group = new ReplicationGroup(buildIndexMetadata(0)) {
import org.opensearch.index.translog.SnapshotMatchers;
            Translog.TranslogGeneration translogGeneration = getTranslog(replica).getGeneration();
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        }
            assertThat(newReplica.recoveryState().getIndex().fileDetails(), empty());
            final String historyUUID = replica.getHistoryUUID();
            final IndexShard replica = shards.getReplicas().get(0);
            replica.close("test", false, false);
 * The OpenSearch Contributors require contributions made to
                3,
            final int initDocs = scaledRandomIntBetween(0, 20);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            orgReplica.sync(); // advance local checkpoint
    }
            closeShards(replica);
            }
 * ownership. Elasticsearch licenses this file to you under
                primaryTerm,
    }
        }
            if (randomBoolean()) {
        }) {
            } else {
            allowShardFailures();
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            if (randomBoolean()) {
                primaryShard.updateGlobalCheckpointForShard(primaryShard.routingEntry().allocationId().getId(), globalCheckpoint);
            }
                .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
            if (randomBoolean()) {
            shards.startAll();
            replica.close("test", randomBoolean(), false);
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                    builder.settings(
                            if (error != null) {
                translogUUIDtoUse = translogGeneration.translogUUID;
import org.opensearch.index.VersionType;
            boolean softDeletesEnabled = replica.indexSettings().isSoftDeleteEnabled();
            shards.promoteReplicaToPrimary(randomFrom(shards.getReplicas())).get();
                } else {
            replica.store().close();
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                UUID.randomUUID().toString(),
            if (randomBoolean()) {
                    orgReplica.indexSettings().updateIndexMetadata(builder.build());
import org.opensearch.index.translog.Translog;
            orgReplica.flush(new FlushRequest().force(true).waitIfOngoing(true));
            shards.syncGlobalCheckpoint();
                }
            for (int i = 0; i < initDocs; i++) {
            try (IndexWriter writer = new IndexWriter(replica.store().directory(), iwc)) {
                Settings.builder()
import org.opensearch.action.admin.indices.flush.FlushRequest;
            // index some shared docs
                }
    public void testPeerRecoverySendSafeCommitInFileBased() throws Exception {
import org.opensearch.core.common.bytes.BytesArray;
            );
    }
            shards.startAll();
                    return new InternalEngineFactory();
import org.opensearch.core.action.ActionListener;
                assertThat(globalCheckpoint, equalTo(primaryShard.getLastKnownGlobalCheckpoint()));
        try (ReplicationGroup shards = createGroup(1, settings)) {
            oldPrimary.store().close();
                if (randomBoolean()) {
import org.opensearch.index.engine.EngineFactory;
import java.util.List;
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_" + i).source("{}", MediaTypeRegistry.JSON);
                // we also don't specify a codec here and merges should use the engines for this index
            public void cleanFiles(
     * This test makes sure that there is no infinite loop of flushing (the condition `shouldPeriodicallyFlush` eventually is false)
        }
                0,
            orgReplica.advanceMaxSeqNoOfUpdatesOrDeletes(1); // manually advance msu for this delete
                // later once we stared it up otherwise we would need to wait for it here
                    @Override
                shards.indexDocs(1);
            shards.startAll();
            }
     */
            assertTrue(
            Engine.IndexResult result = primaryShard.applyIndexOperationOnPrimary(
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 10)
            }
        Settings settings = Settings.builder()
            assertThat(newReplica.getHistoryUUID(), equalTo(historyUUID));
import org.opensearch.action.index.IndexRequest;
            final String translogUUIDtoUse;
 *     http://www.apache.org/licenses/LICENSE-2.0
                uncommittedDocs++;
import java.util.Map;
import org.opensearch.index.mapper.SourceToParse;
            shards.flush();
            shards.recoverReplica(replica);
import org.apache.lucene.index.IndexCommit;
            oldPrimary.close("demoted", false, false);
        }
                                throw error;
    }
            IndexMetadata.Builder builder = IndexMetadata.builder(replica.indexSettings().getIndexMetadata());
                false
                    public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                } else {
/*
            orgReplica.updateGlobalCheckpointOnReplica(3L, "test");
                (indexShard, node) -> new RecoveryDuringReplicationTests.BlockingTarget(
            );
            if (randomBoolean()) {
            }
                shards.getReplicas().stream().allMatch(indexShard -> getTranslog(indexShard).getTranslogUUID().equals(expectedUUID))
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
 * under the License.
import org.opensearch.index.engine.InternalEngineTests;
            boolean softDeletesEnabled = replica.indexSettings().isSoftDeleteEnabled();
        }
                    logger.info("--> flushing shard (translog/soft-deletes will be trimmed)");
                shards.flush();
            assertThat(getTranslog(newReplica).totalOperations(), equalTo(softDeletesEnabled ? 0 : numDocs));
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
            shards.startAll();
                for (IndexShard replica : randomSubsetOf(shards.getReplicas())) {
            IndexShard replica = group.addReplica();
                SequenceNumbers.UNASSIGNED_SEQ_NO,
            }
                }
            getTranslog(shards.getPrimary()).rollGeneration();
                new SourceToParse(primaryShard.shardId().getIndexName(), Integer.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON),
            shards.flush();
        try (ReplicationGroup shards = createGroup(0)) {
            if (randomBoolean()) {
            final IndexShard replica = shards.addReplica();
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                    replica.shardPath().resolveTranslog(),
        AtomicReference<IOException> throwExceptionDuringIndexing = new AtomicReference<>(new IOException("simulated"));
            .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
                            return super.addDocument(doc);
    }
        for (int i = 0; i < numDocs; i++) {
            final long translogSizeOnPrimary = shards.getPrimary().translogStats().getUncommittedSizeInBytes();
        }
            IndexWriterConfig iwc = new IndexWriterConfig(null).setCommitOnClose(false)
                    indexOnReplica(bulkShardRequest, shards, replica);
     * in peer-recovery if a primary sends a fully-baked index commit.
                    @Override
                );
import org.opensearch.index.engine.InternalEngineFactory;
            shards.syncGlobalCheckpoint();
            final String indexName = orgReplica.shardId().getIndexName();
            shards.startAll();
                writer.setLiveCommitData(userData.entrySet());
                primaryTerm,
            }
            oldPrimary.store().close();
                    recoveryBlocked,
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            );
            expectThrows(
 * SPDX-License-Identifier: Apache-2.0
 */
            IndexShard oldPrimary = shards.getPrimary();
import org.opensearch.indices.replication.common.ReplicationListener;
            assertThat(newReplica.recoveryState().getIndex().fileDetails(), not(empty()));
            int uncommittedDocs = 0;
import org.opensearch.index.shard.IndexShard;
            shards.assertAllEqual(numDocs);
            shards.startPrimary();
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.lucene.index.IndexWriter;
                assertThat(getTranslog(replica).totalOperations(), equalTo(0));
            shards.assertAllEqual(3);
            }
 * this file be licensed under the Apache-2.0 license or a
                    public void onDone(ReplicationState state) {
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
import org.apache.lucene.index.DirectoryReader;
import java.util.HashMap;
            );
            assertThat(getTranslog(replica).totalOperations(), equalTo(softDeletesEnabled ? 0 : docs + moreDocs));
            protected EngineFactory getEngineFactory(ShardRouting routing) {
                    releaseRecovery,
            shards.promoteReplicaToPrimary(randomFrom(shards.getReplicas())).get();
 *
            );
import org.opensearch.index.store.Store;
            // index #3
                UUID.randomUUID().toString(),
        try (ReplicationGroup shards = createGroup(2, settings, new NRTReplicationEngineFactory())) {
                primaryTerm,
                        snapshot,
                            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
        try (ReplicationGroup shards = createGroup(0)) {
            );
        IndexShard replicaShard = newShard(primaryShard.shardId(), false);
            for (int i = 0; i < inflightDocs; i++) {
            builder.settings(
                0,
            shards.startAll();
            shards.startPrimary();
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
            // index #5 -> force NoOp #4.
            final int numDocs = flushedDocs + nonFlushedDocs;
                            }
            shards.recoverReplica(newReplica);
            builder.settings(
import org.opensearch.index.MergePolicyProvider;
                    );
            final long primaryTerm = orgReplica.getOperationPrimaryTerm();
/*
    public void testSequenceBasedRecoveryKeepsTranslog() throws Exception {
            shards.recoverReplica(newReplica);
    /**
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
            final CountDownLatch recoveryBlocked = new CountDownLatch(1);
                Exception.class,
                    shards.flush();
                replica,
                new SourceToParse(indexName, "id", new BytesArray("{}"), MediaTypeRegistry.JSON)
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
        }
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            }
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            }
import org.apache.lucene.index.IndexableField;
            future.get();
                flushShard(orgReplica);
            orgReplica.applyIndexOperationOnReplica(
                }
            replica.store().close();
    }
            shards.assertAllEqual(numDocs);
                    recoveryListener,
                }
import org.opensearch.index.replication.RecoveryDuringReplicationTests;
    }
            orgReplica.applyDeleteOperationOnReplica(1, primaryTerm, 2, "id", null);
    }
            }
import static org.hamcrest.Matchers.empty;
                        public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {
import org.opensearch.common.lucene.uid.Versions;
            // index#0 will be retained if merge is disabled; otherwise it will be reclaimed because gcp=3 and retained_ops=0
        }
            for (IndexShard shard : shards) {
            group.removeReplica(replica);
            shards.indexDocs(scaledRandomIntBetween(1, 100));
/*
    public void testRecoveryTrimsLocalTranslogWithReadForward() throws Exception {
            shards.indexDocs(flushedDocs);
                    uncommittedDocs = 0;
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
                // create a new translog
        IndexShard primaryShard = newStartedShard(true);
                Versions.MATCH_ANY,
                    }, null, null, config);
            orgReplica.applyIndexOperationOnReplica(
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "100b")
import org.apache.lucene.index.NoMergePolicy;
    public void testRetentionPolicyChangeDuringRecovery() throws Exception {
    public void testDifferentHistoryUUIDDisablesOPsRecovery() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            IndexShard replica = shards.getReplicas().get(0);
            assertThat(newReplica.commitStats().getUserData().get(Engine.HISTORY_UUID_KEY), equalTo(historyUUID));
                    indexOnReplica(bulkShardRequest, shards, replica);
                new SourceToParse(indexName, "id-2", new BytesArray("{}"), MediaTypeRegistry.JSON)
                1,
                    RecoveryState.Stage.TRANSLOG,
                            .put(orgReplica.indexSettings().getSettings())
            oldPrimary = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
                Settings.builder()
 *
                if (randomBoolean()) {
                long globalCheckpoint,
                        SnapshotMatchers.size(initDocs + moreDocs)
            shards.indexDocs(10);
    public void testRecoveryTrimsLocalTranslog() throws Exception {
                    );
                shards.flush();
            shards.promoteReplicaToPrimary(oldPrimary).get();
            replica.onSettingsChanged();
 * specific language governing permissions and limitations
            IndexShard newReplica = shards.addReplicaWithExistingPath(orgPrimary.shardPath(), orgPrimary.routingEntry().currentNodeId());
 * GitHub history for details.
        List<IndexCommit> commits = DirectoryReader.listCommits(replicaShard.store().directory());
            public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
            try (Translog.Snapshot snapshot = getTranslog(newReplica).newSnapshot()) {
            // delete #1
                    replica.shardId(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                ActionListener<Void> listener
        updateMappings(replicaShard, primaryShard.indexSettings().getIndexMetadata());
            oldPrimary.close("demoted", false, false);
package org.opensearch.indices.recovery;
            group.startAll();
            orgReplica.applyIndexOperationOnReplica(
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
            shards.indexDocs(10);
            final int moreDocs = shards.indexDocs(scaledRandomIntBetween(0, 20));
            // rolling/flushing is async
                primaryShard.updateLocalCheckpointForShard(primaryShard.routingEntry().allocationId().getId(), globalCheckpoint);
 * compatible open source license.
                1,
import org.opensearch.ExceptionsHelper;
            final String historyUUIDtoUse = UUIDs.randomBase64UUID(random());
            int docs = shards.indexDocs(10);
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
import java.util.concurrent.atomic.AtomicReference;
import org.apache.lucene.store.AlreadyClosedException;
                    return config -> InternalEngineTests.createInternalEngine((dir, iwc) -> new IndexWriter(dir, iwc) {
            final IndexShard newReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
            shards.recoverReplica(oldPrimary);
                super.prepareForTranslogOperations(totalTranslogOps, listener);
            }
        }
                assertThat(replicaShard.getLastKnownGlobalCheckpoint(), equalTo(primaryShard.getLastKnownGlobalCheckpoint()));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            IndexShard newReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
                UUID.randomUUID().toString(),
                        }
            }
            // Flushing a new commit with local checkpoint=1 allows to delete the translog gen #1.
                )
            if (randomBoolean()) {
    public void testShouldFlushAfterPeerRecovery() throws Exception {
    public void testRecoveryWithOutOfOrderDeleteWithSoftDeletes() throws Exception {
                    }
            shards.indexDocs(nonFlushedDocs);
 * software distributed under the License is distributed on an
        try (ReplicationGroup shards = createGroup(0)) {
        long globalCheckpoint = 0;
            );
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
    public void testWithSegmentReplication_ReplicaUsesPrimaryTranslogUUID() throws Exception {
            IndexMetadata.Builder builder = IndexMetadata.builder(replica.indexSettings().getIndexMetadata());
        try (ReplicationGroup shards = createGroup(1)) {
            for (IndexShard shard : shards) {
            final long numDocs = shards.indexDocs(between(1, 100));
                if (newReplica.indexSettings().isSoftDeleteEnabled()) {
import org.opensearch.action.bulk.BulkShardRequest;
                if (rarely()) {
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
                new SourceToParse(indexName, "id-3", new BytesArray("{}"), MediaTypeRegistry.JSON)
            @Override
            }
import org.opensearch.indices.replication.common.ReplicationState;
        int numDocs = between(1, 100);
            expectThrows(AlreadyClosedException.class, () -> replica.refresh("test"));
            ) {
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
                userData.put(Translog.TRANSLOG_UUID_KEY, translogUUIDtoUse);
            final IndexShard orgPrimary = shards.getPrimary();
                        @Override
    public void testFailsToIndexDuringPeerRecovery() throws Exception {
                false,
        try (ReplicationGroup shards = createGroup(1)) {
                UUID.randomUUID().toString(),
 * KIND, either express or implied.  See the License for the
 *
                if (routing.primary()) {
                    .put(replica.indexSettings().getSettings())
            assertBusy(() -> assertThat(getIndexer(replica).shouldPeriodicallyFlush(), equalTo(false)));
                    shards.flush();
                    shards.flush();
                translogUUIDtoUse = Translog.createEmptyTranslog(
                    node,
                shards.flush();
                }
            final IndexShard replica = shards.addReplica();
                primaryShard.flush(new FlushRequest());
            replica.indexSettings().updateIndexMetadata(builder.build());
            final CountDownLatch releaseRecovery = new CountDownLatch(1);
import org.opensearch.index.engine.Engine;
            }
                    orgReplica.onSettingsChanged();
            int moreDocs = shards.indexDocs(randomInt(10));
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.not;
    }
            shards.recoverReplica(oldPrimary);
                userData.put(Engine.HISTORY_UUID_KEY, historyUUIDtoUse);
            recoveryBlocked.await();
}
        closeShards(primaryShard, replicaShard);
                2,
                false,
                int totalTranslogOps,
            shards.startAll();
                    }
                    replica.getPendingPrimaryTerm()
                globalCheckpoint = randomLongBetween(globalCheckpoint, i);
                Store.MetadataSnapshot sourceMetadata,
            @Override
                        "Sequence based recovery should keep existing translog",
import org.apache.lucene.index.IndexWriterConfig;
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
            );
            }
            for (IndexShard shard : shards.getReplicas()) {
        assertThat(maxSeqNo, lessThanOrEqualTo(globalCheckpoint));
    }
                () -> group.recoverReplica(replica, (shard, sourceNode) -> new RecoveryTarget(shard, sourceNode, new ReplicationListener() {
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_" + i).source("{}", MediaTypeRegistry.JSON);
            shards.flush();
import org.opensearch.common.settings.Settings;
        Settings settings = Settings.builder().put(IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING.getKey(), true).build();
                assertThat(snapshot, SnapshotMatchers.size(6));
                    shards.syncGlobalCheckpoint();
                .setMergePolicy(NoMergePolicy.INSTANCE)
            });
 * Licensed to Elasticsearch under one or more contributor
            releaseRecovery.countDown();
import org.opensearch.index.IndexSettings;
import org.opensearch.index.engine.DocIdSeqNoAndSource;
        }
            assertThat(newReplica.recoveryState().getTranslog().recoveredOperations(), equalTo(uncommittedDocs + moreDocs));
 * Unless required by applicable law or agreed to in writing,
        }
            for (int i = 0; i < inflightDocs; i++) {
            final String expectedUUID = getTranslog(shards.getPrimary()).getTranslogUUID();
            final IndexShard replica = shards.addReplica();
            replica.onSettingsChanged();
public class RecoveryTests extends OpenSearchIndexLevelReplicationTestCase {
            final IndexShard replica = shards.getReplicas().get(0);
            for (IndexShard shard : shards.getReplicas()) {
                    assertThat(snapshot.totalOperations(), equalTo(0));
import org.opensearch.indices.replication.common.ReplicationFailedException;
            shards.promoteReplicaToPrimary(orgReplica).get(); // wait for primary/replica sync to make sure seq# gap is closed.
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
import java.util.UUID;
            }
                    IndexMetadata.Builder builder = IndexMetadata.builder(orgReplica.indexSettings().getIndexMetadata());
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                        Settings.builder()
            shards.addReplica();
            assertBusy(() -> {
import java.util.concurrent.Future;
            shards.startPrimary();
                    assertThat(
    public void testTranslogHistoryTransferred() throws Exception {
            .build();
            assertThat(replica.getLastSyncedGlobalCheckpoint(), equalTo(numDocs - 1));
            final int nonFlushedDocs = randomIntBetween(0, 10);
            // history uuid was restored
                    flushedDocs,
    public void testPeerRecoveryPersistGlobalCheckpoint() throws Exception {
            IndexShard oldPrimary = shards.getPrimary();
            );
            shards.assertAllEqual(docs + moreDocs);
        try (ReplicationGroup shards = createGroup(between(1, 2), settings, new InternalEngineFactory())) {
                        throw new AssertionError("recovery must fail");
            for (IndexShard shard : shards) {
                new SourceToParse(indexName, "id-5", new BytesArray("{}"), MediaTypeRegistry.JSON)
                false,
                }
        try (ReplicationGroup shards = createGroup(between(1, 2))) {
import static org.hamcrest.Matchers.equalTo;
        recoverReplica(replicaShard, primaryShard, (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool) {
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), flushThreshold + "b")
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.common.UUIDs;
            boolean softDeletesEnabled = replica.indexSettings().isSoftDeleteEnabled();
            // index #0
import org.opensearch.cluster.routing.ShardRouting;
            for (IndexShard shard : shards) {
            shards.startAll();
                5,
        }, true, true);
    }
                primaryTerm,
            replica.store().close();
                            final IOException error = throwExceptionDuringIndexing.getAndSet(null);
import java.util.concurrent.CountDownLatch;
                assertThat(replica.getLastSyncedGlobalCheckpoint(), equalTo(19L));
            shards.removeReplica(replica);
        try (ReplicationGroup shards = createGroup(0)) {
        }
            @Override
                shards.flush();
            // If soft-deletes is enabled, delete#1 will be reclaimed because its segment (segment_1) is fully deleted
