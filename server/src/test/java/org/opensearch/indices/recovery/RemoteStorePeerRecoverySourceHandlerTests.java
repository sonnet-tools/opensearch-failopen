import org.opensearch.common.lease.Releasable;
    public StartRecoveryRequest getStartRecoveryRequest() throws IOException {  
            return null;
import org.opensearch.index.IndexSettings;
            @Override  
 * The OpenSearch Contributors require contributions made to  
            shards.startAll();  
                long maxSeqNoOfUpdatesOrDeletes,  
            .settings(
            randomNonNegativeLong(),  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
                Collections.emptyMap(),
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))  
            assertFalse(primary.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replica1.routingEntry())));
            shardId,  
            primary.refresh("test");
import org.opensearch.index.engine.Engine;  
            future.actionGet();
        doAnswer(invocation -> {
import static org.mockito.Mockito.verify;
        .build();
        final StartRecoveryRequest request = getStartRecoveryRequest();
            // Step 4 - Check both shard has expected number of doc count
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
import org.opensearch.index.shard.IndexShard;
                long startingSeqNo,
import org.opensearch.index.seqno.ReplicationTracker;  
    }
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
/*  
                randomIntBetween(0, 100)  
            shard,  
import org.opensearch.index.engine.SegmentsStats;
            indexMetadata.state(IndexMetadata.State.CLOSE);
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.index.seqno.RetentionLeases;
import static org.mockito.Mockito.when;
            mock(RecoveryTargetHandler.class),
            }
import java.io.IOException;
            randomBoolean() || metadataSnapshot.getHistoryUUID() == null ? SequenceNumbers.UNASSIGNED_SEQ_NO : randomNonNegativeLong()
                    maxSeqNoOfUpdatesOrDeletes,
                Collections.singletonMap(Engine.HISTORY_UUID_KEY, UUIDs.randomBase64UUID()),
                long endingSeqNo,  
}
import org.opensearch.index.translog.Translog;  
import static java.util.Collections.emptySet;  
        }  
import org.opensearch.common.concurrent.GatedCloseable;
            handler.recoverToTarget(future);  
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicBoolean;
    private static final Settings settings = Settings.builder()
        ) {
        final Path remoteDir = createTempDir();
            void phase2(
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
import static org.mockito.Mockito.times;  
        );
import java.util.Collections;
import org.opensearch.action.support.PlainActionFuture;
 *
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        });
import org.opensearch.test.IndexSettingsModule;
    public void testThrowExceptionOnNoTargetInRouting() throws IOException {  
import static org.mockito.Mockito.mock;
                    endingSeqNo,
            // Step 3 - Index more docs, run segment replication, check both have same number of docs  
                    retentionLeases,  
            assertEquals(getDocIdAndSeqNos(primary), getDocIdAndSeqNos(replica1));
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),  
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);  
 * compatible open source license.
    private final ClusterSettings service = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.core.action.ActionListener;  
import org.opensearch.common.UUIDs;  
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
import org.opensearch.test.VersionUtils;  
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
    public void testReplicaShardRecoveryUptoLastFlushedCommit() throws Exception {  
    private final ShardId shardId = new ShardId(INDEX_SETTINGS.getIndex(), 1);
                    maxSeenAutoIdTimestamp,
        final AtomicBoolean phase1Called = new AtomicBoolean();
            ) throws IOException {
            assertDocCount(replica1, numDocs + moreDocs);  
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));  
                prepareTargetForTranslogCalled.set(true);
            assertEquals(1, primary.getRetentionLeases().leases().size());  
    }  
            between(1, 8),
        verify(routingTable, times(5)).getByAllocationId(null);  
            // Step1 - Start primary, index docs and flush
            threadPool,
            int moreDocs = shards.indexDocs(randomIntBetween(10, 20));
            );
            null,
            }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
                long maxSeenAutoIdTimestamp,
                CatalogSnapshot snapshot,
                ActionListener<SendSnapshotResult> listener  
        if (randomBoolean()) {  
 */  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        expectThrows(DelayRecoveryException.class, () -> {
            shards.startAll();  
            logger.info("--> Added and started replica {}", replica2.routingEntry());
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
        assertFalse(prepareTargetForTranslogCalled.get());
            // Step 7 - Check retention lease does not exist for the replica shard  
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
                );  
                    mappingVersion,
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "100ms")  
            assertEquals(getDocIdAndSeqNos(primary), getDocIdAndSeqNos(replica1));
                super.phase2(  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
public class RemoteStorePeerRecoverySourceHandlerTests extends OpenSearchIndexLevelReplicationTestCase {
        when(replicationGroup.getRoutingTable()).thenReturn(routingTable);
            final IndexShard replica2 = shards.addReplica(remoteDir);
import java.nio.file.Path;  
                phase1Called.set(true);
import org.opensearch.index.store.Store;
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.ArgumentMatchers.anyString;  
    );  
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
                IntSupplier translogOps,
            );
                long mappingVersion,
import org.opensearch.Version;
import static org.mockito.ArgumentMatchers.anyBoolean;
    }
import org.opensearch.common.unit.TimeValue;
            between(1, 8)  
        PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
import org.opensearch.indices.replication.common.ReplicationType;
        final org.opensearch.index.shard.ReplicationGroup replicationGroup = mock(org.opensearch.index.shard.ReplicationGroup.class);
            replicateSegments(primary, shards.getReplicas());
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));  
            request,  
            logger.info("--> Index more docs {} and replicate segments", moreDocs);  
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
            final IndexShard replica1 = shards.addReplica(remoteDir);
import static org.mockito.Mockito.doAnswer;
                long startingSeqNo,  
                Settings.builder()  
            logger.info("--> Index numDocs {} and flush", numDocs);  
            }
import static java.util.Collections.emptyMap;
        final IndexShard shard = mock(IndexShard.class);  
        try (ReplicationGroup shards = createGroup(0, settings, indexMapping, new NRTReplicationEngineFactory(), remoteDir)) {  
                Translog.Snapshot snapshot,
import org.opensearch.common.settings.ClusterSettings;  
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
                RetentionLeases retentionLeases,
            ? Store.MetadataSnapshot.EMPTY
        when(routingTable.getByAllocationId(anyString())).thenReturn(null);  
        assertFalse(phase2Called.get());  
                    startingSeqNo,
            final IndexShard primary = shards.getPrimary();
            void phase1(
                    snapshot,  
        final IndexShardRoutingTable routingTable = mock(IndexShardRoutingTable.class);
            assertDocCount(primary, numDocs + moreDocs);
            @Override  
            // Step 6 - Start new replica, recovery happens, and check that new replica has all docs  
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();  
        }
                ActionListener<SendFileResult> listener,
        "index",
            metadataSnapshot,
            shards.assertAllEqual(numDocs + moreDocs);
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});  
            shards.flush();
        assertFalse(phase1Called.get());
import java.util.function.IntSupplier;  
                phase2Called.set(true);
        };  
        return new StartRecoveryRequest(
        final AtomicBoolean phase2Called = new AtomicBoolean();
            shards.startPrimary();  
        Store.MetadataSnapshot metadataSnapshot = randomBoolean()
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        final RecoverySourceHandler handler = new RemoteStorePeerRecoverySourceHandler(
                boolean skipCreateRetentionLeaseStep  
import org.opensearch.index.seqno.SeqNoStats;
            // Step 2 - Start replica for recovery to happen, check both has same number of docs  
            assertFalse(primary.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replica2.routingEntry())));
            @Override  
        when(shard.isRelocatedPrimary()).thenReturn(false);  
            int numDocs = shards.indexDocs(randomIntBetween(10, 20));
            // Step 5 - Check retention lease does not exist for the replica shard
            logger.info("--> Added and started replica {}", replica1.routingEntry());
import org.opensearch.common.settings.Settings;
        final String indexMapping = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": {} }";
import org.opensearch.index.seqno.SequenceNumbers;  
                    listener
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
            randomBoolean(),
            assertEquals(1, primary.getRetentionLeases().leases().size());
            ) {
import org.opensearch.cluster.node.DiscoveryNode;
                super.prepareTargetForTranslog(totalTranslogOps, listener);  
import org.opensearch.core.index.shard.ShardId;
import static org.mockito.ArgumentMatchers.any;
            : new Store.MetadataSnapshot(  
import org.opensearch.index.mapper.MapperService;
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
package org.opensearch.indices.recovery;
