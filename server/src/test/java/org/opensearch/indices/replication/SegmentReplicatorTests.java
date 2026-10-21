import org.opensearch.cluster.routing.RoutingTable;
        indexOutput.writeLong(primaryCheckpoint.getSegmentInfosVersion());
                new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
        // assert shard failure on corruption
        segmentReplicator.updateReplicationCheckpointStats(legacyPrimaryCheckpoint, replicaShard);
        segmentReplicator.updateReplicationCheckpointStats(firstReplicationCheckpoint, replicaShard);
        segmentReplicator.initializeStats(shardId);
                List<StoreFileMetadata> filesToFetch,
        ReplicationStats finalStats = segmentReplicator.getSegmentReplicationStats(shardId);
     */
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(localCheckpoint);
        );
import org.opensearch.cluster.ClusterState;
        segmentReplicator.startReplication(shard);
        when(replicaShard.shardId()).thenReturn(shardId);
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(thirdReplicationCheckpoint);
import org.opensearch.common.lucene.Lucene;
import org.opensearch.common.settings.Settings;
import java.io.UncheckedIOException;
    }
            stringStoreFileMetadataMapOne,
        ReplicationCheckpoint legacyMetadataCheckpoint = metadata.getReplicationCheckpoint();
    public void testGetSegmentReplicationStats_WhenNoReplication() {
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(0, replicationStats.maxReplicationLag);
                } catch (IOException e) {
     * A checkpoint deserialized from a node older than 3.0.0 has createdTimeStamp == 0. Lag must be measured from the time the
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        when(factory.get(replica)).thenReturn(new TestReplicationSource() {
            .build();
                resolveCheckpointListener(listener, primary);
        segmentReplicator.initializeStats(shardId);
import org.opensearch.indices.recovery.RecoverySettings;
import org.apache.lucene.util.BytesRef;
    public void testGetSegmentReplicationStats_LagIsNeverNegative() {
                }
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapTwo = new HashMap<>();
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapTwo = new HashMap<>();
            shardId,
                    .build()
     * checkpoint was received, not from the Unix epoch.
        stringStoreFileMetadataMapTwo.put("test-2", storeFileMetadata2);
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)
import org.opensearch.OpenSearchCorruptionException;
        }
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 100, "1", Version.LATEST, new BytesRef(100));
        assertEquals(1200, replicationStatsSecond.totalBytesBehind);
        ReplicationCheckpoint localCheckpoint = ReplicationCheckpoint.empty(shardId);
        // Serialize the checkpoint the way a VERSION_ONE metadata file was written: every field except createdTimeStamp.
        SegmentReplicator replicator = new SegmentReplicator(threadPool);
            ) {
    public void testGetSegmentReplicationStats_WhenCheckpointHasNoCreatedTimestamp() {
            2,
        });
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        ShardId shardId = new ShardId("index", "uuid", 0);
            3,
        shardRoutingTable.addShard(primary.routingEntry().moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, "test")));
        ReplicationCheckpoint primaryCheckpoint = new ReplicationCheckpoint(shardId, 2, 2, 2, 500, "", metadataMap);
    private static final Settings settings = Settings.builder()
    public void testReplicationFails() throws Exception {
            "lag " + stats.maxReplicationLag + "ms exceeds time since receive " + elapsedSinceReceive + "ms",
            indexDoc(primary, "_doc", Integer.toString(i));
            new HashMap<>(),
                BiConsumer<String, Long> fileProgressTracker,
            .routingTable(
            200,
            @Override
        ClusterService cs = mock(ClusterService.class);
                    Map<String, StoreFileMetadata> segmentMetadataMap = primary.getSegmentMetadataMap();
        stringStoreFileMetadataMapOne.put("test-1", storeFileMetadata1);
        ReplicationStats stats = segmentReplicator.getSegmentReplicationStats(shardId);
                List<StoreFileMetadata> filesToFetch,
                RoutingTable.builder()
        indexOutput.writeLong(0);
                    .add(IndexRoutingTable.builder(replica.shardId().getIndex()).addIndexShard(indexShard.build()).build())
        ReplicationStats stats = segmentReplicator.getSegmentReplicationStats(shardId);
    public void testGetSegmentReplicationStats_WhileOnGoingReplicationAndPrimaryRefreshedToNewCheckPoint() throws InterruptedException {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.index.shard.ShardId;
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        assertEquals(1200, replicationStatsFirst.totalBytesBehind);
        assertEquals(0L, legacyPrimaryCheckpoint.getCreatedTimeStamp());
        StoreFileMetadata storeFileMetadata2 = new StoreFileMetadata("test-2", 500, "1", Version.LATEST, new BytesRef(500));
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
            1,
            ) {
        }
        IndexShard replicaShard = mock(IndexShard.class);
        ShardId shardId = new ShardId("index", "uuid", 0);
package org.opensearch.indices.replication;
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapOne = new HashMap<>();
                } catch (IOException e) {
        indexOutput.close();
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(localCheckpoint);
        assertEquals(0, finalStats.totalBytesBehind);
        StoreFileMetadata storeFileMetadata3 = new StoreFileMetadata("test-3", 200, "1", Version.LATEST, new BytesRef(200));
        assertEquals(primaryCheckpoint.getSegmentInfosVersion(), legacyMetadataCheckpoint.getSegmentInfosVersion());
import java.io.IOException;
        stringStoreFileMetadataMapTwo.put("test-1", storeFileMetadata1);
        expectThrows(IllegalStateException.class, () -> replicator.startReplication(replica));
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(legacyPrimaryCheckpoint);
        assertBusy(() -> assertDocCount(replica, numDocs));
        IndexShard replicaShard = mock(IndexShard.class);
import java.util.function.BiConsumer;
                    }
        replicator.setSourceFactory(new SegmentReplicationSourceFactory(mock(TransportService.class), mock(RecoverySettings.class), cs));
        assertEquals(500, stats.totalBytesBehind);
            1,
        // primary clock ahead of this node: createdTimeStamp one hour in the future
        ShardId shardId = new ShardId("index", "uuid", 0);
    }
        assertTrue(replicationStatsSecond.maxReplicationLag > 0);
import org.apache.lucene.util.Version;
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        indexOutput.writeMapOfStrings(uploadedSegments);
    public void testGetSegmentReplicationStats_WhenCheckpointFromVersionOneRemoteMetadata() throws IOException {
        assertEquals(200, replicationStatsSecond.maxBytesBehind);
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        segmentReplicator.setSourceFactory(factory);
import java.util.ArrayList;
            1000,
import static org.mockito.Mockito.when;
        try (final CopyState copyState = new CopyState(primary)) {
            500,
        closeShards(replica, primary);
            "",
        // once the replica catches up the entry is pruned and lag drops to zero
        IndexShard replicaShard = mock(IndexShard.class);
            ) {
                resolveCheckpointListener(listener, primary);
import org.mockito.Mockito;
        assertEquals(0, stats.maxReplicationLag);
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.apache.lucene.store.IOContext;
        when(threadpool.generic()).thenReturn(mock);
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        ShardId shardId = new ShardId("index", "uuid", 0);
        stringStoreFileMetadataMapTwo.put("test-3", storeFileMetadata3);
        assertEquals(0, replicationStats.totalBytesBehind);
    /**
        segmentReplicator.updateReplicationCheckpointStats(checkpoint, replicaShard);
                OpenSearchCorruptionException corruptIndexException = new OpenSearchCorruptionException("test");
        stringStoreFileMetadataMapOne.put("test-1", storeFileMetadata1);
        ClusterService cs = mock(ClusterService.class);
        ReplicationCheckpoint secondReplicationCheckpoint = new ReplicationCheckpoint(
        ShardId shardId = new ShardId("index", "uuid", 0);
import org.opensearch.index.ReplicationStats;
import org.opensearch.cluster.service.ClusterService;
            "",
        ReplicationCheckpoint thirdReplicationCheckpoint = new ReplicationCheckpoint(
import org.apache.lucene.store.OutputStreamIndexOutput;
            3,
            2,
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(ReplicationCheckpoint.empty(shardId));
                try {
            shardId,
        segmentReplicator.initializeStats(shardId);
        Map<String, StoreFileMetadata> metadataMap = new HashMap<>();
            shardId,
        // shard is up to date, should not have any tracked stats
        assertTrue(replicationStatsFirst.maxReplicationLag > 0);
        stringStoreFileMetadataMapOne.put("test-2", storeFileMetadata2);
                        indexShard.store().directory().copyFrom(primary.store().directory(), file, file, IOContext.DEFAULT);
        segmentReplicator.updateReplicationCheckpointStats(thirdReplicationCheckpoint, replicaShard);
            stats.maxReplicationLag >= 0 && stats.maxReplicationLag <= elapsedSinceReceive + 1_000
        primary.refresh("test");
        ReplicationCheckpoint firstReplicationCheckpoint = ReplicationCheckpoint.empty(shardId);
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.opensearch.common.io.stream.BytesStreamOutput;
            2,
                ReplicationCheckpoint checkpoint,
        ReplicationStats replicationStatsSecond = segmentReplicator.getSegmentReplicationStats(shardId);
        ExecutorService mock = mock(ExecutorService.class);
            public void getSegmentFiles(
        segmentReplicator.updateReplicationCheckpointStats(legacyMetadataCheckpoint, replicaShard);
            .thenReturn(firstReplicationCheckpoint);
        segmentReplicator.pruneCheckpointsUpToLastSync(replicaShard);
        int numDocs = randomIntBetween(10, 20);
        indexOutput.writeLong(primaryCheckpoint.getSegmentsGen());
        segmentReplicator.startReplication(replica);
        segmentReplicator.pruneCheckpointsUpToLastSync(replicaShard);
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadataHandler;
        indexOutput.writeString(shardId.getIndex().getName());
import org.opensearch.cluster.routing.UnassignedInfo;
    }
        when(replicaShard.shardId()).thenReturn(shardId);
        StoreFileMetadata storeFileMetadata2 = new StoreFileMetadata("test-2", 500, "1", Version.LATEST, new BytesRef(500));
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
                ReplicationCheckpoint checkpoint,
        assertTrue(segmentReplicator.replicationCheckpointStats.get(shardId).isEmpty());
import java.util.concurrent.atomic.AtomicBoolean;
        assertEquals(500, stats.totalBytesBehind);
 * The OpenSearch Contributors require contributions made to
        segmentReplicator.setSourceFactory(factory);
            2,
        long beforeReceive = System.currentTimeMillis();
     */
}
            baseTime - 1_000_000
                ActionListener<GetSegmentFilesResponse> listener
        metadataMap.put("_0.cfe", storeFileMetadata1);
        for (int i = 0; i < numDocs; i++) {
        ReplicationStats replicationStatsSecond = segmentReplicator.getSegmentReplicationStats(shardId);
        indexOutput.writeVInt(shardId.getId());
    public void testUpdateReplicationCheckpointStatsIgnoresWhenOutOfOrderCheckPointReceived() {
        segmentReplicator.updateReplicationCheckpointStats(secondReplicationCheckpoint, replicaShard);
            stringStoreFileMetadataMapTwo,
                long replicationId,
    }
                    listener.onResponse(new GetSegmentFilesResponse(new ArrayList<>(segmentMetadataMap.values())));
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
                    throw new RuntimeException(e);
    }
        ShardId shardId = new ShardId("index", "uuid", 0);
import org.opensearch.index.shard.IndexShard;
        closeShards(replica, primary);
    /**
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(firstReplicationCheckpoint)
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 500, "1", Version.LATEST, new BytesRef(500));
import org.opensearch.core.action.ActionListener;
            ) {
            3,
        assertEquals(500, stats.maxBytesBehind);
        assertEquals(0, finalStats.totalBytesBehind);
            new ByteArrayIndexInput("md", BytesReference.toBytes(output.bytes()))
    public void testReplicationWithUnknownPrimaryNode() throws Exception {
            1,
    }
        assertTrue(
import org.opensearch.threadpool.ThreadPool;
        when(factory.get(replica)).thenReturn(new TestReplicationSource() {
            2,
        ReplicationStats replicationStats = segmentReplicator.getSegmentReplicationStats(shardId);
 * this file be licensed under the Apache-2.0 license or a
    public void testStartReplicationRunsSuccessfully() throws Exception {
            stringStoreFileMetadataMapOne,
        );
                ReplicationCheckpoint checkpoint,
        // lag is bounded by the time elapsed since the checkpoint was received on this node, not by the epoch
        Map<String, StoreFileMetadata> metadataMap = new HashMap<>();
        );
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("_0.cfe", 500, "1", Version.LATEST, new BytesRef(500));
    }
            @Override
        stringStoreFileMetadataMapTwo.put("test-1", storeFileMetadata1);
                    throw new RuntimeException(e);
            @Override
        long elapsedSinceReceive = System.currentTimeMillis() - beforeReceive;
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("md", "md", output, 4096);
        assertEquals(0L, legacyMetadataCheckpoint.getCreatedTimeStamp());
        expectThrows(IllegalStateException.class, () -> replicator.startReplication(replica));
import org.opensearch.indices.replication.common.ReplicationType;
        assertEquals(1200, replicationStatsFirst.maxBytesBehind);
     * Remote-store replicas obtain the primary's checkpoint from the segment metadata file rather than over the wire
/*
        stringStoreFileMetadataMapOne.put("test-2", storeFileMetadata2);
            200,
        IndexShard replicaShard = mock(IndexShard.class);
                }
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadpool);
    public void testStartReplicationWithoutSourceFactory() {
        assertEquals(0, finalStats.maxReplicationLag);
import java.util.HashMap;
            new HashMap<>(),
        );
        replicator.setSourceFactory(new SegmentReplicationSourceFactory(mock(TransportService.class), mock(RecoverySettings.class), cs));
        long beforeReceive = System.currentTimeMillis();
            }
        assertEquals(1200, replicationStatsFirst.maxBytesBehind);
import org.opensearch.transport.TransportService;
        return ClusterState.builder(clusterService.state())
        IndexShardRoutingTable.Builder shardRoutingTable = new IndexShardRoutingTable.Builder(replica.shardId());
        shardRoutingTable.addShard(primary.routingEntry());
import org.opensearch.index.shard.IndexShardTestCase;
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
import org.opensearch.common.time.DateUtils;
            shardId,
        ReplicationStats replicationStatsFirst = segmentReplicator.getSegmentReplicationStats(shardId);
        SegmentReplicationSourceFactory factory = mock(SegmentReplicationSourceFactory.class);
    }
                ActionListener<CheckpointInfoResponse> listener
import static org.mockito.Mockito.mock;
        long elapsedSinceReceive = System.currentTimeMillis() - beforeReceive;
            "lag " + stats.maxReplicationLag + "ms exceeds time since receive " + elapsedSinceReceive + "ms",
                ActionListener<CheckpointInfoResponse> listener
        when(cs.state()).thenReturn(buildClusterState(replica, shardRoutingTable));
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 500, "1", Version.LATEST, new BytesRef(500));
            2,
            .thenReturn(secondReplicationCheckpoint);
        );
        when(replicaShard.shardId()).thenReturn(shardId);
        segmentReplicator.updateReplicationCheckpointStats(firstReplicationCheckpoint, replicaShard);
        ReplicationStats finalStats = segmentReplicator.getSegmentReplicationStats(shardId);
        Map<String, String> uploadedSegments = new HashMap<>();
        SegmentReplicator segmentReplicator = spy(new SegmentReplicator(threadPool));
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)
        ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(shardId, 2, 2, 2, 100, "", metadataMap, futureTimestamp);
                ActionListener<GetSegmentFilesResponse> listener
            public void getCheckpointMetadata(
        assertEquals(0, finalStats.maxBytesBehind);
        assertEquals(replicationCheckpoint, segmentReplicator.getPrimaryCheckpoint(shardId));
        allowShardFailures();
import java.util.concurrent.TimeUnit;
            "",
            listener.onResponse(
        // createdTimeStamp == 0, as produced by ReplicationCheckpoint(StreamInput) for a sender older than 3.0.0
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)
        assertTrue(
                long replicationId,
        when(cs.state()).thenReturn(buildClusterState(replica, shardRoutingTable));
        ReplicationCheckpoint localCheckpoint = ReplicationCheckpoint.empty(shardId);
import java.util.List;
        ReplicationCheckpoint replicationCheckpoint = new ReplicationCheckpoint(
        closeShards(primary, replica);
    protected void resolveCheckpointListener(ActionListener<CheckpointInfoResponse> listener, IndexShard primary) {
        Mockito.verifyNoInteractions(mock);
import org.opensearch.cluster.routing.IndexRoutingTable;
        stringStoreFileMetadataMapTwo.put("test-2", storeFileMetadata2);
        assertEquals(0, finalStats.maxReplicationLag);
        segmentReplicator.pruneCheckpointsUpToLastSync(replicaShard);
        metadataMap.put("test-1", storeFileMetadata1);
                long replicationId,
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        ReplicationStats replicationStatsFirst = segmentReplicator.getSegmentReplicationStats(shardId);
                ReplicationCheckpoint checkpoint,
        when(replicaShard.shardId()).thenReturn(shardId);
            3,
 */
        when(replicaShard.shardId()).thenReturn(shardId);
        long baseTime = DateUtils.toLong(Instant.now());
                    indexShard.store().markStoreCorrupted(corruptIndexException);
        StoreFileMetadata storeFileMetadata3 = new StoreFileMetadata("test-3", 200, "1", Version.LATEST, new BytesRef(200));
        );
        assertTrue(primaryCheckpoint.getCreatedTimeStamp() > 0);
        metadataMap.put("test-1", storeFileMetadata1);
            public void getSegmentFiles(
        SegmentReplicator replicator = new SegmentReplicator(threadPool);
                BiConsumer<String, Long> fileProgressTracker,
            2,
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
            3,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                IndexShard indexShard,
            .thenReturn(firstReplicationCheckpoint)
            .thenReturn(firstReplicationCheckpoint)
        shardRoutingTable.addShard(replica.routingEntry());
            1000,
            }
            throw new UncheckedIOException(e);
        assertEquals(0, replicationStats.maxBytesBehind);
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 500, "1", Version.LATEST, new BytesRef(500));
        ThreadPool threadpool = mock(ThreadPool.class);
        segmentReplicator.initializeStats(shardId);
        } catch (IOException e) {
        SegmentReplicationSourceFactory factory = mock(SegmentReplicationSourceFactory.class);
            .thenReturn(firstReplicationCheckpoint)
        ReplicationCheckpoint legacyPrimaryCheckpoint = new ReplicationCheckpoint(shardId, 2, 2, 2, 500, "", metadataMap, 0L);
            1000,
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
 * compatible open source license.
import java.util.concurrent.ExecutorService;
            baseTime - 5_000_000
        assertTrue(replicationStatsFirst.maxReplicationLag > 0);
    }
import org.opensearch.index.replication.TestReplicationSource;
            );
        shardRoutingTable.addShard(replica.routingEntry());
public class SegmentReplicatorTests extends IndexShardTestCase {
        uploadedSegments.put("_0.cfe", "_0.cfe::_0.cfe__uuid::1::500::" + Version.LATEST.major);
        indexOutput.writeLong(primaryCheckpoint.getPrimaryTerm());
            }
     * ({@code RemoteStoreReplicationSource#getCheckpointMetadata}). A metadata file written before
        assertEquals(200, replicationStatsSecond.totalBytesBehind);
        );
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("lag must not be the Unix epoch", stats.maxReplicationLag < TimeUnit.DAYS.toMillis(1));
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        closeShards(primary, replica);
        });
                listener.onFailure(corruptIndexException);
        segmentReplicator.updateReplicationCheckpointStats(secondReplicationCheckpoint, replicaShard);
    }
        indexOutput.writeString(shardId.getIndex().getUUID());
        stringStoreFileMetadataMapTwo.put("test-3", storeFileMetadata3);
        indexOutput.writeBytes(new byte[0], 0);
            @Override
            stats.maxReplicationLag >= 0 && stats.maxReplicationLag <= elapsedSinceReceive + 1_000
            shardId,
            public void getCheckpointMetadata(
                    for (String file : segmentMetadataMap.keySet()) {
    private ClusterState buildClusterState(IndexShard replica, IndexShardRoutingTable.Builder indexShard) {
        segmentReplicator.startReplication(replica);
        );
    }
        ReplicationCheckpoint thirdReplicationCheckpoint = new ReplicationCheckpoint(
        .build();
        segmentReplicator.updateReplicationCheckpointStats(thirdReplicationCheckpoint, replicaShard);
        ShardId shardId = new ShardId("index", "uuid", 0);
 *
        RemoteSegmentMetadata metadata = new RemoteSegmentMetadataHandler(RemoteSegmentMetadata.VERSION_ONE).readContent(
        when(replicaShard.shardId()).thenReturn(shardId);
        IndexShard shard = mock(IndexShard.class);
import org.opensearch.indices.replication.common.CopyState;
        segmentReplicator.updateReplicationCheckpointStats(replicationCheckpoint, replicaShard);
        long futureTimestamp = DateUtils.toLong(Instant.now()) + TimeUnit.HOURS.toNanos(1);
    public void testGetSegmentReplicationStats_WhenCheckPointReceivedOutOfOrder() {
            "",
import java.time.Instant;
    public void testReplicationWithUnassignedPrimary() throws Exception {
        ReplicationStats stats = segmentReplicator.getSegmentReplicationStats(shardId);
            3,
        assertEquals(1200, replicationStatsSecond.maxBytesBehind);
        AtomicBoolean failureCallbackTriggered = new AtomicBoolean(false);
        Map<String, StoreFileMetadata> metadataMap = new HashMap<>();
        SegmentReplicator segmentReplicator = spy(new SegmentReplicator(threadPool));
            shardId,
            stringStoreFileMetadataMapTwo,
    }
        );
            )
    }
            }
        // shard finished syncing to last checkpoint (sis 3)
        assertEquals(100, stats.totalBytesBehind);
        IndexShard replicaShard = mock(IndexShard.class);
import org.opensearch.index.store.StoreFileMetadata;
        assertEquals(1200, replicationStatsFirst.totalBytesBehind);
        ReplicationCheckpoint oldReplicationCheckpoint = new ReplicationCheckpoint(
        IndexShard replicaShard = mock(IndexShard.class);
        IndexShardRoutingTable.Builder shardRoutingTable = new IndexShardRoutingTable.Builder(replica.shardId());
        indexOutput.writeString(primaryCheckpoint.getCodec());
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        segmentReplicator.updateReplicationCheckpointStats(oldReplicationCheckpoint, replicaShard);
     * {@link RemoteSegmentMetadata#VERSION_TWO} carries no created timestamp and is read back with createdTimeStamp == 0.
                    Lucene.cleanLuceneIndex(indexShard.store().directory());
            "",
        ReplicationCheckpoint secondReplicationCheckpoint = new ReplicationCheckpoint(
            2,
        replica.addShardFailureCallback((ig) -> failureCallbackTriggered.set(true));
import static org.mockito.Mockito.spy;
        assertBusy(() -> assertTrue(failureCallbackTriggered.get()));
        // index and copy segments to replica.
        assertEquals(replicationCheckpoint, segmentReplicator.getPrimaryCheckpoint(shardId));
        BytesStreamOutput output = new BytesStreamOutput();
                IndexShard indexShard,
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
    }
        assertTrue(replicationStatsSecond.maxReplicationLag > 0);
        segmentReplicator.initializeStats(shardId);
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(firstReplicationCheckpoint)
import java.util.Map;
            "",
                try {
                long replicationId,
        indexOutput.writeLong(primaryCheckpoint.getLength());
        ReplicationCheckpoint firstReplicationCheckpoint = ReplicationCheckpoint.empty(shardId);
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapOne = new HashMap<>();
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
            2,
