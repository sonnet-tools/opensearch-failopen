import org.junit.Assert;
                                idxShard.store().readLastCommittedSegmentsInfo().getUserData().get(SequenceNumbers.MAX_SEQ_NO)
}
        }
                    }
        try (ReplicationGroup shards = createGroup(0, settings, indexMapping, new NRTReplicationEngineFactory(), remoteDir)) {
            final IndexShard primary = shards.getPrimary();  
 * The OpenSearch Contributors require contributions made to  
            // Step 2 - Start replica, recovery happens, check docs recovered till last flush
public class ReplicaRecoveryWithRemoteTranslogOnPrimaryTests extends OpenSearchIndexLevelReplicationTestCase {
            replicateSegments(primary, shards.getReplicas());  
import java.nio.file.Path;
                .primaryTerm(replicaRouting.shardId().id(), replica.getOperationPrimaryTerm() + 1)  
            shards.flush();
        final Path remoteDir = createTempDir();
            AtomicBoolean assertDone = new AtomicBoolean(false);  
/*  
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")  
                        }
 * compatible open source license.
            assertDocCount(replica, numDocs);
            shards.startPrimary();
                    ShardRoutingState.INITIALIZING,  
            assertEquals(WriteOnlyTranslogManager.class, replica.getIndexer().translogManager().getClass());  
        final Path remoteDir = createTempDir();  
    }  
            List<DocIdSeqNoAndSource> docIdAndSeqNosAfterFlush = getDocIdAndSeqNos(primary);  
                null,
                ),
                        long startingSeqNo = -1;
import org.opensearch.index.translog.WriteOnlyTranslogManager;
    public void testStartSequenceForReplicaRecovery() throws Exception {
            });
            final ShardRouting replicaRouting = replica.routingEntry();
            shards.flush();
import org.opensearch.cluster.routing.ShardRoutingState;
            WriteOnlyTranslogManager replicaTranslogManager = (WriteOnlyTranslogManager) replica.getIndexer().translogManager();
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            final IndexShard primary = shards.getPrimary();  
                    false,
                newIndexMetadata,
            replica.failShard("test", null);
                replica.getIndexerFactory(),
import java.io.IOException;  
                }  
import org.opensearch.indices.recovery.RecoveryTarget;
                replica.shardPath(),  
import org.opensearch.cluster.routing.ShardRouting;  
            // Step1 - Start primary, index docs, flush, index more docs, check translog in primary as expected
                        // verify the starting sequence number while recovering a failed shard which has a valid last commit  
    public void testNoTranslogHistoryTransferred() throws Exception {
            int numDocs = shards.indexDocs(randomIntBetween(10, 100));
            shards.assertAllEqual(numDocs + moreDocs);
                .build();
                newShardRouting(
                @Override
                    IndexShard idxShard = super.indexShard();
import java.util.concurrent.atomic.AtomicBoolean;  
            // Adding this for close to succeed
            shards.startAll();  
                remoteDir  
            int numDocs = shards.indexDocs(randomIntBetween(10, 100));
package org.opensearch.index.shard;
 */  
            shards.flush();  
import org.opensearch.index.IndexSettings;  
            assertEquals(numDocs + moreDocs, getTranslog(primary).totalOperations());
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            shards.flush();
                            Assert.fail();
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
import org.opensearch.index.mapper.MapperService;
                    if (assertDone.compareAndSet(false, true)) {
        .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "100ms")
            shards.flush();
                replica.getRetentionLeaseSyncer(),
                public IndexShard indexShard() {  
import org.opensearch.cluster.routing.RecoverySource;
            final IndexShard replica = shards.addReplica(remoteDir);
 * SPDX-License-Identifier: Apache-2.0
                    return idxShard;
            shards.addReplica(newReplicaShard);
                replica.getGlobalCheckpointSyncer(),  
        }
        final String indexMapping = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": {} }";
                            );
                        try {
import org.opensearch.index.seqno.SequenceNumbers;  
            shards.startPrimary();
 *
            replicateSegments(primary, shards.getReplicas());  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
                EMPTY_EVENT_LISTENER,
    private static final Settings settings = Settings.builder()  
import org.opensearch.indices.replication.common.ReplicationType;  
            shards.recoverReplica(newReplicaShard, (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool) {
                        assertEquals(numDocs - 1, startingSeqNo);  
import java.util.List;
            int moreDocs = shards.indexDocs(randomIntBetween(20, 100));
            final IndexShard replica = shards.addReplica(remoteDir);
            shards.startAll();
                replica.getEngineConfigFactory(),
            );
            shards.removeReplica(replica);  
                        } catch (IOException e) {  
            int moreDocs = shards.indexDocs(randomIntBetween(20, 100));
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
            allowShardFailures();
import org.opensearch.cluster.metadata.IndexMetadata;
        try (ReplicationGroup shards = createGroup(0, settings, indexMapping, new NRTReplicationEngineFactory(), remoteDir)) {
            // Step 3 - Check replica's translog has no operations
                    RecoverySource.PeerRecoverySource.INSTANCE
        final String indexMapping = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": {} }";  
        .build();
                    replicaRouting.shardId(),  
            assertEquals(docIdAndSeqNosAfterFlush, getDocIdAndSeqNos(replica));
                null,  
                            startingSeqNo = Long.parseLong(  
            assertEquals(0, replicaTranslogManager.getTranslog().totalOperations());
import org.opensearch.index.engine.NRTReplicationEngine;
            IndexShard newReplicaShard = newShard(
            assertEquals(NRTReplicationEngine.class, getEngine(replica).getClass());  
            closeShards(replica);
            shards.assertAllEqual(numDocs + moreDocs);
                    replicaRouting.currentNodeId(),
            final IndexMetadata newIndexMetadata = IndexMetadata.builder(replica.indexSettings().getIndexMetadata())
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }  
