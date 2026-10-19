        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        closeShards(primary, replica);
        StoreFileMetadata storeFileMetadata3 = new StoreFileMetadata("test-3", 200, "1", Version.LATEST, new BytesRef(200));
    public void testReplicationWithUnassignedPrimary() throws Exception {
        ReplicationCheckpoint replicationCheckpoint = new ReplicationCheckpoint(
        assertTrue("lag must not be the Unix epoch", stats.maxReplicationLag < TimeUnit.DAYS.toMillis(1));
            public void getSegmentFiles(  
        SegmentReplicationSourceFactory factory = mock(SegmentReplicationSourceFactory.class);
        stringStoreFileMetadataMapTwo.put("test-2", storeFileMetadata2);  
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)
                    }
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapOne = new HashMap<>();
        segmentReplicator.pruneCheckpointsUpToLastSync(replicaShard);
        // lag is bounded by the time elapsed since the checkpoint was received on this node, not by the epoch
        );
            3,
        segmentReplicator.updateReplicationCheckpointStats(oldReplicationCheckpoint, replicaShard);
        indexOutput.writeLong(primaryCheckpoint.getLength());  
import org.opensearch.common.lucene.Lucene;
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        closeShards(replica, primary);
                    for (String file : segmentMetadataMap.keySet()) {
        segmentReplicator.pruneCheckpointsUpToLastSync(replicaShard);
    }  
            2,
        ReplicationCheckpoint firstReplicationCheckpoint = ReplicationCheckpoint.empty(shardId);
        ReplicationCheckpoint legacyMetadataCheckpoint = metadata.getReplicationCheckpoint();  
import java.io.UncheckedIOException;
import java.util.List;  
        assertEquals(0, replicationStats.maxBytesBehind);
import org.opensearch.index.engine.NRTReplicationEngineFactory;
import org.opensearch.indices.replication.common.CopyState;
        segmentReplicator.updateReplicationCheckpointStats(secondReplicationCheckpoint, replicaShard);
import java.util.HashMap;
                new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
                }
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        ReplicationStats replicationStatsFirst = segmentReplicator.getSegmentReplicationStats(shardId);  
        ReplicationCheckpoint localCheckpoint = ReplicationCheckpoint.empty(shardId);
import org.opensearch.index.ReplicationStats;  
            .thenReturn(secondReplicationCheckpoint);
            baseTime - 1_000_000
    private ClusterState buildClusterState(IndexShard replica, IndexShardRoutingTable.Builder indexShard) {  
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
    }
            2,
import org.opensearch.core.common.bytes.BytesReference;
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapTwo = new HashMap<>();
        segmentReplicator.updateReplicationCheckpointStats(firstReplicationCheckpoint, replicaShard);  
            )  
            new HashMap<>(),
        indexOutput.writeMapOfStrings(uploadedSegments);
        assertTrue(
import java.util.concurrent.TimeUnit;  
                BiConsumer<String, Long> fileProgressTracker,
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(firstReplicationCheckpoint)  
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 500, "1", Version.LATEST, new BytesRef(500));  
import org.opensearch.cluster.routing.UnassignedInfo;
        assertEquals(0, finalStats.maxBytesBehind);
        ShardId shardId = new ShardId("index", "uuid", 0);  
        assertEquals(1200, replicationStatsSecond.maxBytesBehind);
public class SegmentReplicatorTests extends IndexShardTestCase {
 * The OpenSearch Contributors require contributions made to  
            .build();
        assertEquals(0, finalStats.maxReplicationLag);
import org.mockito.Mockito;
                        indexShard.store().directory().copyFrom(primary.store().directory(), file, file, IOContext.DEFAULT);  
        return ClusterState.builder(clusterService.state())
import org.opensearch.OpenSearchCorruptionException;
     * A checkpoint deserialized from a node older than 3.0.0 has createdTimeStamp == 0. Lag must be measured from the time the
        );
        assertTrue(segmentReplicator.replicationCheckpointStats.get(shardId).isEmpty());
        stringStoreFileMetadataMapOne.put("test-1", storeFileMetadata1);  
                    .build()
        int numDocs = randomIntBetween(10, 20);
        });  
        Mockito.verifyNoInteractions(mock);  
        assertEquals(200, replicationStatsSecond.maxBytesBehind);  
        IndexShard replicaShard = mock(IndexShard.class);
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(firstReplicationCheckpoint)
/*  
                    .add(IndexRoutingTable.builder(replica.shardId().getIndex()).addIndexShard(indexShard.build()).build())
            .thenReturn(firstReplicationCheckpoint)
import java.util.function.BiConsumer;
        assertTrue(replicationStatsSecond.maxReplicationLag > 0);
        metadataMap.put("_0.cfe", storeFileMetadata1);
    public void testGetSegmentReplicationStats_WhenCheckPointReceivedOutOfOrder() {
        ReplicationStats replicationStats = segmentReplicator.getSegmentReplicationStats(shardId);
        RemoteSegmentMetadata metadata = new RemoteSegmentMetadataHandler(RemoteSegmentMetadata.VERSION_ONE).readContent(  
    }
        // primary clock ahead of this node: createdTimeStamp one hour in the future  
        SegmentReplicationSourceFactory factory = mock(SegmentReplicationSourceFactory.class);  
            }  
     * {@link RemoteSegmentMetadata#VERSION_TWO} carries no created timestamp and is read back with createdTimeStamp == 0.
                ActionListener<CheckpointInfoResponse> listener
        segmentReplicator.updateReplicationCheckpointStats(firstReplicationCheckpoint, replicaShard);  
            public void getCheckpointMetadata(  
            3,
        assertEquals(primaryCheckpoint.getSegmentInfosVersion(), legacyMetadataCheckpoint.getSegmentInfosVersion());
package org.opensearch.indices.replication;
        segmentReplicator.updateReplicationCheckpointStats(checkpoint, replicaShard);
                listener.onFailure(corruptIndexException);
        ShardId shardId = new ShardId("index", "uuid", 0);
        segmentReplicator.initializeStats(shardId);  
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
    }
            500,  
                } catch (IOException e) {
import java.io.IOException;
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
            1000,
import org.apache.lucene.store.OutputStreamIndexOutput;
        assertEquals(0, replicationStats.totalBytesBehind);  
                long replicationId,
        shardRoutingTable.addShard(primary.routingEntry());
        segmentReplicator.updateReplicationCheckpointStats(thirdReplicationCheckpoint, replicaShard);
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadpool);
        // Serialize the checkpoint the way a VERSION_ONE metadata file was written: every field except createdTimeStamp.  
        stringStoreFileMetadataMapTwo.put("test-2", storeFileMetadata2);
import org.opensearch.cluster.service.ClusterService;  
        assertEquals(0L, legacyPrimaryCheckpoint.getCreatedTimeStamp());
        IndexShard replicaShard = mock(IndexShard.class);
    public void testGetSegmentReplicationStats_WhenNoReplication() {
    public void testStartReplicationWithoutSourceFactory() {
        stringStoreFileMetadataMapTwo.put("test-1", storeFileMetadata1);
 * compatible open source license.
        indexOutput.close();
                List<StoreFileMetadata> filesToFetch,  
        ClusterService cs = mock(ClusterService.class);  
                long replicationId,  
        stringStoreFileMetadataMapOne.put("test-2", storeFileMetadata2);
        assertBusy(() -> assertTrue(failureCallbackTriggered.get()));  
        primary.refresh("test");  
    public void testGetSegmentReplicationStats_WhenCheckpointHasNoCreatedTimestamp() {
            "",
        segmentReplicator.pruneCheckpointsUpToLastSync(replicaShard);
                ReplicationCheckpoint checkpoint,
        SegmentReplicator replicator = new SegmentReplicator(threadPool);
            2,  
        IndexShard replicaShard = mock(IndexShard.class);  
        BytesStreamOutput output = new BytesStreamOutput();
        IndexShardRoutingTable.Builder shardRoutingTable = new IndexShardRoutingTable.Builder(replica.shardId());
            3,  
                    throw new RuntimeException(e);
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
    private static final Settings settings = Settings.builder()  
            stringStoreFileMetadataMapTwo,
            stats.maxReplicationLag >= 0 && stats.maxReplicationLag <= elapsedSinceReceive + 1_000
        // once the replica catches up the entry is pruned and lag drops to zero  
        when(threadpool.generic()).thenReturn(mock);
import org.opensearch.cluster.routing.RoutingTable;
        segmentReplicator.startReplication(replica);
    }  
        ReplicationStats replicationStatsFirst = segmentReplicator.getSegmentReplicationStats(shardId);
        segmentReplicator.initializeStats(shardId);
        } catch (IOException e) {  
            .thenReturn(firstReplicationCheckpoint);
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapOne = new HashMap<>();
                IndexShard indexShard,  
                    listener.onResponse(new GetSegmentFilesResponse(new ArrayList<>(segmentMetadataMap.values())));
import org.opensearch.indices.recovery.RecoverySettings;  
        ThreadPool threadpool = mock(ThreadPool.class);
        segmentReplicator.initializeStats(shardId);  
        when(cs.state()).thenReturn(buildClusterState(replica, shardRoutingTable));
            1,  
        stringStoreFileMetadataMapTwo.put("test-3", storeFileMetadata3);  
        replicator.setSourceFactory(new SegmentReplicationSourceFactory(mock(TransportService.class), mock(RecoverySettings.class), cs));
                    Map<String, StoreFileMetadata> segmentMetadataMap = primary.getSegmentMetadataMap();
        assertEquals(500, stats.maxBytesBehind);  
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(ReplicationCheckpoint.empty(shardId));  
            ) {
                BiConsumer<String, Long> fileProgressTracker,
        assertEquals(0, finalStats.maxReplicationLag);  
        when(replicaShard.shardId()).thenReturn(shardId);
}
            stringStoreFileMetadataMapOne,  
        shardRoutingTable.addShard(replica.routingEntry());  
import org.opensearch.core.action.ActionListener;  
                OpenSearchCorruptionException corruptIndexException = new OpenSearchCorruptionException("test");
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)  
        ReplicationCheckpoint localCheckpoint = ReplicationCheckpoint.empty(shardId);
        assertEquals(1200, replicationStatsFirst.totalBytesBehind);
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 500, "1", Version.LATEST, new BytesRef(500));
import org.opensearch.common.settings.Settings;
            );
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
        Map<String, StoreFileMetadata> metadataMap = new HashMap<>();
        ClusterService cs = mock(ClusterService.class);
        assertTrue(replicationStatsFirst.maxReplicationLag > 0);
            3,
            stringStoreFileMetadataMapOne,
        IndexShard replicaShard = mock(IndexShard.class);
        ReplicationStats stats = segmentReplicator.getSegmentReplicationStats(shardId);
        assertEquals(1200, replicationStatsFirst.totalBytesBehind);  
            "lag " + stats.maxReplicationLag + "ms exceeds time since receive " + elapsedSinceReceive + "ms",
        IndexShardRoutingTable.Builder shardRoutingTable = new IndexShardRoutingTable.Builder(replica.shardId());
        uploadedSegments.put("_0.cfe", "_0.cfe::_0.cfe__uuid::1::500::" + Version.LATEST.major);
                ActionListener<GetSegmentFilesResponse> listener  
        indexOutput.writeLong(primaryCheckpoint.getSegmentsGen());
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        ReplicationStats replicationStatsSecond = segmentReplicator.getSegmentReplicationStats(shardId);
        replica.addShardFailureCallback((ig) -> failureCallbackTriggered.set(true));  
        Map<String, StoreFileMetadata> metadataMap = new HashMap<>();
                ReplicationCheckpoint checkpoint,
    protected void resolveCheckpointListener(ActionListener<CheckpointInfoResponse> listener, IndexShard primary) {
        assertEquals(500, stats.totalBytesBehind);
    public void testStartReplicationRunsSuccessfully() throws Exception {  
        when(replicaShard.shardId()).thenReturn(shardId);
        );
                long replicationId,  
import org.apache.lucene.store.IOContext;
        ShardId shardId = new ShardId("index", "uuid", 0);  
        }
        ShardId shardId = new ShardId("index", "uuid", 0);  
        StoreFileMetadata storeFileMetadata3 = new StoreFileMetadata("test-3", 200, "1", Version.LATEST, new BytesRef(200));  
        assertTrue(primaryCheckpoint.getCreatedTimeStamp() > 0);
                } catch (IOException e) {  
 */  
import java.util.concurrent.atomic.AtomicBoolean;
            }  
        indexOutput.writeString(primaryCheckpoint.getCodec());
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)  
            listener.onResponse(  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    /**
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 100, "1", Version.LATEST, new BytesRef(100));  
        .build();
        long beforeReceive = System.currentTimeMillis();
            "",
            new ByteArrayIndexInput("md", BytesReference.toBytes(output.bytes()))
            new HashMap<>(),  
        ReplicationStats stats = segmentReplicator.getSegmentReplicationStats(shardId);  
 * SPDX-License-Identifier: Apache-2.0
            2,  
            ) {  
import java.util.ArrayList;
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testGetSegmentReplicationStats_WhenCheckpointFromVersionOneRemoteMetadata() throws IOException {
        assertBusy(() -> assertDocCount(replica, numDocs));
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(thirdReplicationCheckpoint);
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("md", "md", output, 4096);
                RoutingTable.builder()  
        for (int i = 0; i < numDocs; i++) {  
            2,
    public void testGetSegmentReplicationStats_WhileOnGoingReplicationAndPrimaryRefreshedToNewCheckPoint() throws InterruptedException {
            throw new UncheckedIOException(e);
import org.opensearch.cluster.metadata.IndexMetadata;
            System.nanoTime() - TimeUnit.MINUTES.toNanos(1)
            indexDoc(primary, "_doc", Integer.toString(i));
import static org.mockito.Mockito.mock;  
                List<StoreFileMetadata> filesToFetch,
        assertEquals(0, stats.maxReplicationLag);
    }
        indexOutput.writeBytes(new byte[0], 0);  
        indexOutput.writeLong(0);
                resolveCheckpointListener(listener, primary);
        segmentReplicator.updateReplicationCheckpointStats(legacyPrimaryCheckpoint, replicaShard);
        segmentReplicator.updateReplicationCheckpointStats(thirdReplicationCheckpoint, replicaShard);  
        ReplicationCheckpoint oldReplicationCheckpoint = new ReplicationCheckpoint(
import org.opensearch.cluster.routing.IndexRoutingTable;
        closeShards(primary, replica);
            2,
    }
                IndexShard indexShard,
    }  
            .thenReturn(firstReplicationCheckpoint)  
        SegmentReplicator segmentReplicator = spy(new SegmentReplicator(threadPool));
        SegmentReplicator segmentReplicator = spy(new SegmentReplicator(threadPool));
            public void getSegmentFiles(
        long futureTimestamp = DateUtils.toLong(Instant.now()) + TimeUnit.HOURS.toNanos(1);
        stringStoreFileMetadataMapOne.put("test-2", storeFileMetadata2);  
        final IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
            "",
        ReplicationCheckpoint secondReplicationCheckpoint = new ReplicationCheckpoint(
        );
        assertEquals(replicationCheckpoint, segmentReplicator.getPrimaryCheckpoint(shardId));
            200,
        indexOutput.writeLong(primaryCheckpoint.getPrimaryTerm());  
            stringStoreFileMetadataMapTwo,  
        StoreFileMetadata storeFileMetadata2 = new StoreFileMetadata("test-2", 500, "1", Version.LATEST, new BytesRef(500));
                resolveCheckpointListener(listener, primary);
        when(replicaShard.shardId()).thenReturn(shardId);
import org.opensearch.common.time.DateUtils;
        stringStoreFileMetadataMapTwo.put("test-3", storeFileMetadata3);
            "lag " + stats.maxReplicationLag + "ms exceeds time since receive " + elapsedSinceReceive + "ms",
            public void getCheckpointMetadata(
        }
            shardId,
        when(cs.state()).thenReturn(buildClusterState(replica, shardRoutingTable));  
        ShardId shardId = new ShardId("index", "uuid", 0);  
    public void testUpdateReplicationCheckpointStatsIgnoresWhenOutOfOrderCheckPointReceived() {
     * ({@code RemoteStoreReplicationSource#getCheckpointMetadata}). A metadata file written before
        assertEquals(500, stats.totalBytesBehind);
        ReplicationStats stats = segmentReplicator.getSegmentReplicationStats(shardId);
import org.opensearch.threadpool.ThreadPool;
            2,
        shardRoutingTable.addShard(primary.routingEntry().moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, "test")));  
import org.opensearch.cluster.ClusterState;  
        indexOutput.writeVInt(shardId.getId());
    }  
        when(factory.get(replica)).thenReturn(new TestReplicationSource() {  
        IndexShard replicaShard = mock(IndexShard.class);
    }  
                ActionListener<GetSegmentFilesResponse> listener
            .thenReturn(firstReplicationCheckpoint)
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
        );
        ReplicationCheckpoint legacyPrimaryCheckpoint = new ReplicationCheckpoint(shardId, 2, 2, 2, 500, "", metadataMap, 0L);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    }  
        Map<String, String> uploadedSegments = new HashMap<>();  
        ReplicationCheckpoint primaryCheckpoint = new ReplicationCheckpoint(shardId, 2, 2, 2, 500, "", metadataMap);  
            ) {  
                try {
        IndexShard replicaShard = mock(IndexShard.class);
        ReplicationCheckpoint thirdReplicationCheckpoint = new ReplicationCheckpoint(
        indexOutput.writeString(shardId.getIndex().getName());  
        assertEquals(1200, replicationStatsSecond.totalBytesBehind);  
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadataHandler;
        segmentReplicator.startReplication(replica);  
            @Override
import org.opensearch.core.index.shard.ShardId;
        long elapsedSinceReceive = System.currentTimeMillis() - beforeReceive;  
    }  
                long replicationId,
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(legacyPrimaryCheckpoint);
        segmentReplicator.startReplication(shard);
    /**
            shardId,
        replicator.setSourceFactory(new SegmentReplicationSourceFactory(mock(TransportService.class), mock(RecoverySettings.class), cs));  
            @Override
        expectThrows(IllegalStateException.class, () -> replicator.startReplication(replica));
        Map<String, StoreFileMetadata> metadataMap = new HashMap<>();
            200,  
        indexOutput.writeString(shardId.getIndex().getUUID());
import org.opensearch.common.io.stream.BytesStreamOutput;
        segmentReplicator.setSourceFactory(factory);
        ReplicationStats finalStats = segmentReplicator.getSegmentReplicationStats(shardId);  
    public void testGetSegmentReplicationStats_LagIsNeverNegative() {
            .routingTable(
            1000,  
        assertEquals(1200, replicationStatsFirst.maxBytesBehind);
        ShardId shardId = new ShardId("index", "uuid", 0);  
        Map<String, StoreFileMetadata> stringStoreFileMetadataMapTwo = new HashMap<>();  
            shardId,  
        assertEquals(200, replicationStatsSecond.totalBytesBehind);
        // index and copy segments to replica.
            shardId,
        assertEquals(0, finalStats.totalBytesBehind);
    public void testReplicationWithUnknownPrimaryNode() throws Exception {
            "",
        assertTrue(replicationStatsFirst.maxReplicationLag > 0);  
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("test-1", 500, "1", Version.LATEST, new BytesRef(500));  
    }
import java.time.Instant;  
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(localCheckpoint);  
        segmentReplicator.initializeStats(shardId);  
import org.opensearch.index.shard.IndexShardTestCase;
                try {
import java.util.Map;
        ReplicationCheckpoint thirdReplicationCheckpoint = new ReplicationCheckpoint(
        assertEquals(replicationCheckpoint, segmentReplicator.getPrimaryCheckpoint(shardId));
            "",
        assertTrue(replicationStatsSecond.maxReplicationLag > 0);
        SegmentReplicator replicator = new SegmentReplicator(threadPool);
        assertEquals(0L, legacyMetadataCheckpoint.getCreatedTimeStamp());
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
import org.opensearch.index.store.StoreFileMetadata;  
        ReplicationCheckpoint firstReplicationCheckpoint = ReplicationCheckpoint.empty(shardId);  
                    throw new RuntimeException(e);
        stringStoreFileMetadataMapTwo.put("test-1", storeFileMetadata1);
        long baseTime = DateUtils.toLong(Instant.now());
     */  
        segmentReplicator.updateReplicationCheckpointStats(secondReplicationCheckpoint, replicaShard);
        stringStoreFileMetadataMapOne.put("test-1", storeFileMetadata1);
        when(factory.get(replica)).thenReturn(new TestReplicationSource() {
            1,
     */
        when(replicaShard.getLatestReplicationCheckpoint()).thenReturn(localCheckpoint);  
        // assert shard failure on corruption
import java.util.concurrent.ExecutorService;
        long elapsedSinceReceive = System.currentTimeMillis() - beforeReceive;
        metadataMap.put("test-1", storeFileMetadata1);
            @Override
        shardRoutingTable.addShard(replica.routingEntry());
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
    public void testReplicationFails() throws Exception {
        ReplicationCheckpoint secondReplicationCheckpoint = new ReplicationCheckpoint(
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
import org.opensearch.indices.replication.common.ReplicationType;  
    }
        StoreFileMetadata storeFileMetadata2 = new StoreFileMetadata("test-2", 500, "1", Version.LATEST, new BytesRef(500));  
        AtomicBoolean failureCallbackTriggered = new AtomicBoolean(false);
        assertEquals(100, stats.totalBytesBehind);
        metadataMap.put("test-1", storeFileMetadata1);
        assertTrue(  
     * Remote-store replicas obtain the primary's checkpoint from the segment metadata file rather than over the wire  
        );
        // shard is up to date, should not have any tracked stats
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        // createdTimeStamp == 0, as produced by ReplicationCheckpoint(StreamInput) for a sender older than 3.0.0  
        expectThrows(IllegalStateException.class, () -> replicator.startReplication(replica));
        segmentReplicator.setSourceFactory(factory);
                ActionListener<CheckpointInfoResponse> listener  
        segmentReplicator.updateReplicationCheckpointStats(legacyMetadataCheckpoint, replicaShard);
        assertEquals(0, finalStats.totalBytesBehind);
        );  
        assertEquals(0, replicationStats.maxReplicationLag);
        segmentReplicator.initializeStats(shardId);
        indexOutput.writeLong(primaryCheckpoint.getSegmentInfosVersion());
                    indexShard.store().markStoreCorrupted(corruptIndexException);  
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            3,
     * checkpoint was received, not from the Unix epoch.  
        ReplicationStats replicationStatsSecond = segmentReplicator.getSegmentReplicationStats(shardId);
        ExecutorService mock = mock(ExecutorService.class);  
                ReplicationCheckpoint checkpoint,
        ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(shardId, 2, 2, 2, 100, "", metadataMap, futureTimestamp);
        closeShards(replica, primary);  
        when(replicaShard.shardId()).thenReturn(shardId);
        IndexShard shard = mock(IndexShard.class);
import org.opensearch.index.replication.TestReplicationSource;  
        long beforeReceive = System.currentTimeMillis();
            @Override
        when(replicaShard.shardId()).thenReturn(shardId);
            baseTime - 5_000_000  
import static org.mockito.Mockito.spy;
            ) {
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        segmentReplicator.updateReplicationCheckpointStats(replicationCheckpoint, replicaShard);  
            2,  
        SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
                ReplicationCheckpoint checkpoint,
            3,  
            stats.maxReplicationLag >= 0 && stats.maxReplicationLag <= elapsedSinceReceive + 1_000  
            "",
        );
            }
            2,
        // shard finished syncing to last checkpoint (sis 3)  
import org.opensearch.transport.TransportService;
 *
            1000,
                }  
        try (final CopyState copyState = new CopyState(primary)) {
import org.opensearch.index.shard.IndexShard;
            shardId,  
import org.apache.lucene.util.BytesRef;  
            1,
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        });
import org.apache.lucene.util.Version;
        ShardId shardId = new ShardId("index", "uuid", 0);
            }
                    Lucene.cleanLuceneIndex(indexShard.store().directory());  
import static org.mockito.Mockito.when;
        assertEquals(1200, replicationStatsFirst.maxBytesBehind);
        StoreFileMetadata storeFileMetadata1 = new StoreFileMetadata("_0.cfe", 500, "1", Version.LATEST, new BytesRef(500));  
            shardId,  
        ReplicationStats finalStats = segmentReplicator.getSegmentReplicationStats(shardId);  
        allowShardFailures();  
        when(replicaShard.shardId()).thenReturn(shardId);
