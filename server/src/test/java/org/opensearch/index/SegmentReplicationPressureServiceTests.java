            segmentReplicationStats = service.nodeStats();
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);  
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {  
            assertTrue(service.getFailStaleReplicaTask().mustReschedule());  
            mock(ThreadPool.class)
                () -> expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId())),
            .build();
            SegmentReplicationStats segmentReplicationStats = service.nodeStats();
            indexInBatches(5, shards, primaryShard);
            final IndexShard primaryShard = shards.getPrimary();
                30,  
import org.mockito.Mockito;
            final List<IndexShard> replicas = shards.getReplicas();  
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();  
import org.opensearch.indices.IndicesService;  
        }  
    private int indexInBatches(int count, ReplicationGroup shards, IndexShard primaryShard) throws Exception {
            service.getFailStaleReplicaTask().runInternal();
            shardStats = segmentReplicationStats.getShardStats();
        .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueSeconds(5))
            final SegmentReplicationStats segmentReplicationStats = service.nodeStats();
            indexInBatches(5, shards, primaryShard);
        return totalDocs;
    public void testIsSegrepLimitBreached_onlyTimeLimitBreached() throws Exception {  
        when(indexService.getShard(primaryShard.shardId().id())).thenReturn(primaryShard);
        .build();  
import static org.mockito.ArgumentMatchers.anyLong;
    }
            indicesService,
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;  
            assertEquals(1, shardStats.size());  
            assertEquals(1, replicationStats.size());
            shards.startAll();
            SegmentReplicationStats segmentReplicationStats = service.nodeStats();
            assertEquals(2, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());  
            Mockito.reset(shardStateAction);
            service.isSegrepLimitBreached(primaryShard.shardId());
        when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
            indexInBatches(1, shards, primaryShard);
            groupStats = shardStats.get(primaryShard.shardId());
import java.util.Map;  
                () -> expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId())),  
            assertEquals(1, replicas.size());
            );
        }  
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {  
    }
            service.isSegrepLimitBreached(primaryShard.shardId());
            assertEquals(0, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());  
            int numDocs = randomIntBetween(100, 200);
import static java.util.Arrays.asList;
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(0))  
    public void testFailStaleReplicaTaskDisabled() throws Exception {
            replicateSegments(primaryShard, shards.getReplicas());  
        when(indexService.iterator()).thenAnswer((Answer<Iterator<IndexShard>>) invocation -> List.of(primaryShard).iterator());
        int totalDocs = 0;  
            replicas = groupStats.getReplicaStats();  
            // assert that replica shard is few checkpoints behind primary
import org.opensearch.common.settings.Settings;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
                TimeUnit.SECONDS
            // update second replica - 1/3 stale - should not throw.
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)  
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {  
            // catch up all.  
            verify(shardStateAction, never()).remoteShardFailed(any(), anyString(), anyLong(), anyBoolean(), anyString(), any(), any());
            final SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);  
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            assertBusy(() -> {
            assertTrue(service.getFailStaleReplicaTask().mustReschedule());
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(10))
            .build();
            replicateSegments(primaryShard, shards.getReplicas());  
            assertEquals(1, replicationStats.size());  
        try (ReplicationGroup shards = createGroup(3, settings, new NRTReplicationEngineFactory())) {
            shards.startAll();
        }  
            // verify that remote shard failed method is never called as it is disabled.  
            // index docs in batches without refreshing
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {  
            assertTrue(service.getFailStaleReplicaTask().isScheduled());
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();  
            .build();  
import org.opensearch.cluster.service.ClusterService;  
import static org.opensearch.index.SegmentReplicationPressureService.MAX_INDEXING_CHECKPOINTS;
import static org.mockito.ArgumentMatchers.anyBoolean;
                Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();  
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING;  
            assertEquals(1, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());  
            assertEquals(5, replicaStats.getCheckpointsBehindCount());  
            assertEquals(5, shardStats.getCheckpointsBehindCount());  
            .build();
            replicaStats = replicas.stream().findFirst().get();
            replicateSegments(primaryShard, shards.getReplicas());
        IndexService indexService = mock(IndexService.class);  
    }
            indexInBatches(5, shards, primaryShard);
            replicateSegments(primaryShard, shards.getReplicas());
import org.opensearch.common.settings.ClusterSettings;
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(1))
            service.setReplicationTimeLimitFailReplica(TimeValue.ZERO);
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
        }
            assertTrue(service.getFailStaleReplicaTask().isScheduled());
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            shards.startAll();
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(20))
    public void testIsSegrepLimitBreached_underStaleNodeLimit() throws Exception {
                SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            assertBusy(
            assertEquals(1, replicas.size());
        final Settings settings = Settings.builder()
            primaryShard.refresh("Test");
            SegmentReplicationPerGroupStats groupStats = shardStats.get(primaryShard.shardId());
            // assert that replica shard is few checkpoints behind primary  
import static org.mockito.Mockito.never;
        .put(MAX_INDEXING_CHECKPOINTS.getKey(), 4)
            replicateSegments(primaryShard, asList(replicas.get(1)));  
import org.opensearch.indices.replication.common.ReplicationType;
            shards.startAll();  
import org.opensearch.threadpool.ThreadPool;
 * The OpenSearch Contributors require contributions made to  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }
    }
            settings,  
        );  
import static org.mockito.Mockito.mock;
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
            service.isSegrepLimitBreached(primaryShard.shardId());
            // index docs in batches without refreshing
                SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
    public void testIsSegrepLimitBreached() throws Exception {
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);  
        final Settings settings = Settings.builder()
            final IndexShard primaryShard = shards.getPrimary();
    public void testIsSegrepLimitBreached_onlyCheckpointLimitBreached() throws Exception {  
        .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            // call the background task
import org.mockito.stubbing.Answer;
import org.opensearch.cluster.action.shard.ShardStateAction;
import static org.mockito.ArgumentMatchers.any;  
            indexInBatches(5, shards, primaryShard);
            new SegmentReplicationStatsTracker(indicesService),
    public void testFailStaleReplicaTaskToggleOnOff() throws Exception {  
            // let shard catch up
    public void testFailStaleReplicaTask() throws Exception {  
            verify(shardStateAction, times(1)).remoteShardFailed(any(), anyString(), anyLong(), anyBoolean(), anyString(), any(), any());
            segmentReplicationStats = service.nodeStats();
                assertEquals(1, replicationStats.size());  
            });  
            expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId()));  
        when(indicesService.indexService(primaryShard.shardId().getIndex())).thenReturn(indexService);  
            assertEquals(5, shardStats.getCheckpointsBehindCount());
            .build();
            final SegmentReplicationStats segmentReplicationStats = service.nodeStats();
            assertEquals(2, groupStats.getRejectedRequestCount());
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            service.isSegrepLimitBreached(primaryShard.shardId());
import static org.opensearch.index.SegmentReplicationPressureService.SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED;
            service.isSegrepLimitBreached(primaryShard.shardId());  
            assertEquals(0, groupStats.getRejectedRequestCount());
    }  
                TimeUnit.SECONDS
            assertFalse(service.getFailStaleReplicaTask().mustReschedule());  
            assertTrue(service.getFailStaleReplicaTask().isScheduled());
                assertTrue(shardStats.getCurrentReplicationTimeMillis() > TimeValue.timeValueSeconds(5).millis());  
            SegmentReplicationShardStats replicaStats = replicas.stream().findFirst().get();
        when(indicesService.iterator()).thenAnswer((Answer<Iterator<IndexService>>) invocation -> List.of(indexService).iterator());
import static org.mockito.Mockito.verify;
            service.isSegrepLimitBreached(primaryShard.shardId());
            assertBusy(
            clusterService,
            totalDocs += numDocs;  
        final Settings settings = Settings.builder()
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
            shards.startAll();  
            assertEquals(5, shardStats.getCheckpointsBehindCount());
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
            shards.startAll();
            // update one replica. 2/3 stale.
                30,
import org.opensearch.common.unit.TimeValue;  
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId()));  
            indexInBatches(5, shards, primaryShard);
            assertEquals(1, shardStats.size());  
import org.opensearch.core.index.shard.ShardId;
}
    private SegmentReplicationPressureService buildPressureService(Settings settings, IndexShard primaryShard) {
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);  
            assertEquals(0, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            assertEquals(1, replicationStats.size());
import java.util.Set;
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            replicateSegments(primaryShard, shards.getReplicas());  
public class SegmentReplicationPressureServiceTests extends OpenSearchIndexLevelReplicationTestCase {
            );  
 */  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            shardStateAction,  
            assertEquals(1, replicationStats.size());
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);  
            indexInBatches(5, shards, primaryShard);  
 * SPDX-License-Identifier: Apache-2.0
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);  
        final Settings settings = Settings.builder()
import org.opensearch.index.shard.IndexShard;
            // assert that replica shard is few checkpoints behind primary
        }
        final Settings settings = Settings.builder()
import static org.mockito.ArgumentMatchers.anyString;  
/*  
            replicateSegments(primaryShard, shards.getReplicas());
    private static ShardStateAction shardStateAction = Mockito.mock(ShardStateAction.class);  
            service.isSegrepLimitBreached(primaryShard.shardId());  
        for (int i = 0; i < count; i++) {
        }  
        }
            shards.indexDocs(numDocs);
            service.setReplicationTimeLimitFailReplica(TimeValue.timeValueMillis(1));
 *
            replicateSegments(primaryShard, shards.getReplicas());
 * this file be licensed under the Apache-2.0 license or a
            final IndexShard primaryShard = shards.getPrimary();
import java.util.List;
    }
            assertFalse(service.getFailStaleReplicaTask().isScheduled());
        IndicesService indicesService = mock(IndicesService.class);
                assertTrue(shardStats.getCurrentReplicationTimeMillis() > TimeValue.timeValueSeconds(5).millis());
            });
            shards.startAll();
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {  
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
    private static final Settings settings = Settings.builder()
            assertEquals(0, replicaStats.getCheckpointsBehindCount());  
            final IndexShard primaryShard = shards.getPrimary();
            final IndexShard primaryShard = shards.getPrimary();
            // verify that remote shard failed method is called which fails the replica shards falling behind.
import org.opensearch.cluster.metadata.IndexMetadata;
            final IndexShard primaryShard = shards.getPrimary();
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)  
                assertEquals(3, replicationStats.size());
            // index docs in batches without refreshing  
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(10))
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            .put(MAX_INDEXING_CHECKPOINTS.getKey(), 4)  
            service.getFailStaleReplicaTask().runInternal();
        ClusterService clusterService = mock(ClusterService.class);
    }
 * compatible open source license.
            Set<SegmentReplicationShardStats> replicas = groupStats.getReplicaStats();  
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(10))
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_TIME_BACKPRESSURE_SETTING;
            final IndexShard primaryShard = shards.getPrimary();
            assertTrue(service.getFailStaleReplicaTask().mustReschedule());  
            assertEquals(5, shardStats.getCheckpointsBehindCount());
        return new SegmentReplicationPressureService(
            assertBusy(() -> {
            replicateSegments(primaryShard, asList(replicas.get(0)));
import java.util.Iterator;
            // call the background task  
package org.opensearch.index;
import java.util.concurrent.TimeUnit;
        }  
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();  
                Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            Map<ShardId, SegmentReplicationPerGroupStats> shardStats = segmentReplicationStats.getShardStats();
