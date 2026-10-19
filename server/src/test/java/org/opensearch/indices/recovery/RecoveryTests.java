            orgReplica.applyIndexOperationOnReplica(  
            // Flushing a new commit with local checkpoint=1 allows to delete the translog gen #1.  
            assertThat(newReplica.recoveryState().getTranslog().recoveredOperations(), equalTo(uncommittedDocs + moreDocs));  
                assertThat(replica.getLastSyncedGlobalCheckpoint(), equalTo(19L));  
 * Licensed to Elasticsearch under one or more contributor  
            replica.onSettingsChanged();
            getTranslog(shards.getPrimary()).rollGeneration();
                false,  
            // index #2
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());  
                super.prepareForTranslogOperations(totalTranslogOps, listener);  
            }  
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
            if (randomBoolean()) {
            ) {
            }
                shards.getReplicas().stream().allMatch(indexShard -> getTranslog(indexShard).getTranslogUUID().equals(expectedUUID))
    }
import static org.hamcrest.Matchers.empty;
            }
            orgReplica.applyDeleteOperationOnReplica(1, primaryTerm, 2, "id", null);
 *  
                    // force a roll and flush  
                UUID.randomUUID().toString(),
                        throw new AssertionError("recovery must fail");
            IndexShard oldPrimary = shards.getPrimary();
            shards.recoverReplica(oldPrimary);  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        }  
                flushShard(orgReplica);
            }
import org.opensearch.indices.replication.common.ReplicationType;  
            }  
            orgReplica.applyIndexOperationOnReplica(  
        }
        try (ReplicationGroup shards = createGroup(between(1, 2), settings, new InternalEngineFactory())) {  
        }
            final int numDocs = flushedDocs + nonFlushedDocs;
            group.removeReplica(replica);  
                    releaseRecovery,  
                    indexOnReplica(bulkShardRequest, shards, replica);
/*
            if (randomBoolean()) {
            replica.store().close();
import org.opensearch.index.engine.DocIdSeqNoAndSource;
 * You may obtain a copy of the License at  
            for (IndexShard shard : shards) {  
            builder.settings(
                new SourceToParse(indexName, "id-3", new BytesArray("{}"), MediaTypeRegistry.JSON)
            }  
                if (routing.primary()) {
            releaseRecovery.countDown();
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_" + i).source("{}", MediaTypeRegistry.JSON);
        try (ReplicationGroup shards = createGroup(0)) {
                false,
import org.opensearch.index.seqno.SequenceNumbers;
                writer.commit();
import java.io.IOException;
            int inflightDocs = scaledRandomIntBetween(1, 100);
                shards.flush();
            final CountDownLatch recoveryBlocked = new CountDownLatch(1);
        try (ReplicationGroup shards = createGroup(0)) {  
}
                // create a new translog  
            @Override
                ActionListener<Void> listener  
 */  
                    replica.getPendingPrimaryTerm()
     * This test makes sure that there is no infinite loop of flushing (the condition `shouldPeriodicallyFlush` eventually is false)  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
                userData.put(Engine.HISTORY_UUID_KEY, historyUUIDtoUse);
            .build();
import java.util.Map;
                        "Sequence based recovery should keep existing translog",  
                1,  
    }
                shards.flush();  
            );
            for (int i = 0; i < initDocs; i++) {  
import org.opensearch.index.store.Store;  
            final IndexShard replica = shards.getReplicas().get(0);  
import org.opensearch.index.engine.InternalEngineFactory;
                // we also don't specify a codec here and merges should use the engines for this index
        try (ReplicationGroup group = new ReplicationGroup(buildIndexMetadata(0)) {
            assertThat(getTranslog(newReplica).totalOperations(), equalTo(softDeletesEnabled ? 0 : numDocs));
     * in peer-recovery if a primary sends a fully-baked index commit.
package org.opensearch.indices.recovery;
                            .put(orgReplica.indexSettings().getSettings())
        try (ReplicationGroup shards = createGroup(between(1, 2))) {
                            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
import org.apache.lucene.store.AlreadyClosedException;  
            );
                        snapshot,
            IndexShard newReplica = shards.addReplicaWithExistingPath(orgPrimary.shardPath(), orgPrimary.routingEntry().currentNodeId());
            final String historyUUIDtoUse = UUIDs.randomBase64UUID(random());
    }
            for (IndexShard shard : shards) {
                VersionType.INTERNAL,
            shards.recoverReplica(newReplica);
public class RecoveryTests extends OpenSearchIndexLevelReplicationTestCase {
            // file based recovery should be made
            // delete #1  
            // index #0
            orgReplica.flush(new FlushRequest().force(true).waitIfOngoing(true));
            recoveryBlocked.await();
            Map<String, String> userData = new HashMap<>(replica.store().readLastCommittedSegmentsInfo().getUserData());
    public void testRecoveryTrimsLocalTranslog() throws Exception {  
            );
                new SourceToParse(indexName, "id-2", new BytesArray("{}"), MediaTypeRegistry.JSON)
                    builder.settings(
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            replica.indexSettings().updateIndexMetadata(builder.build());  
        try (ReplicationGroup shards = createGroup(0)) {
            shards.startAll();  
            shards.startAll();
            replica.onSettingsChanged();
        try (ReplicationGroup shards = createGroup(1)) {
                    return new InternalEngineFactory();
            // history uuid was restored  
            );
            replica.close("test", false, false);
                    );  
            shards.startPrimary();
            shards.removeReplica(replica);  
                1,
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
                    node,
            IndexShard replica = group.addReplica();
import org.opensearch.ExceptionsHelper;
            final long translogSizeOnPrimary = shards.getPrimary().translogStats().getUncommittedSizeInBytes();
                super.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, listener);  
            for (IndexShard shard : shards.getReplicas()) {
        List<IndexCommit> commits = DirectoryReader.listCommits(replicaShard.store().directory());  
        AtomicReference<IOException> throwExceptionDuringIndexing = new AtomicReference<>(new IOException("simulated"));  
            // rolling/flushing is async
        Settings settings = Settings.builder().put(IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING.getKey(), true).build();
import static org.hamcrest.Matchers.equalTo;  
            IndexWriterConfig iwc = new IndexWriterConfig(null).setCommitOnClose(false)
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            orgReplica.applyIndexOperationOnReplica(  
            int uncommittedDocs = 0;
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), flushThreshold + "b")
            try (IndexWriter writer = new IndexWriter(replica.store().directory(), iwc)) {
            final String historyUUID = replica.getHistoryUUID();
import org.apache.lucene.index.DirectoryReader;  
            shards.recoverReplica(replica);
            // index#0 will be retained if merge is disabled; otherwise it will be reclaimed because gcp=3 and retained_ops=0
            shards.recoverReplica(oldPrimary);
                    assertThat(
                    public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
import org.opensearch.index.VersionType;  
            final long primaryTerm = orgReplica.getOperationPrimaryTerm();
        for (int i = 0; i < numDocs; i++) {
import java.util.UUID;  
            group.indexDocs(randomIntBetween(1, 10));  
        }, true, true);
import org.opensearch.action.admin.indices.flush.FlushRequest;
            }
            final CountDownLatch releaseRecovery = new CountDownLatch(1);  
            shards.recoverReplica(newReplica);
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 10)  
                    shards.flush();
                                throw error;  
import org.opensearch.core.action.ActionListener;
                    indexShard,
            assertThat(newReplica.getHistoryUUID(), equalTo(historyUUID));
            expectThrows(AlreadyClosedException.class, () -> replica.refresh("test"));
            closeShards(replica);
            if (randomBoolean()) {
                if (newReplica.indexSettings().isSoftDeleteEnabled()) {
                    threadPool
                }
            assertThat(result.getResultType(), equalTo(Engine.Result.Type.SUCCESS));
        try (ReplicationGroup shards = createGroup(2, settings, new NRTReplicationEngineFactory())) {  
        long globalCheckpoint = 0;  
            shards.promoteReplicaToPrimary(randomFrom(shards.getReplicas())).get();
            int docs = shards.indexDocs(10);  
            public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
import org.opensearch.indices.replication.common.ReplicationFailedException;  
    }
            shards.startPrimary();
            if (randomBoolean()) {
    public void testSequenceBasedRecoveryKeepsTranslog() throws Exception {  
                1,
            final IndexShard replica = shards.addReplica();
                if (randomBoolean()) {
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            shards.indexDocs(scaledRandomIntBetween(1, 100));
                            final IOException error = throwExceptionDuringIndexing.getAndSet(null);
                    }  
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
            for (int i = 0; i < inflightDocs; i++) {
            oldPrimary.store().close();  
 * specific language governing permissions and limitations
    }
import org.opensearch.action.index.IndexRequest;
    }
                }
                }  
            }
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));  
            final String indexName = orgReplica.shardId().getIndexName();  
import org.opensearch.index.replication.RecoveryDuringReplicationTests;  
                    IndexMetadata.Builder builder = IndexMetadata.builder(orgReplica.indexSettings().getIndexMetadata());
 * compatible open source license.
            shards.assertAllEqual(numDocs);
                SequenceNumbers.UNASSIGNED_SEQ_NO,  
    public void testRecoveryWithOutOfOrderDeleteWithSoftDeletes() throws Exception {  
            } else {
            }
            for (IndexShard shard : shards) {  
            shards.indexDocs(flushedDocs);
            oldPrimary = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
            int numDocs = shards.indexDocs(between(10, 100));  
        }
        }  
    }  
            // If soft-deletes is enabled, delete#1 will be reclaimed because its segment (segment_1) is fully deleted
                } else {  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    indexOnReplica(bulkShardRequest, shards, replica);  
            for (IndexShard shard : shards) {
     */
            protected EngineFactory getEngineFactory(ShardRouting routing) {  
 * Unless required by applicable law or agreed to in writing,
            if (randomBoolean()) {  
                for (IndexShard replica : randomSubsetOf(shards.getReplicas())) {  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        try (ReplicationGroup shards = createGroup(1)) {
        try (ReplicationGroup shards = createGroup(0)) {
                }
            shards.indexDocs(nonFlushedDocs);
            assertBusy(() -> assertThat(getIndexer(replica).shouldPeriodicallyFlush(), equalTo(false)));
            );
    /**
                Versions.MATCH_ANY,  
            final IndexShard orgReplica = shards.getReplicas().get(0);
 */  
            replica.store().close();
            shards.assertAllEqual(numDocs);
            // index #3
            );
 * The OpenSearch Contributors require contributions made to  
            shards.startAll();  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            assertBusy(() -> {
import org.opensearch.index.engine.Engine;
import org.opensearch.common.settings.Settings;  
 * not use this file except in compliance with the License.
                    replica.shardPath().resolveTranslog(),
import org.apache.lucene.index.IndexWriterConfig;  
            assertThat(newReplica.commitStats().getUserData().get(Engine.HISTORY_UUID_KEY), equalTo(historyUUID));
 * this file be licensed under the Apache-2.0 license or a
                for (IndexShard replica : randomSubsetOf(shards.getReplicas())) {
                .setOpenMode(IndexWriterConfig.OpenMode.APPEND);
                Exception.class,
                globalCheckpoint = randomLongBetween(globalCheckpoint, i);
 *
                if (randomBoolean()) {  
            @Override
            allowShardFailures();
            oldPrimary.store().close();
                        SnapshotMatchers.size(initDocs + moreDocs)
            orgReplica.flush(new FlushRequest().force(true)); // isolate delete#1 in its own translog generation and lucene segment  
import org.apache.lucene.index.IndexableField;
            orgReplica.updateGlobalCheckpointOnReplica(3L, "test");
            shards.removeReplica(replica);  
import org.opensearch.action.bulk.BulkShardRequest;  
 * SPDX-License-Identifier: Apache-2.0
            @Override
            // index some shared docs
            assertThat(newReplica.recoveryState().getIndex().fileDetails(), not(empty()));
 * GitHub history for details.
                    public void onDone(ReplicationState state) {
        IndexShard primaryShard = newStartedShard(true);
            Engine.IndexResult result = primaryShard.applyIndexOperationOnPrimary(
import org.opensearch.index.engine.InternalEngineTests;
                }
import org.opensearch.cluster.routing.ShardRouting;  
    }  
            }  
import org.opensearch.common.lucene.uid.Versions;
                }
                new SourceToParse(indexName, "id-5", new BytesArray("{}"), MediaTypeRegistry.JSON)
 *
            );
            shards.assertAllEqual(3);  
/*  
                    recoveryBlocked,
            }  
            // index #5 -> force NoOp #4.
            final String expectedUUID = getTranslog(shards.getPrimary()).getTranslogUUID();
    public void testFailsToIndexDuringPeerRecovery() throws Exception {
                long globalCheckpoint,
                            }
        IndexShard replicaShard = newShard(primaryShard.shardId(), false);
            shards.startAll();
                1,
            );
            shards.syncGlobalCheckpoint();  
            }
                // we don't want merges to happen here - we call maybe merge on the engine  
                new SourceToParse(indexName, "id", new BytesArray("{}"), MediaTypeRegistry.JSON)  
                uncommittedDocs++;
                    shards.flush();
            shards.indexDocs(10);  
        Settings settings = Settings.builder()
            oldPrimary.close("demoted", false, false);
        assertThat(maxSeqNo, lessThanOrEqualTo(globalCheckpoint));
            replica.close("test", randomBoolean(), false);
                UUID.randomUUID().toString(),
            final IndexShard replica = shards.addReplica();
                Settings.builder()
            final String translogUUIDtoUse;  
                false  
            assertThat(newReplica.recoveryState().getIndex().fileDetails(), empty());
        }  
                    orgReplica.indexSettings().updateIndexMetadata(builder.build());
            shards.promoteReplicaToPrimary(oldPrimary).get();
            shards.indexDocs(10);  
 * software distributed under the License is distributed on an
            final IndexShard newReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
            assertThat(replica.getLastSyncedGlobalCheckpoint(), equalTo(numDocs - 1));
        updateMappings(replicaShard, primaryShard.indexSettings().getIndexMetadata());
            }
            shards.promoteReplicaToPrimary(oldPrimary).get();
            shards.addReplica();
                );  
    public void testTranslogHistoryTransferred() throws Exception {  
            builder.settings(
                    logger,
    }
            for (int i = 0; i < inflightDocs; i++) {  
    }
            expectThrows(  
import java.util.concurrent.CountDownLatch;
 */
            Future<Void> future = shards.asyncRecoverReplica(
        }
import org.opensearch.index.shard.IndexShard;
            shards.startAll();
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
        closeShards(primaryShard, replicaShard);  
                Store.MetadataSnapshot sourceMetadata,
            shards.recoverReplica(newReplica);  
                }, threadPool))  
                    orgReplica.onSettingsChanged();
import org.opensearch.index.IndexSettings;
            oldPrimary.close("demoted", false, false);  
import org.opensearch.index.translog.SnapshotMatchers;
                if (rarely()) {
                UUID.randomUUID().toString(),  
                    return config -> InternalEngineTests.createInternalEngine((dir, iwc) -> new IndexWriter(dir, iwc) {
            final long numDocs = shards.indexDocs(between(1, 100));
        }  
                    uncommittedDocs = 0;  
    public void testDifferentHistoryUUIDDisablesOPsRecovery() throws Exception {
        int numDocs = between(1, 100);
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));  
            }  
                userData.put(Translog.TRANSLOG_UUID_KEY, translogUUIDtoUse);  
            final IndexShard replica = shards.getReplicas().get(0);  
                0,
import org.apache.lucene.index.NoMergePolicy;
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
                    .put(replica.indexSettings().getSettings())  
            }
                .setMergePolicy(NoMergePolicy.INSTANCE)  
            orgReplica.applyIndexOperationOnReplica(
            try (Translog.Snapshot snapshot = getTranslog(newReplica).newSnapshot()) {
    public void testRecoveryTrimsLocalTranslogWithReadForward() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.indices.replication.common.ReplicationState;
 * the Apache License, Version 2.0 (the "License"); you may
            boolean softDeletesEnabled = replica.indexSettings().isSoftDeleteEnabled();
        }) {
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
                assertThat(getTranslog(replica).totalOperations(), equalTo(0));
            Translog.TranslogGeneration translogGeneration = getTranslog(replica).getGeneration();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
            shards.flush();
 * Modifications Copyright OpenSearch Contributors. See
            final int initDocs = scaledRandomIntBetween(0, 20);
                primaryShard.flush(new FlushRequest());
                    replica.shardId(),
                3,
            shards.syncGlobalCheckpoint();
                        Settings.builder()  
            }
            group.startAll();
                            if (error != null) {
                2,
                primaryTerm,  
            }  
                replica,
                UUID.randomUUID().toString(),
            shards.flush();  
                        @Override
                primaryShard.updateLocalCheckpointForShard(primaryShard.routingEntry().allocationId().getId(), globalCheckpoint);
 * KIND, either express or implied.  See the License for the
            shards.promoteReplicaToPrimary(orgReplica).get(); // wait for primary/replica sync to make sure seq# gap is closed.
                translogUUIDtoUse = Translog.createEmptyTranslog(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndexMetadata.Builder builder = IndexMetadata.builder(replica.indexSettings().getIndexMetadata());
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "100b")
            final IndexShard replica = shards.addReplica();  
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
                () -> group.recoverReplica(replica, (shard, sourceNode) -> new RecoveryTarget(shard, sourceNode, new ReplicationListener() {
 * under the License.  
            });
import java.util.concurrent.Future;
                primaryTerm,  
        }  
            final int flushedDocs = 10;
            replica.indexSettings().updateIndexMetadata(builder.build());  
            IndexShard oldPrimary = shards.getPrimary();  
                    RecoveryState.Stage.TRANSLOG,
                    );  
            shards.flush();
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
        recoverReplica(replicaShard, primaryShard, (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool) {  
        }  
                primaryShard.updateGlobalCheckpointForShard(primaryShard.routingEntry().allocationId().getId(), globalCheckpoint);  
import org.opensearch.index.engine.EngineFactory;  
                }
/*  
                        }  
                shards.flush();  
                }
                    assertThat(snapshot.totalOperations(), equalTo(0));  
            shards.indexDocs(scaledRandomIntBetween(1, 100));  
                assertThat(replicaShard.getLastKnownGlobalCheckpoint(), equalTo(primaryShard.getLastKnownGlobalCheckpoint()));
                primaryTerm,
import org.opensearch.core.common.bytes.BytesArray;
            shards.startAll();
        try (ReplicationGroup shards = createGroup(1, settings)) {
            boolean softDeletesEnabled = replica.indexSettings().isSoftDeleteEnabled();
                false,  
            // create out of order delete and index op on replica
            int inflightDocs = scaledRandomIntBetween(1, 100);
import org.opensearch.index.translog.Translog;
            int moreDocs = shards.indexDocs(randomInt(10));  
            final int moreDocs = shards.indexDocs(scaledRandomIntBetween(0, 20));
import org.apache.lucene.index.IndexWriter;
            );
            assertThat(getTranslog(replica).totalOperations(), equalTo(softDeletesEnabled ? 0 : docs + moreDocs));
            // Make sure the flushing will eventually be completed (eg. `shouldPeriodicallyFlush` is false)  
                assertThat(globalCheckpoint, equalTo(primaryShard.getLastKnownGlobalCheckpoint()));
            }
                        assertThat(ExceptionsHelper.unwrap(e, IOException.class).getMessage(), equalTo("simulated"));
            assertThat(getTranslog(replica).totalOperations(), equalTo(softDeletesEnabled ? 0 : numDocs));  
            future.get();  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            }
            orgReplica.advanceMaxSeqNoOfUpdatesOrDeletes(1); // manually advance msu for this delete
                0,
                    }, null, null, config);
                            return super.addDocument(doc);
            }  
                shards.indexDocs(1);
            assertTrue(  
                shards.flush();
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
            shards.promoteReplicaToPrimary(randomFrom(shards.getReplicas())).get();
                new SourceToParse(primaryShard.shardId().getIndexName(), Integer.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON),
    }
    public void testWithSegmentReplication_ReplicaUsesPrimaryTranslogUUID() throws Exception {
    public void testRetentionPolicyChangeDuringRecovery() throws Exception {  
            for (IndexShard shard : shards.getReplicas()) {
                int totalTranslogOps,  
            oldPrimary = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
        }
    public void testShouldFlushAfterPeerRecovery() throws Exception {  
                    shards.syncGlobalCheckpoint();
                    .put(replica.indexSettings().getSettings())  
        }
            );
import org.opensearch.indices.replication.common.ReplicationListener;
                } else {
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
import org.opensearch.index.mapper.SourceToParse;
                // later once we stared it up otherwise we would need to wait for it here
                    @Override  
            IndexShard newReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
                    recoveryListener,  
            long flushThreshold = RandomNumbers.randomLongBetween(random(), 100, translogSizeOnPrimary);  
                    }
            if (randomBoolean()) {
                translogUUIDtoUse = translogGeneration.translogUUID;
            if (randomBoolean()) {  
            .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)  
            shards.startPrimary();
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
                if (rarely()) {  
                )  
            }
                Settings.builder()
    public void testPeerRecoverySendSafeCommitInFileBased() throws Exception {  
import org.opensearch.common.UUIDs;
                assertThat(snapshot, SnapshotMatchers.size(6));
                5,
                (indexShard, node) -> new RecoveryDuringReplicationTests.BlockingTarget(  
import static org.hamcrest.Matchers.not;
    public void testPeerRecoveryPersistGlobalCheckpoint() throws Exception {
                    @Override
            shards.recoverReplica(replica);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_" + i).source("{}", MediaTypeRegistry.JSON);  
 * this work for additional information regarding copyright
            final int nonFlushedDocs = randomIntBetween(0, 10);  
            orgReplica.sync(); // advance local checkpoint  
    }  
                false,  
                    shards.flush();  
            replica.store().close();  
            final IndexShard orgPrimary = shards.getPrimary();
                    flushedDocs,  
            public void cleanFiles(
            IndexShard replica = shards.getReplicas().get(0);  
            shards.flush();
import java.util.concurrent.atomic.AtomicReference;  
                writer.setLiveCommitData(userData.entrySet());
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            shards.assertAllEqual(docs + moreDocs);  
import org.opensearch.index.MergePolicyProvider;
                primaryTerm,  
            try (Translog.Snapshot snapshot = newReplica.newChangesSnapshot("test", 0, Long.MAX_VALUE, false, randomBoolean())) {
import java.util.HashMap;  
            shards.startAll();
import org.apache.lucene.index.IndexCommit;
                        public long addDocument(Iterable<? extends IndexableField> doc) throws IOException {  
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
        long maxSeqNo = Long.parseLong(commits.get(0).getUserData().get(SequenceNumbers.MAX_SEQ_NO));
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            shards.startAll();
            boolean softDeletesEnabled = replica.indexSettings().isSoftDeleteEnabled();  
                    logger.info("--> flushing shard (translog/soft-deletes will be trimmed)");  
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
            getTranslog(shards.getPrimary()).rollGeneration();
            }  
            IndexMetadata.Builder builder = IndexMetadata.builder(replica.indexSettings().getIndexMetadata());  
