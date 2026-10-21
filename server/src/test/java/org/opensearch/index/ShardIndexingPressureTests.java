                (long) (4 * 1024 / 0.85),
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(
 * The OpenSearch Contributors require contributions made to
        boolean randomBoolean = randomBoolean();
    }
        assertEquals(15, nodeStats.getTotalPrimaryBytes());
            Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 3 * 1024, false)
        if (randomBoolean) {
        } else {
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1);
            }
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
        expectThrows(
        Index index = new Index("IndexName", "UUID");
        if (randomBoolean) {
        Index index = new Index("IndexName", "UUID");
    }
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertEquals(1 * 1024, shardStats.getTotalCoordinatingBytes());
    public void testForceExecutionOnCoordinating() {
        assertEquals(0, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            );
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        assertEquals(1, nodeStats.getReplicaRejections());
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 3, false)
            );
        ShardId shardId2 = new ShardId(index, 1);
 */
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 3, false);
        Settings settings = Settings.builder()
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 4 * 1024, false)
                assertEquals(1024 * 6, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId2).getCurrentPrimaryAndCoordinatingLimits()
            assertEquals(10, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
    }
            // Replica will be rejected once we cross 15KB Shard Limit
                preLocalShardStats.getCurrentPrimaryBytes() + 1024 * 2,
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
        releasable = shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024);
        }
        assertEquals(10, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        assertEquals(1 * 1024, shardStats.getTotalReplicaBytes());
            assertEquals(
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
                OpenSearchRejectedExecutionException.class,
            try (
    }
import org.opensearch.common.settings.Settings;
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                8 * 1024,
import org.opensearch.test.OpenSearchTestCase;
        Settings settings = Settings.builder()
                OpenSearchRejectedExecutionException.class,
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            ) {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertEquals(
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
            assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());
            assertEquals(1, shardStats.getPrimaryLastSuccessfulRequestLimitsBreachedRejections());
            );
            assertEquals(1, shardStats.getPrimaryLastSuccessfulRequestLimitsBreachedRejections());
        Index index = new Index("IndexName", "UUID");
        try (
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertEquals(
            assertEquals(
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
        ) {
                Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false)
            IndexingPressurePerShardStats preLocalShardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
                Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 7 * 1024, false);
                expectThrows(
            assertEquals(0, shardStats.getCoordinatingRejections());
        }
            expectThrows(
        Settings settings = Settings.builder()
        assertEquals(8 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            OpenSearchRejectedExecutionException.class,
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            assertEquals(1024 * 12, nodeStats.getCurrentReplicaBytes());
            assertEquals(12 * 1024, shardStats.getTotalCoordinatingBytes());
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 8 * 1024, false);
            }
        try (
            assertEquals(1, nodeStats.getCoordinatingRejections());
            // Adding delay in the current in flight request to mimic throughput degradation
        assertEquals(1 * 1024, shardStats.getTotalReplicaBytes());
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        Index index = new Index("IndexName", "UUID");
        Thread.sleep(25);
        releasable.close();
        assertEquals(10, nodeStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        Releasable releasable = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024, false);
            long preForcedShardRejections = shardIndexingPressure.shardStats()
            assertEquals(1, shardStats.getReplicaRejections());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
                Releasable primary2 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false);
        Index index = new Index("IndexName", "UUID");
        }
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
    public void testReplicaShardLimitIncreaseEvaluateSecondaryParam() {
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes()
        assertEquals(0, nodeStats.getReplicaRejections());
        assertEquals(2 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
                    10,
 * compatible open source license.
        } else {
        ) {
        if (randomBoolean) {
        assertEquals(4 * 1024, shardStats.getTotalReplicaBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
                4 * 1024,
                4 * 1024,
        ) {
        ShardId shardId = new ShardId(index, 0);
                    shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        ShardId shardId = new ShardId(index, 0);
            );
            assertEquals(10, nodeStats.getCurrentCoordinatingBytes());
            );
            assertEquals(1, shardStats.getCoordinatingThroughputDegradationLimitsBreachedRejections());
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId, 8 * 1024, false)
            );
            );
        assertEquals(2 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
    public void testCoordinatingPrimaryShardRejectionViaSuccessfulRequestsParam() throws InterruptedException {
                assertEquals(1, shardStats.getPrimaryRejections());
            );
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
                preLocalShardStats.getPrimaryRejections(),
        Index index = new Index("IndexName", "UUID");
        try (
        ) {
        assertEquals(35, shardStats.getTotalReplicaBytes());
            );
        ShardId shardId = new ShardId(index, 0);
            assertEquals(
    public void testReplicaShardRejectionSkippedInShadowModeViaThroughputDegradationParam() throws InterruptedException {
                preForcedShardRejections,
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
    }
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        }
                IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
            );
            Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 4 * 1024, false);
            }
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        Thread.sleep(25);
                    shardIndexingPressure.shardStats()
        } else {
        );
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        releasable = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024, false);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        }
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId2);
            );
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
            }
            assertEquals(1024 * 6, shardIndexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());
        assertEquals(1, shardStats.getReplicaLastSuccessfulRequestLimitsBreachedRejections());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId2).getCurrentCombinedCoordinatingAndPrimaryBytes()
        ) {
        ShardId shardId = new ShardId(index, 0);
import org.opensearch.common.lease.Releasable;
                10,
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId2).getCurrentCoordinatingBytes()
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        if (randomBoolean) {
        IndexingPressurePerShardStats shardHotStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        String assertionMessage = "ShardIndexingPressure Release is called twice";
        assertEquals(0, shardStats.getCurrentReplicaBytes());
                    OpenSearchRejectedExecutionException.class,
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false);
            IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        assertEquals(20, nodeStats.getTotalPrimaryBytes());
            .build();
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            assertEquals(60, shardStats.getCurrentCoordinatingBytes());
                (long) (4 * 1024 / 0.85),
        }
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 14, false);
            );
    final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
        }
        assertEquals(0, nodeStats.getCurrentPrimaryBytes());
        assertEquals(15, shardStats.getCurrentReplicaLimits());
        ShardId shardId = new ShardId(index, 0);
            );
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
        ) {
            assertEquals(10, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false)) {
            );
                () -> shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false)
            );
                Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
            Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 3 * 1024, false)
        ) {
                );
        }
            );
            assertEquals(
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        } else {
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
                IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        assertEquals(1024 * 8, shardIndexingPressure.stats().getTotalCombinedCoordinatingAndPrimaryBytes());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        );
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
            assertEquals(
                coordinating1.close();
        );
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryRejections()
}
            assertEquals(preLocalNodeStats.getCurrentPrimaryBytes() + 1024 * 2, shardIndexingPressure.stats().getCurrentPrimaryBytes());
        Settings settings = Settings.builder()
                assertEquals(1, shardStats.getCoordinatingNodeLimitsBreachedRejections());
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
public class ShardIndexingPressureTests extends OpenSearchTestCase {
            Thread.sleep(100);
    public void testAssertionOnReleaseExecutedTwice() {
                    shardIndexingPressure.shardStats()
                assertEquals(
        } else {
                );
            // Local to coordinating node primary actions not rejected
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
            .build();
            // Replica will not be rejected until replica bytes > 15KB
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
            Releasable coordinating2 = shardIndexingPressure.markCoordinatingOperationStarted(shardId2, 4 * 1024, false);
            );
            // Primary can be forced
            Releasable coordinating2 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 50, false);
                (long) (1 * 1024 / 0.85),
        } else {
        }
        assertNull(shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId));
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            expectThrows(
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            assertEquals(1, shardStats.getPrimaryRejections());
        Index index = new Index("IndexName", "UUID");
                assertEquals(1, shardStats.getPrimaryNodeLimitsBreachedRejections());
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
 *
        } else {
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
            if (randomBoolean) {
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 25, true);
    }
            // Adding delay in the current in flight request to mimic throughput degradation
        ) {
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 3, false);
        ShardId shardId = new ShardId(index, 0);
            assertEquals(1, shardStats.getPrimaryRejections());
        ShardId shardId = new ShardId(index, 0);
                () -> shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 2, false)
        ) {
        assertEquals(4 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 10, false);
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
            assertEquals(
            }
    }
        ShardId shardId = new ShardId(index, 0);
        Thread.sleep(25);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
            assertEquals(
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
            assertEquals(1, shardStats.getCoordinatingLastSuccessfulRequestLimitsBreachedRejections());
        Index index = new Index("IndexName", "UUID");
        ShardId shardId = new ShardId(index, 0);
            OpenSearchRejectedExecutionException.class,
        }
    }
        // Total Bytes are 14*1024 and node limit is 15*1024
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
                1024 * 6,
            );
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(1, nodeStats.getPrimaryRejections());
        ShardId shardId = new ShardId(index, 0);
            assertEquals(35, nodeStats.getCurrentReplicaBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
            assertEquals(
            assertEquals(0, nodeStats.getPrimaryRejections());
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        ShardId shardId = new ShardId(index, 0);
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            );
        if (randomBoolean) {
            );
        try (
        assertEquals(1, shardStats.getReplicaLastSuccessfulRequestLimitsBreachedRejections());
        }
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        assertEquals(16 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
                2 * 1024,
                assertEquals(
            );
        assertEquals(80, nodeStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        ShardId shardId = new ShardId(index, 0);
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId, 12 * 1024, false)
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 3, false);
import org.opensearch.common.settings.ClusterSettings;
            expectThrows(
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        }
                (long) (4 * 1024 / 0.85),
        ) {
            Releasable forced = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 2, true);
            Thread.sleep(100);
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
                assertEquals(1, nodeStats.getCoordinatingRejections());
                Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 7 * 1024, false);
        assertEquals(1, shardStats.getReplicaRejections());
            assertEquals(8, shardStats.getTotalPrimaryBytes());
                2 * 1024,
        assertEquals(1 * 1024, shardStats.getTotalCoordinatingBytes());
            assertEquals(1, shardStats.getPrimaryThroughputDegradationLimitsBreachedRejections());
        assertEquals(15, shardStats.getCurrentReplicaLimits());
        }
        } else {
        assertEquals(80, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        if (randomBoolean) {
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        Index index = new Index("IndexName", "UUID");
        assertEquals(15, shardStats.getCurrentReplicaLimits());
        try (
            assertEquals(80, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                                                                                                                                   // Limit
                    () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false)
            );
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        Index index = new Index("IndexName", "UUID");
                OpenSearchRejectedExecutionException.class,
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 15, true);
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 8 * 1024, false)
                );
        assertEquals(16, shardStats.getTotalReplicaBytes());
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false)
            assertEquals(
            );
                    () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 2, false)
            assertEquals(0, nodeStats.getCoordinatingRejections());
        Settings settings = Settings.builder()
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        } else {
    public void testCoordinatingPrimaryShardRejectionSkippedInShadowModeViaSuccessfulRequestsParam() throws InterruptedException {
        Settings settings = Settings.builder()
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
                        .getCurrentCombinedCoordinatingAndPrimaryBytes()
            assertEquals(
    }
                8 * 1024,
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 3 * 1024, false);
            assertEquals(20, nodeStats.getCurrentPrimaryBytes());
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 11 * 1024, false)) {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 2, false);
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
        Thread.sleep(25);
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
        Index index = new Index("IndexName", "UUID");
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        if (randomBoolean) {
        assertEquals(60, nodeStats.getTotalCoordinatingBytes());
import org.opensearch.core.index.Index;
            1024 * 8,
        assertNull(shardStoreStats);
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 10 * 1024, false);
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                    10,
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            ) {
                preLocalShardStats.getPrimaryNodeLimitsBreachedRejections(),
    }
    final ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
            );
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        ShardId shardId = new ShardId(index, 0);
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
        ShardId shardId1 = new ShardId(index, 0);
        try (
            // Replica can be forced
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
/*
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        try (
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false);
        Index index = new Index("IndexName", "UUID");
        expectThrows(AssertionError.class, assertionMessage, releasable::close);
        assertEquals(10, nodeStats.getTotalCoordinatingBytes());
            forced.close();
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        replica.close();
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
    public void testReplicaShardRejectionSkippedInShadowModeViaSuccessfulRequestsParam() throws InterruptedException {
                Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 6, false);
            assertEquals(80, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertEquals(1, shardStats.getReplicaThroughputDegradationLimitsBreachedRejections());
        assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
            assertEquals(2, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
                (long) (2 * 1024 / 0.85),
        Settings settings = Settings.builder()
                assertEquals(8, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        ShardId shardId = new ShardId(index, 0);
        }
            assertEquals(11 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
                assertEquals(
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
    public void testReplicaShardLimitIncrease() {
        ) {
        try (
                primary1.close();
                assertEquals(1024 * 6, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        boolean randomBoolean = randomBoolean();
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
                (long) (1 * 1024 / 0.85),
    }
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
                    OpenSearchRejectedExecutionException.class,
            ); // Base Limit
        assertEquals(0, shardStats.getReplicaRejections());
        }
        expectThrows(AssertionError.class, assertionMessage, releasable::close);
            );
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
                );
                4 * 1024,
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
    }
            assertEquals(15, shardStats.getCurrentPrimaryBytes());
        assertEquals(11 * 1024, shardStats.getTotalReplicaBytes());
            Releasable primary = shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 15)
            assertEquals(
package org.opensearch.index;
            Releasable replica2 = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 9, false);
            Thread.sleep(100);
            );
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
            assertEquals(2, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
            assertEquals(
        if (randomBoolean) {
            assertEquals(
            assertEquals(
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
        assertEquals(1, shardStats.getReplicaThroughputDegradationLimitsBreachedRejections());
        }
        assertEquals(15, shardStats.getCurrentReplicaLimits());
        releasable.close();
        assertNull(shardStoreStats);
        boolean randomBoolean = randomBoolean();
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false);
                ); // Increased Limit
        Index index = new Index("IndexName", "UUID");
                (long) (4 * 1024 / 0.85),
                    11,
    }
            Releasable replica2 = shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false);
            IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            assertEquals(1024 * 14, shardIndexingPressure.stats().getCurrentReplicaBytes());
        assertNull(shardStoreStats);
                (long) (2 * 1024 / 0.85),
            forced.close();
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
            assertEquals(20, shardStats.getCurrentPrimaryBytes());
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
                        .getCurrentCombinedCoordinatingAndPrimaryBytes()
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false)) {
                    shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        ShardId shardId = new ShardId(index, 0);
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 3 * 1024, false)
        }
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        }
            replica1.close();
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
                preForcedShardRejections,
            primary.close();
            replica2.close();
        try (
                OpenSearchRejectedExecutionException.class,
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                ); // Increased Limit
            assertEquals(1, nodeStats.getCoordinatingRejections());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            );
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
            assertEquals(1024 * 8, shardIndexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(1, shardStats.getPrimaryThroughputDegradationLimitsBreachedRejections());
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
    }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
            coordinating.close();
                (long) (8 * 1024 / 0.85),
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
                assertEquals(1024 * 6, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        assertEquals(4 * 1024, shardStats.getTotalPrimaryBytes());
            assertEquals(
        }
            assertEquals(1, shardStats.getCoordinatingLastSuccessfulRequestLimitsBreachedRejections());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            try (
            assertEquals(0, shardStats.getCoordinatingRejections());
                    OpenSearchRejectedExecutionException.class,
        } else {
            long preForceRejections = shardIndexingPressure.stats().getPrimaryRejections();
        }
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            );
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 2, false)) {
                    OpenSearchRejectedExecutionException.class,
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
        assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryNodeLimitsBreachedRejections()
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
        if (randomBoolean) {
            assertEquals(60, nodeStats.getCurrentCoordinatingBytes());
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
    public void testCoordinatingPrimaryShardLimitIncreaseEvaluateSecondaryParam() {
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
        assertEquals(15, shardStats.getCurrentReplicaLimits());
            assertEquals(
            try (
            assertEquals(15, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()); // Base
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
        Index index = new Index("IndexName", "UUID");
        assertEquals(10, shardStats.getTotalCoordinatingBytes());
                assertEquals(1024 * 6, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .build();
        assertEquals(1 * 1024, shardStats.getTotalPrimaryBytes());
                11 * 1024,
        }
            .build();
        assertNull(shardStoreStats);
    }
        if (randomBoolean) {
            local.close();
        expectThrows(AssertionError.class, assertionMessage, releasable::close);
            assertEquals(15, nodeStats.getCurrentPrimaryBytes());
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false)
            assertEquals(12 * 1024, shardStats.getTotalPrimaryBytes());
        Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 12 * 1024, false);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
            .build();
        assertEquals(0, shardStats.getCurrentReplicaBytes());
                Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false)
        assertEquals(8 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
                primary2.close();
            IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            if (randomBoolean()) {
        boolean randomBoolean = randomBoolean();
        assertNull(shardStoreStats);
        ShardId shardId = new ShardId(index, 0);
        releasable.close();
        }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
import org.opensearch.index.stats.IndexingPressureStats;
            );
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
    public void testReplicaShardRejectionViaThroughputDegradationParam() throws InterruptedException {
                1024 * 8,
    private final Settings settings = Settings.builder()
                        .getIndexingPressureShardStats(shardId)
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        assertEquals(0, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 11, false)
        // Total Bytes are 14*1024 and node limit is 15*1024
            assertEquals(1, shardStats.getCoordinatingRejections());
            IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        boolean randomBoolean = randomBoolean();
            assertEquals(
            .build();
                8 * 1024,
            assertEquals(
                .getPrimaryRejections();
        assertEquals(0, shardStats.getCurrentReplicaBytes());
                expectThrows(
            assertEquals(1, shardStats.getReplicaNodeLimitsBreachedRejections());
        ShardId shardId = new ShardId(index, 0);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryRejections()
        assertEquals(1, nodeStats.getReplicaRejections());
        assertEquals(1, shardStats.getReplicaRejections());
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
                Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
import org.opensearch.core.index.shard.ShardId;
        assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
            IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
            assertEquals(1, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getReplicaRejections());
        // Total Bytes are 9*1024 and node limit is 10*1024
        }
            assertEquals(1, shardStats.getCoordinatingRejections());
            );
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes()
    public void testCoordinatingPrimaryRejections() {
                Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 7 * 1024, false);
        assertEquals(20, shardStats.getTotalPrimaryBytes());
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
                IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            assertEquals(
        if (randomBoolean) {
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            expectThrows(
        } else {
        try (
    public void testAvoidDoubleAccounting() {
        assertEquals(16 * 1024, shardStats.getTotalReplicaBytes());
import org.opensearch.cluster.service.ClusterService;
            ) {
            assertEquals(1, nodeStats.getReplicaRejections());
                (long) (8 * 1024 / 0.85),
                );
                    () -> shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 2, false)
        assertEquals(
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            Releasable local = shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024 * 2);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
            assertEquals(
            assertEquals(1024 * 12, shardStats.getCurrentReplicaBytes());
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId).getTotalCombinedCoordinatingAndPrimaryBytes()
                .getIndexingPressureShardStats(shardId)
            assertEquals(0, shardStats.getPrimaryRejections());
        ShardId shardId = new ShardId(index, 0);
            } else {
    public void testShardLimitIncreaseMultipleShards() {
            assertEquals(
                Releasable coordinating2 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
            }
        try (
        try (
        assertEquals(1024 * 14, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId).getTotalReplicaBytes());
        ) {
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
    }
        assertNull(shardHotStoreStats);
        assertEquals(4 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false);
            );
            );
        assertEquals(0, nodeStats.getReplicaRejections());
        }
            assertEquals(18, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()); // Increased
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
            assertEquals(8, shardStats.getTotalCoordinatingBytes());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 3, false)
        }
            assertEquals(35, shardStats.getCurrentReplicaBytes());
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 10 * 1024, false);
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
            // Adding delay in the current in flight request to mimic throughput degradation
import org.opensearch.test.ClusterServiceUtils;
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            Releasable primary2 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 5, false);
                expectThrows(
        releasable.close();
            assertEquals(0, shardStats.getPrimaryRejections());
            assertEquals(
                expectThrows(
        try (
        assertEquals(15, shardStats.getTotalPrimaryBytes());
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
        assertEquals(0, shardStats.getReplicaRejections());
            .build();
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            assertEquals(
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
            assertEquals(
            assertEquals(10, shardStats.getCurrentCoordinatingBytes());
                IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
    public void testCoordinatingPrimaryShardRejectionViaThroughputDegradationParam() throws InterruptedException {
        assertNull(shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId));
        releasable = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024, false);
        Index index = new Index("IndexName", "UUID");
        }
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        if (randomBoolean) {
                (long) (8 * 1024 / 0.85),
        } else {
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        ) {
        }
                coordinating2.close();
        // Total Bytes are 9*1024 and node limit is 10*1024
                                                                                                                                   // Limit
        expectThrows(AssertionError.class, assertionMessage, releasable::close);
            assertEquals(1, nodeStats.getPrimaryRejections());
            assertEquals(16, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        assertEquals(1 * 1024, shardStats.getTotalPrimaryBytes());
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(60, shardStats.getTotalCoordinatingBytes());
            assertEquals(
        Index index = new Index("IndexName", "UUID");
        assertEquals(10, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
    }
                assertEquals(
    public void testCoordinatingPrimaryShardRejectionSkippedInShadowModeViaThroughputDegradationParam() throws InterruptedException {
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
        }
        Index index = new Index("IndexName", "UUID");
        }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
            );
                    () -> shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
            assertEquals(1024 * 12, shardIndexingPressure.stats().getCurrentReplicaBytes());
            replica2.close();
            Thread.sleep(100);
            assertEquals(1, shardStats.getCoordinatingThroughputDegradationLimitsBreachedRejections());
        .build();
import org.opensearch.index.stats.IndexingPressurePerShardStats;
            assertEquals(preLocalNodeStats.getPrimaryRejections(), shardIndexingPressure.stats().getPrimaryRejections());
        ) {
                4,
    public void testMemoryBytesMarkedAndReleased() {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertEquals(1024 * 12, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
        Index index = new Index("IndexName", "UUID");
        assertEquals(15, shardStats.getCurrentReplicaLimits());
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
                    11,
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
            assertEquals(4 * 1024, shardStats.getTotalPrimaryBytes());
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
        try (
        }
                (long) (11 * 1024 / 0.85),
        }
            assertEquals(1024 * 14, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        if (randomBoolean) {
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
    public void testReplicaShardRejectionViaSuccessfulRequestsParam() throws InterruptedException {
        assertEquals(0, nodeStats.getCurrentPrimaryBytes());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes()
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
        assertEquals(35, nodeStats.getTotalReplicaBytes());
            assertEquals(1, shardStats.getReplicaNodeLimitsBreachedRejections());
        expectThrows(
            assertEquals(0, nodeStats.getCoordinatingRejections());
            assertEquals(
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
            // Adding delay in the current in flight request to mimic throughput degradation
        }
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertEquals(1024 * 14, shardIndexingPressure.stats().getTotalReplicaBytes());
                4 * 1024,
            assertEquals(0, nodeStats.getPrimaryRejections());
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
            try (
    }
    }
                );
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
            assertEquals(
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 4 * 1024, false);
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
                        .getIndexingPressureShardStats(shardId)
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());
        ) {
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 8 * 1024, false);
        Index index = new Index("IndexName", "UUID");
            Releasable replica2 = shardIndexingPressure.markReplicaOperationStarted(shardId, 10, false)
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
    public void testReplicaRejections() {
                assertEquals(1, nodeStats.getPrimaryRejections());
                assertEquals(1, shardStats.getCoordinatingRejections());
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
            IndexingPressureStats preLocalNodeStats = shardIndexingPressure.stats();
            .build();
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryNodeLimitsBreachedRejections()
        try (Releasable ignore = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 11 * 1024, true)) {
                Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 7 * 1024, false);
                Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 6, false);
        try (
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            } else {
    public void testCoordinatingPrimaryShardLimitIncrease() {
            assertEquals(preForceRejections, shardIndexingPressure.stats().getPrimaryRejections());
            Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 3 * 1024, false);
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 2, false)
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
                assertEquals(8, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
            assertEquals(1, shardIndexingPressure.stats().getReplicaRejections());
        } else {
            ) {
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 3 * 1024, false)
        Settings settings = Settings.builder()
            assertEquals(
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 3, false);
            Releasable forced = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 2, true);
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 10, false);
            );
