 * this file be licensed under the Apache-2.0 license or a
            );
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
import org.opensearch.Version;
            }
import java.nio.file.Path;
                RetentionLeases retentionLeases,
import org.opensearch.index.store.Store;
                );
                ActionListener<SendFileResult> listener,
package org.opensearch.indices.recovery;
import org.opensearch.index.seqno.SequenceNumbers;
            shards.startPrimary();
import static java.util.Collections.emptyMap;
            int moreDocs = shards.indexDocs(randomIntBetween(10, 20));
    private final ShardId shardId = new ShardId(INDEX_SETTINGS.getIndex(), 1);
            // Step1 - Start primary, index docs and flush
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        "index",
}
            // Step 2 - Start replica for recovery to happen, check both has same number of docs
import org.opensearch.index.translog.Translog;
            randomBoolean() || metadataSnapshot.getHistoryUUID() == null ? SequenceNumbers.UNASSIGNED_SEQ_NO : randomNonNegativeLong()
import static org.mockito.Mockito.times;
import java.util.Collections;
        when(replicationGroup.getRoutingTable()).thenReturn(routingTable);
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);
            between(1, 8),
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
import org.opensearch.index.seqno.ReplicationTracker;
            mock(RecoveryTargetHandler.class),
                ActionListener<SendSnapshotResult> listener
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
            }
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))
        final org.opensearch.index.shard.ReplicationGroup replicationGroup = mock(org.opensearch.index.shard.ReplicationGroup.class);
            // Step 4 - Check both shard has expected number of doc count
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
 *
import org.opensearch.cluster.metadata.IndexMetadata;
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        verify(routingTable, times(5)).getByAllocationId(null);
                    endingSeqNo,
                long maxSeenAutoIdTimestamp,
            void phase2(
            logger.info("--> Index numDocs {} and flush", numDocs);
                    maxSeenAutoIdTimestamp,
        .build();
        when(shard.isRelocatedPrimary()).thenReturn(false);
                prepareTargetForTranslogCalled.set(true);
            assertEquals(getDocIdAndSeqNos(primary), getDocIdAndSeqNos(replica1));
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
                IntSupplier translogOps,
import org.opensearch.common.unit.TimeValue;
            : new Store.MetadataSnapshot(
            @Override
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        final StartRecoveryRequest request = getStartRecoveryRequest();
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(getDocIdAndSeqNos(primary), getDocIdAndSeqNos(replica1));
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
            shardId,
            ? Store.MetadataSnapshot.EMPTY
            // Step 5 - Check retention lease does not exist for the replica shard
            final IndexShard replica2 = shards.addReplica(remoteDir);
            assertFalse(primary.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replica2.routingEntry())));
            request,
import org.opensearch.common.lease.Releasable;
                    startingSeqNo,
                randomIntBetween(0, 100)
            final IndexShard replica1 = shards.addReplica(remoteDir);
        doAnswer(invocation -> {
            // Step 7 - Check retention lease does not exist for the replica shard
                phase1Called.set(true);
            between(1, 8)
                CatalogSnapshot snapshot,
        final IndexShardRoutingTable routingTable = mock(IndexShardRoutingTable.class);
import org.opensearch.test.VersionUtils;
import org.opensearch.index.engine.SegmentsStats;
                long startingSeqNo,
import static java.util.Collections.emptySet;
                super.phase2(
            randomBoolean(),
        expectThrows(DelayRecoveryException.class, () -> {
            void phase1(
import org.opensearch.action.support.PlainActionFuture;
            shards.startAll();
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));
        });
 * compatible open source license.
            primary.refresh("test");
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.core.action.ActionListener;
            shards.startAll();
import static org.mockito.ArgumentMatchers.anyString;
    }
                    mappingVersion,
public class RemoteStorePeerRecoverySourceHandlerTests extends OpenSearchIndexLevelReplicationTestCase {
        }
import java.io.IOException;
            final IndexShard primary = shards.getPrimary();
import org.opensearch.common.settings.ClusterSettings;
        assertFalse(phase1Called.get());
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
            indexMetadata.state(IndexMetadata.State.CLOSE);
    public void testReplicaShardRecoveryUptoLastFlushedCommit() throws Exception {
            shards.assertAllEqual(numDocs + moreDocs);
    private static final Settings settings = Settings.builder()
        ) {
import org.opensearch.core.index.shard.ShardId;
            threadPool,
                Translog.Snapshot snapshot,
    );
import org.opensearch.common.settings.Settings;
            handler.recoverToTarget(future);
    public StartRecoveryRequest getStartRecoveryRequest() throws IOException {
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
            assertEquals(1, primary.getRetentionLeases().leases().size());
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
            assertDocCount(replica1, numDocs + moreDocs);
        }
                Settings.builder()
            @Override
import org.opensearch.indices.replication.common.ReplicationType;
    }
        final AtomicBoolean phase2Called = new AtomicBoolean();
        PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
import org.opensearch.index.IndexSettings;
import java.util.function.IntSupplier;
                    maxSeqNoOfUpdatesOrDeletes,
import static org.mockito.Mockito.verify;
            .settings(
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
import static org.mockito.Mockito.doAnswer;
            null,
        final AtomicBoolean phase1Called = new AtomicBoolean();
        final RecoverySourceHandler handler = new RemoteStorePeerRecoverySourceHandler(
        when(routingTable.getByAllocationId(anyString())).thenReturn(null);
                Collections.emptyMap(),
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
import static org.mockito.ArgumentMatchers.anyBoolean;
            }
    }
            shards.flush();
        assertFalse(phase2Called.get());
        .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "100ms")
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));
                phase2Called.set(true);
            // Step 6 - Start new replica, recovery happens, and check that new replica has all docs
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
                super.prepareTargetForTranslog(totalTranslogOps, listener);
            assertEquals(1, primary.getRetentionLeases().leases().size());
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});
import static org.mockito.Mockito.mock;
            // Step 3 - Index more docs, run segment replication, check both have same number of docs
/*
import org.opensearch.index.seqno.SeqNoStats;
        final IndexShard shard = mock(IndexShard.class);
import org.opensearch.index.shard.IndexShard;
import org.opensearch.index.engine.NRTReplicationEngineFactory;
            );
                    listener
            logger.info("--> Added and started replica {}", replica2.routingEntry());
            randomNonNegativeLong(),
        return new StartRecoveryRequest(
        final Path remoteDir = createTempDir();
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();
                Collections.singletonMap(Engine.HISTORY_UUID_KEY, UUIDs.randomBase64UUID()),
            metadataSnapshot,
import static org.mockito.Mockito.when;
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
 */
            assertDocCount(primary, numDocs + moreDocs);
                long endingSeqNo,
        try (ReplicationGroup shards = createGroup(0, settings, indexMapping, new NRTReplicationEngineFactory(), remoteDir)) {
import org.opensearch.index.mapper.MapperService;
            @Override
        assertFalse(prepareTargetForTranslogCalled.get());
import org.opensearch.index.engine.Engine;
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
                boolean skipCreateRetentionLeaseStep
                    snapshot,
import static org.mockito.ArgumentMatchers.any;
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
            logger.info("--> Added and started replica {}", replica1.routingEntry());
                long maxSeqNoOfUpdatesOrDeletes,
        );
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        };
                long startingSeqNo,
            ) {
    private final ClusterSettings service = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            ) throws IOException {
                long mappingVersion,
    public void testThrowExceptionOnNoTargetInRouting() throws IOException {
        Store.MetadataSnapshot metadataSnapshot = randomBoolean()
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
            assertFalse(primary.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replica1.routingEntry())));
            replicateSegments(primary, shards.getReplicas());
import org.opensearch.common.UUIDs;
        if (randomBoolean()) {
import org.opensearch.index.seqno.RetentionLeases;
        final String indexMapping = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": {} }";
            future.actionGet();
 * The OpenSearch Contributors require contributions made to
                    retentionLeases,
import org.opensearch.test.IndexSettingsModule;
            int numDocs = shards.indexDocs(randomIntBetween(10, 20));
            logger.info("--> Index more docs {} and replicate segments", moreDocs);
            shard,
            return null;
