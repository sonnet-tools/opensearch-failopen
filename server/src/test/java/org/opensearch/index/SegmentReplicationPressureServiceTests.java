import org.opensearch.threadpool.ThreadPool;
                assertEquals(3, replicationStats.size());
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.metadata.IndexMetadata;
            assertTrue(service.getFailStaleReplicaTask().isScheduled());
            // index docs in batches without refreshing
            assertEquals(1, replicationStats.size());
            service.getFailStaleReplicaTask().runInternal();
}
            });
            indicesService,
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING;
import org.opensearch.index.engine.NRTReplicationEngineFactory;
    public void testIsSegrepLimitBreached_underStaleNodeLimit() throws Exception {
    private static final Settings settings = Settings.builder()
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
                assertTrue(shardStats.getCurrentReplicationTimeMillis() > TimeValue.timeValueSeconds(5).millis());
import org.opensearch.common.settings.Settings;
            assertFalse(service.getFailStaleReplicaTask().isScheduled());
 */
            service.isSegrepLimitBreached(primaryShard.shardId());
            assertTrue(service.getFailStaleReplicaTask().mustReschedule());
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
                SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            // call the background task
import java.util.List;
            assertEquals(5, shardStats.getCheckpointsBehindCount());
    }
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            assertBusy(() -> {
            service.isSegrepLimitBreached(primaryShard.shardId());
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
import static java.util.Arrays.asList;
            groupStats = shardStats.get(primaryShard.shardId());
            // verify that remote shard failed method is never called as it is disabled.
    public void testIsSegrepLimitBreached_onlyCheckpointLimitBreached() throws Exception {
            expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId()));
            final List<IndexShard> replicas = shards.getReplicas();
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(0))
            );
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    public void testIsSegrepLimitBreached() throws Exception {
            indexInBatches(1, shards, primaryShard);
        }
    public void testFailStaleReplicaTask() throws Exception {
            .build();
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(20))
            indexInBatches(5, shards, primaryShard);
            .build();
import static org.mockito.Mockito.times;
            shards.startAll();
        IndicesService indicesService = mock(IndicesService.class);
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
            shards.indexDocs(numDocs);
        when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
import java.util.Map;
import static org.mockito.Mockito.verify;
            replicateSegments(primaryShard, asList(replicas.get(0)));
            // index docs in batches without refreshing
            indexInBatches(5, shards, primaryShard);
                TimeUnit.SECONDS
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(10))
            assertTrue(service.getFailStaleReplicaTask().mustReschedule());
            settings,
            assertBusy(
        }
            });
            segmentReplicationStats = service.nodeStats();
        final Settings settings = Settings.builder()
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            final IndexShard primaryShard = shards.getPrimary();
        IndexService indexService = mock(IndexService.class);
            service.isSegrepLimitBreached(primaryShard.shardId());
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
        final Settings settings = Settings.builder()
            assertTrue(service.getFailStaleReplicaTask().isScheduled());
            );
                30,
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
        }
        final Settings settings = Settings.builder()
            final IndexShard primaryShard = shards.getPrimary();
            assertEquals(1, replicas.size());
            // update one replica. 2/3 stale.
import static org.mockito.Mockito.never;
        when(indexService.iterator()).thenAnswer((Answer<Iterator<IndexShard>>) invocation -> List.of(primaryShard).iterator());
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            SegmentReplicationStats segmentReplicationStats = service.nodeStats();
import org.opensearch.indices.replication.common.ReplicationType;
        return totalDocs;
        when(indexService.getShard(primaryShard.shardId().id())).thenReturn(primaryShard);
import org.mockito.Mockito;
            new SegmentReplicationStatsTracker(indicesService),
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            final SegmentReplicationStats segmentReplicationStats = service.nodeStats();
        for (int i = 0; i < count; i++) {
            final IndexShard primaryShard = shards.getPrimary();
            assertEquals(2, groupStats.getRejectedRequestCount());
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertEquals(1, replicas.size());
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(10))
                assertTrue(shardStats.getCurrentReplicationTimeMillis() > TimeValue.timeValueSeconds(5).millis());
        .put(MAX_INDEXING_CHECKPOINTS.getKey(), 4)
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            Set<SegmentReplicationShardStats> replicas = groupStats.getReplicaStats();
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
    }
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
            shards.startAll();
        final Settings settings = Settings.builder()
            shards.startAll();
            replicateSegments(primaryShard, shards.getReplicas());
            primaryShard.refresh("Test");
    }
import java.util.concurrent.TimeUnit;
            service.setReplicationTimeLimitFailReplica(TimeValue.ZERO);
            assertEquals(0, replicaStats.getCheckpointsBehindCount());
            assertEquals(1, shardStats.size());
import java.util.Iterator;
        return new SegmentReplicationPressureService(
            final SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            .build();
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(1))
            final IndexShard primaryShard = shards.getPrimary();
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            service.isSegrepLimitBreached(primaryShard.shardId());
                Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            totalDocs += numDocs;
            .build();
            clusterService,
            assertEquals(0, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());
            int numDocs = randomIntBetween(100, 200);
            final IndexShard primaryShard = shards.getPrimary();
            SegmentReplicationShardStats replicaStats = replicas.stream().findFirst().get();
            final SegmentReplicationStats segmentReplicationStats = service.nodeStats();
                assertEquals(1, replicationStats.size());
            shards.startAll();
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testFailStaleReplicaTaskToggleOnOff() throws Exception {
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
            // call the background task
        }
            service.isSegrepLimitBreached(primaryShard.shardId());
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
        .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueSeconds(5))
                Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            final IndexShard primaryShard = shards.getPrimary();
            Mockito.reset(shardStateAction);
        when(indicesService.indexService(primaryShard.shardId().getIndex())).thenReturn(indexService);
            indexInBatches(5, shards, primaryShard);
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.indices.IndicesService;
            replicas = groupStats.getReplicaStats();
import java.util.Set;
    private SegmentReplicationPressureService buildPressureService(Settings settings, IndexShard primaryShard) {
import org.opensearch.cluster.action.shard.ShardStateAction;
                () -> expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId())),
            assertTrue(service.getFailStaleReplicaTask().isScheduled());
            assertEquals(5, shardStats.getCheckpointsBehindCount());
            // let shard catch up
            assertEquals(1, replicationStats.size());
import static org.mockito.ArgumentMatchers.anyBoolean;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import static org.mockito.ArgumentMatchers.anyString;
        .build();
import org.opensearch.index.shard.IndexShard;
            Map<ShardId, SegmentReplicationPerGroupStats> shardStats = segmentReplicationStats.getShardStats();
import org.opensearch.cluster.service.ClusterService;
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            assertFalse(service.getFailStaleReplicaTask().mustReschedule());
        );
 *
            final IndexShard primaryShard = shards.getPrimary();
import org.opensearch.common.unit.TimeValue;
            replicateSegments(primaryShard, shards.getReplicas());
import static org.opensearch.index.SegmentReplicationPressureService.SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED;
        }
            replicateSegments(primaryShard, shards.getReplicas());
        try (ReplicationGroup shards = createGroup(3, settings, new NRTReplicationEngineFactory())) {
        final Settings settings = Settings.builder()
            segmentReplicationStats = service.nodeStats();
                TimeUnit.SECONDS
            verify(shardStateAction, times(1)).remoteShardFailed(any(), anyString(), anyLong(), anyBoolean(), anyString(), any(), any());
            shardStateAction,
            replicateSegments(primaryShard, shards.getReplicas());
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            assertBusy(() -> {
            // assert that replica shard is few checkpoints behind primary
            service.isSegrepLimitBreached(primaryShard.shardId());
    }
import org.mockito.stubbing.Answer;
package org.opensearch.index;
            indexInBatches(5, shards, primaryShard);
            service.isSegrepLimitBreached(primaryShard.shardId());
            assertEquals(0, groupStats.getRejectedRequestCount());
    private static ShardStateAction shardStateAction = Mockito.mock(ShardStateAction.class);
            verify(shardStateAction, never()).remoteShardFailed(any(), anyString(), anyLong(), anyBoolean(), anyString(), any(), any());
            expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId()));
        when(indicesService.iterator()).thenAnswer((Answer<Iterator<IndexService>>) invocation -> List.of(indexService).iterator());
            replicaStats = replicas.stream().findFirst().get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import static org.mockito.ArgumentMatchers.any;
            SegmentReplicationPerGroupStats groupStats = shardStats.get(primaryShard.shardId());
        int totalDocs = 0;
            indexInBatches(5, shards, primaryShard);
            // update second replica - 1/3 stale - should not throw.
import org.opensearch.common.settings.ClusterSettings;
            assertEquals(1, replicationStats.size());
            replicateSegments(primaryShard, shards.getReplicas());
            // verify that remote shard failed method is called which fails the replica shards falling behind.
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            shardStats = segmentReplicationStats.getShardStats();
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(10))
            .put(MAX_INDEXING_CHECKPOINTS.getKey(), 4)
        .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
 * compatible open source license.
            // index docs in batches without refreshing
            replicateSegments(primaryShard, shards.getReplicas());
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
            service.getFailStaleReplicaTask().runInternal();
import static org.mockito.Mockito.mock;
            shards.startAll();
    public void testFailStaleReplicaTaskDisabled() throws Exception {
                SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            shards.startAll();
            assertEquals(0, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_TIME_BACKPRESSURE_SETTING;
            assertBusy(
    public void testIsSegrepLimitBreached_onlyTimeLimitBreached() throws Exception {
            mock(ThreadPool.class)
            // catch up all.
            assertEquals(5, shardStats.getCheckpointsBehindCount());
            // assert that replica shard is few checkpoints behind primary
    }
            .build();
    }
            Set<SegmentReplicationShardStats> replicationStats = primaryShard.getReplicationStatsForTrackedReplicas();
            indexInBatches(5, shards, primaryShard);
            SegmentReplicationShardStats shardStats = replicationStats.stream().findFirst().get();
            assertEquals(2, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());
            // assert that replica shard is few checkpoints behind primary
            assertEquals(5, shardStats.getCheckpointsBehindCount());
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
            replicateSegments(primaryShard, asList(replicas.get(1)));
/*
            assertTrue(service.getFailStaleReplicaTask().mustReschedule());
            shards.startAll();
            assertEquals(1, segmentReplicationStats.getShardStats().get(primaryShard.shardId()).getRejectedRequestCount());
            service.setReplicationTimeLimitFailReplica(TimeValue.timeValueMillis(1));
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(1, shardStats.size());
        }
            assertEquals(1, replicationStats.size());
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
            SegmentReplicationPressureService service = buildPressureService(settings, primaryShard);
            replicateSegments(primaryShard, shards.getReplicas());
                () -> expectThrows(OpenSearchRejectedExecutionException.class, () -> service.isSegrepLimitBreached(primaryShard.shardId())),
            SegmentReplicationStats segmentReplicationStats = service.nodeStats();
public class SegmentReplicationPressureServiceTests extends OpenSearchIndexLevelReplicationTestCase {
    private int indexInBatches(int count, ReplicationGroup shards, IndexShard primaryShard) throws Exception {
                30,
        }
import static org.opensearch.index.SegmentReplicationPressureService.MAX_INDEXING_CHECKPOINTS;
            assertEquals(5, replicaStats.getCheckpointsBehindCount());
