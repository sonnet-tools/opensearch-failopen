            long preForcedShardRejections = shardIndexingPressure.shardStats()  
                2 * 1024,
            assertEquals(1, nodeStats.getPrimaryRejections());
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 3, false);
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
public class ShardIndexingPressureTests extends OpenSearchTestCase {
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        assertEquals(16 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
    }
        assertEquals(60, nodeStats.getTotalCoordinatingBytes());
        assertEquals(15, shardStats.getCurrentReplicaLimits());  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            assertEquals(4 * 1024, shardStats.getTotalPrimaryBytes());
                4 * 1024,  
        Index index = new Index("IndexName", "UUID");
        assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());  
        Settings settings = Settings.builder()
            assertEquals(15, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()); // Base
        expectThrows(AssertionError.class, assertionMessage, releasable::close);  
                    () -> shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
    public void testCoordinatingPrimaryShardLimitIncrease() {  
                (long) (8 * 1024 / 0.85),  
                        .getIndexingPressureShardStats(shardId)
        Thread.sleep(25);  
        if (randomBoolean) {
        Thread.sleep(25);
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
import org.opensearch.index.stats.IndexingPressureStats;  
        } else {
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            .build();
    public void testReplicaShardLimitIncrease() {
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
            // Replica will not be rejected until replica bytes > 15KB  
                assertEquals(
        assertEquals(16, shardStats.getTotalReplicaBytes());
            Releasable local = shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024 * 2);
        // Total Bytes are 9*1024 and node limit is 10*1024
        assertEquals(1 * 1024, shardStats.getTotalCoordinatingBytes());  
            assertEquals(10, nodeStats.getCurrentCoordinatingBytes());  
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();  
            );
        Thread.sleep(25);  
        if (randomBoolean) {  
            assertEquals(
            assertEquals(
        assertEquals(4 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
    }  
        assertNull(shardStoreStats);  
        boolean randomBoolean = randomBoolean();
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
package org.opensearch.index;
            );
        assertNull(shardStoreStats);
        if (randomBoolean) {  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryRejections()
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        releasable.close();
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            ) {
            Thread.sleep(100);
            forced.close();
            assertEquals(60, shardStats.getCurrentCoordinatingBytes());  
            );  
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertNull(shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId));
                    11,  
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());  
    public void testReplicaShardLimitIncreaseEvaluateSecondaryParam() {  
            assertEquals(1024 * 12, shardIndexingPressure.stats().getCurrentReplicaBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());  
            );
                    shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        ShardId shardId = new ShardId(index, 0);
    final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()  
                );  
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);  
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());  
        assertEquals(8 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());  
            assertEquals(1, shardStats.getCoordinatingRejections());  
        } else {  
                (long) (11 * 1024 / 0.85),
        boolean randomBoolean = randomBoolean();
            assertEquals(8, shardStats.getTotalCoordinatingBytes());
        boolean randomBoolean = randomBoolean();
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
            assertEquals(0, shardStats.getPrimaryRejections());  
        assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()  
        } else {  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryRejections()
        assertEquals(1 * 1024, shardStats.getTotalCoordinatingBytes());
 * SPDX-License-Identifier: Apache-2.0
                coordinating2.close();
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertEquals(0, nodeStats.getCurrentPrimaryBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
        ShardId shardId = new ShardId(index, 0);  
            assertEquals(
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        } else {  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            ) {
        Index index = new Index("IndexName", "UUID");
            local.close();
        assertEquals(0, shardStats.getReplicaRejections());  
            );  
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false)) {
                primary2.close();  
        } else {
                (long) (8 * 1024 / 0.85),  
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
 */  
            );
                Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false)
            replica2.close();
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 14, false);
                assertEquals(1024 * 6, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());  
        assertEquals(0, shardStats.getReplicaRejections());
            assertEquals(
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
            .build();
            assertEquals(18, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()); // Increased
import org.opensearch.common.settings.ClusterSettings;  
                (long) (4 * 1024 / 0.85),
        assertEquals(2 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
                (long) (1 * 1024 / 0.85),
            assertEquals(1, nodeStats.getCoordinatingRejections());
        }
                    11,
        ShardId shardId2 = new ShardId(index, 1);  
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
        assertEquals(10, nodeStats.getTotalCombinedCoordinatingAndPrimaryBytes());  
                OpenSearchRejectedExecutionException.class,
        assertNull(shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId));
        // Total Bytes are 14*1024 and node limit is 15*1024
                                                                                                                                   // Limit
            assertEquals(0, nodeStats.getCoordinatingRejections());  
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false)
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        }
        assertEquals(4 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
 * this file be licensed under the Apache-2.0 license or a
        ) {
        assertEquals(1, shardStats.getReplicaThroughputDegradationLimitsBreachedRejections());
                Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 7 * 1024, false);
 * compatible open source license.
        try (
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
    }
            );  
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
    final ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);  
        assertEquals(4 * 1024, shardStats.getTotalReplicaBytes());  
                .getIndexingPressureShardStats(shardId)
        }  
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
        }
            );
        boolean randomBoolean = randomBoolean();
        releasable.close();  
                Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 7 * 1024, false);
            assertEquals(  
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
            assertEquals(
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId, 8 * 1024, false)
        assertEquals(0, shardStats.getCurrentPrimaryBytes());  
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            assertEquals(80, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            Thread.sleep(100);
                OpenSearchRejectedExecutionException.class,
                Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)  
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId2).getCurrentCoordinatingBytes()
            }
            assertEquals(
                        .getCurrentCombinedCoordinatingAndPrimaryBytes()  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
/*  
                assertEquals(8, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        Thread.sleep(25);
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);  
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 10 * 1024, false);  
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            assertEquals(15, nodeStats.getCurrentPrimaryBytes());
        }  
        try (
            assertEquals(12 * 1024, shardStats.getTotalCoordinatingBytes());
            assertEquals(
        }
            assertEquals(1, shardStats.getCoordinatingRejections());
            assertEquals(16, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());  
        ShardId shardId = new ShardId(index, 0);
                OpenSearchRejectedExecutionException.class,  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(1 * 1024, shardStats.getTotalReplicaBytes());  
            Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 4 * 1024, false);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        Index index = new Index("IndexName", "UUID");
                );
            .build();  
        ShardId shardId = new ShardId(index, 0);
        assertEquals(0, shardStats.getCurrentPrimaryBytes());  
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 15, true);  
                Releasable primary2 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false);
        Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 12 * 1024, false);
        // Total Bytes are 14*1024 and node limit is 15*1024
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());  
            );
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)  
            assertEquals(20, shardStats.getCurrentPrimaryBytes());
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
        assertEquals(1, nodeStats.getReplicaRejections());  
    }  
    public void testAvoidDoubleAccounting() {  
        ) {
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)  
        assertEquals(0, shardStats.getCurrentPrimaryBytes());  
        ) {
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
                IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        ) {
            }
            .build();  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
                Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 6, false);
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
    public void testReplicaShardRejectionViaThroughputDegradationParam() throws InterruptedException {  
            ) {
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryNodeLimitsBreachedRejections()
            expectThrows(  
            assertEquals(35, shardStats.getCurrentReplicaBytes());  
        Settings settings = Settings.builder()
            } else {  
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        Index index = new Index("IndexName", "UUID");
        assertEquals(1, nodeStats.getReplicaRejections());
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 25, true);
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 3, false);  
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
        }
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
            assertEquals(0, shardStats.getPrimaryRejections());
            );  
        Index index = new Index("IndexName", "UUID");
        );  
        }
        );  
            assertEquals(0, nodeStats.getPrimaryRejections());
        }
            IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        Index index = new Index("IndexName", "UUID");  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
    }
            // Adding delay in the current in flight request to mimic throughput degradation
    }
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 3 * 1024, false)
            assertEquals(2, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());  
        }
    public void testShardLimitIncreaseMultipleShards() {
            Releasable coordinating2 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 50, false);
            assertEquals(
                );
            );  
    public void testCoordinatingPrimaryRejections() {
            IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
            Releasable replica2 = shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false);  
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertEquals(10, shardStats.getTotalCoordinatingBytes());  
            replica2.close();
                preLocalShardStats.getCurrentPrimaryBytes() + 1024 * 2,  
            Releasable primary2 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 5, false);
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();  
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        }
            assertEquals(
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
                    shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();  
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false);  
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
                        .getCurrentCombinedCoordinatingAndPrimaryBytes()
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId2);
        assertEquals(0, nodeStats.getCurrentPrimaryBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                Releasable coordinating2 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()  
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
            .build();
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
                (long) (4 * 1024 / 0.85),
    }
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 8 * 1024, false)  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                4 * 1024,
            assertEquals(
        try (  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()  
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()  
            // Primary can be forced  
        ) {
                        .getIndexingPressureShardStats(shardId)  
                preLocalShardStats.getPrimaryRejections(),
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
                Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false)
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(
        ShardId shardId = new ShardId(index, 0);  
        boolean randomBoolean = randomBoolean();  
        assertEquals(1, shardStats.getReplicaLastSuccessfulRequestLimitsBreachedRejections());
        assertEquals(80, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
import org.opensearch.core.index.Index;  
 * The OpenSearch Contributors require contributions made to  
            Releasable forced = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 2, true);
                );  
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        }
                IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        assertNull(shardStoreStats);
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);  
        Index index = new Index("IndexName", "UUID");
        assertEquals(20, nodeStats.getTotalPrimaryBytes());  
        assertEquals(15, shardStats.getCurrentReplicaLimits());
        try (
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
        }
        ) {
import org.opensearch.index.stats.IndexingPressurePerShardStats;
        ) {
            IndexingPressurePerShardStats preLocalShardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);  
        expectThrows(AssertionError.class, assertionMessage, releasable::close);
import org.opensearch.common.settings.Settings;
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 3 * 1024, false)  
            assertEquals(2, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
                ); // Increased Limit
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 4 * 1024, false)  
            Thread.sleep(100);  
                assertEquals(1, nodeStats.getCoordinatingRejections());
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 3, false);
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)  
        expectThrows(  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);  
                assertEquals(  
            assertEquals(1, shardStats.getPrimaryThroughputDegradationLimitsBreachedRejections());
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        assertEquals(35, nodeStats.getTotalReplicaBytes());
        } else {  
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
        ) {
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        Index index = new Index("IndexName", "UUID");
        }
                    OpenSearchRejectedExecutionException.class,
import org.opensearch.common.lease.Releasable;
                assertEquals(1, shardStats.getPrimaryRejections());
                    () -> shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024 * 2, false)  
                assertEquals(1, nodeStats.getPrimaryRejections());  
        assertEquals(60, shardStats.getTotalCoordinatingBytes());  
            );
    public void testReplicaShardRejectionViaSuccessfulRequestsParam() throws InterruptedException {  
        try (
        try (  
        releasable.close();
        if (randomBoolean) {
                OpenSearchRejectedExecutionException.class,
        ShardId shardId = new ShardId(index, 0);
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 10 * 1024, false);  
                    () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 2, false)
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());  
            assertEquals(1, shardStats.getPrimaryLastSuccessfulRequestLimitsBreachedRejections());  
                4 * 1024,  
            );
                    shardIndexingPressure.shardStats()
            assertEquals(preLocalNodeStats.getCurrentPrimaryBytes() + 1024 * 2, shardIndexingPressure.stats().getCurrentPrimaryBytes());
        }  
        } else {
            assertEquals(15, shardStats.getCurrentPrimaryBytes());  
            assertEquals(35, nodeStats.getCurrentReplicaBytes());  
            ) {
        assertEquals(0, shardStats.getCurrentReplicaBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)  
import org.opensearch.cluster.service.ClusterService;
            assertEquals(1024 * 12, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());  
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        if (randomBoolean) {
        if (randomBoolean) {
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
            assertEquals(1, shardStats.getReplicaNodeLimitsBreachedRejections());
        } else {  
    }  
                Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 7 * 1024, false);  
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());  
        assertEquals(1 * 1024, shardStats.getTotalReplicaBytes());  
        assertEquals(0, shardStats.getCurrentReplicaBytes());  
            );
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        ShardId shardId = new ShardId(index, 0);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes()
        ShardId shardId = new ShardId(index, 0);  
        assertEquals(35, shardStats.getTotalReplicaBytes());  
                preLocalShardStats.getPrimaryNodeLimitsBreachedRejections(),
        assertEquals(15, shardStats.getCurrentReplicaLimits());  
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());  
            );
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")  
        ) {
        ShardId shardId = new ShardId(index, 0);  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            Releasable forced = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 2, true);
                expectThrows(
            assertEquals(  
            assertEquals(10, shardStats.getCurrentCoordinatingBytes());
        ) {
            // Adding delay in the current in flight request to mimic throughput degradation  
        if (randomBoolean) {  
            forced.close();
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        assertEquals(0, nodeStats.getReplicaRejections());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            IndexingPressureStats preLocalNodeStats = shardIndexingPressure.stats();
            assertEquals(1, nodeStats.getPrimaryRejections());
            assertEquals(1024 * 12, shardStats.getCurrentReplicaBytes());  
        ShardId shardId = new ShardId(index, 0);
        try (
            );
                assertEquals(  
            );
        Releasable releasable = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024, false);
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
            assertEquals(  
            assertEquals(
    }  
        Index index = new Index("IndexName", "UUID");  
                ); // Increased Limit  
                () -> shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 2, false)
        ShardId shardId1 = new ShardId(index, 0);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 2, false)
                11 * 1024,  
        }  
            IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        assertNull(shardHotStoreStats);
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1);
        releasable.close();
        }  
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
            assertEquals(1, shardStats.getPrimaryRejections());
        .build();  
        assertEquals(80, nodeStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        }  
        assertEquals(15, shardStats.getCurrentReplicaLimits());
            assertEquals(  
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
            IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        }
                expectThrows(  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId2).getCurrentCombinedCoordinatingAndPrimaryBytes()
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 4 * 1024, false);
        }
            assertEquals(11 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());
        ) {
        Index index = new Index("IndexName", "UUID");  
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            try (
                    10,  
        try (Releasable ignore = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 11 * 1024, true)) {
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
                (long) (4 * 1024 / 0.85),
            assertEquals(1024 * 14, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());  
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaBytes());  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 2, false);  
        } else {
        } else {  
            .build();  
        assertEquals(1, shardStats.getReplicaLastSuccessfulRequestLimitsBreachedRejections());  
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);  
    public void testCoordinatingPrimaryShardRejectionViaThroughputDegradationParam() throws InterruptedException {
                    OpenSearchRejectedExecutionException.class,
    public void testForceExecutionOnCoordinating() {
            Thread.sleep(100);
            assertEquals(60, nodeStats.getCurrentCoordinatingBytes());  
            ); // Base Limit
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
import org.opensearch.test.ClusterServiceUtils;
        assertEquals(20, shardStats.getTotalPrimaryBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId2).getCurrentPrimaryAndCoordinatingLimits()  
                Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 7 * 1024, false);  
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
            assertEquals(1, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getReplicaRejections());
        assertEquals(15, shardStats.getCurrentReplicaLimits());
            assertEquals(1, shardIndexingPressure.stats().getReplicaRejections());
            assertEquals(preLocalNodeStats.getPrimaryRejections(), shardIndexingPressure.stats().getPrimaryRejections());
            );
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false)) {
            assertEquals(0, nodeStats.getCoordinatingRejections());
        // Total Bytes are 9*1024 and node limit is 10*1024  
            assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());
        }
            assertEquals(80, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(
        expectThrows(AssertionError.class, assertionMessage, releasable::close);
        try (
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
    }
        ShardId shardId = new ShardId(index, 0);
        } else {  
            assertEquals(1, shardStats.getReplicaRejections());
                4 * 1024,
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
            long preForceRejections = shardIndexingPressure.stats().getPrimaryRejections();
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
                4,
        }
            IndexingPressureStats nodeStats = shardIndexingPressure.stats();  
        assertEquals(15, shardStats.getCurrentReplicaLimits());
        if (randomBoolean) {  
            .build();
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 3, false)  
        assertEquals(10, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
            assertEquals(10, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                () -> shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false)
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
    }  
            IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);  
                1024 * 6,
        }
        assertNull(shardStoreStats);
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
                8 * 1024,
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());  
            assertEquals(1024 * 6, shardIndexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            );
            Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 3 * 1024, false);
            Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 3 * 1024, false);
                IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        try (
            assertEquals(  
        Index index = new Index("IndexName", "UUID");
        assertEquals(4 * 1024, shardStats.getTotalCoordinatingBytes());  
        assertEquals(0, shardStats.getCurrentReplicaBytes());
    }  
        assertNull(shardStoreStats);  
            primary.close();
            Releasable replica2 = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 9, false);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        assertEquals(1024 * 14, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId).getTotalReplicaBytes());  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false);
            assertEquals(
                8 * 1024,
                coordinating1.close();
            assertEquals(10, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
        }
            assertEquals(0, shardStats.getCurrentCoordinatingBytes());  
            );
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()  
        IndexingPressurePerShardStats shardHotStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
        try (
            assertEquals(0, shardStats.getCoordinatingRejections());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            assertEquals(1, shardStats.getPrimaryLastSuccessfulRequestLimitsBreachedRejections());  
            if (randomBoolean()) {
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
                2 * 1024,
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        try (
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        }
            assertEquals(1, shardStats.getCoordinatingThroughputDegradationLimitsBreachedRejections());  
                    10,
            );
        ShardId shardId = new ShardId(index, 0);
            assertEquals(1, shardStats.getCoordinatingLastSuccessfulRequestLimitsBreachedRejections());
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
            assertEquals(1, shardStats.getPrimaryThroughputDegradationLimitsBreachedRejections());
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();  
                    OpenSearchRejectedExecutionException.class,  
        assertEquals(0, shardStats.getCurrentPrimaryBytes());
        if (randomBoolean) {  
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024 * 3, false)
    }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertEquals(  
                (long) (1 * 1024 / 0.85),
            Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 1 * 1024, false);
            // Replica will be rejected once we cross 15KB Shard Limit
                );
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes()
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
            );
        Index index = new Index("IndexName", "UUID");  
        ) {
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 3, false);
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            OpenSearchRejectedExecutionException.class,
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        Settings settings = Settings.builder()  
        releasable = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1024, false);  
                preForcedShardRejections,  
            assertEquals(
        ShardId shardId = new ShardId(index, 0);  
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
            Releasable replica2 = shardIndexingPressure.markReplicaOperationStarted(shardId, 10, false)  
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()  
            1024 * 8,
        }  
        }
            assertEquals(1, shardStats.getCoordinatingLastSuccessfulRequestLimitsBreachedRejections());
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentReplicaLimits()  
        releasable = shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024);
            );
            expectThrows(
    public void testAssertionOnReleaseExecutedTwice() {
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
            );
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
                .getPrimaryRejections();
        } else {  
        assertEquals(8 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
        if (randomBoolean) {  
    public void testMemoryBytesMarkedAndReleased() {
            assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
            assertEquals(8, shardStats.getTotalPrimaryBytes());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
        if (randomBoolean) {  
            Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 3 * 1024, false)  
            assertEquals(
        }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes()
            Releasable coordinating2 = shardIndexingPressure.markCoordinatingOperationStarted(shardId2, 4 * 1024, false);  
            assertEquals(
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")  
        assertEquals(4 * 1024, shardStats.getTotalPrimaryBytes());
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")  
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)  
            assertEquals(preForceRejections, shardIndexingPressure.stats().getPrimaryRejections());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
                1024 * 8,
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")  
            assertEquals(
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 10, false);
                assertEquals(
                assertEquals(1024 * 6, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
        Settings settings = Settings.builder()
                assertEquals(1, shardStats.getPrimaryNodeLimitsBreachedRejections());  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()  
            assertEquals(0, shardStats.getCurrentPrimaryBytes());  
            assertEquals(  
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
        assertEquals(1, shardStats.getReplicaRejections());  
            assertEquals(1 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCoordinatingBytes());
        ShardId shardId = new ShardId(index, 0);
            assertEquals(20, nodeStats.getCurrentPrimaryBytes());
            );
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId).getTotalCombinedCoordinatingAndPrimaryBytes()
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
        }
            assertEquals(1, shardStats.getPrimaryRejections());
        ) {
        assertEquals(1024 * 14, shardIndexingPressure.stats().getTotalReplicaBytes());
        try (  
            assertEquals(1024 * 8, shardIndexingPressure.stats().getCurrentCombinedCoordinatingAndPrimaryBytes());  
            }
                expectThrows(  
            // Adding delay in the current in flight request to mimic throughput degradation
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        } else {
        Index index = new Index("IndexName", "UUID");  
            assertEquals(4 * 1024, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());  
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 2, false)) {  
            expectThrows(
            () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1024 * 11, false)
    }  
            );  
                    () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false)
                assertEquals(1024 * 6, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(
        String assertionMessage = "ShardIndexingPressure Release is called twice";
                (long) (2 * 1024 / 0.85),  
}
            try (
            assertEquals(0, shardStats.getCurrentPrimaryBytes());  
            replica1.close();  
            assertEquals(1, nodeStats.getCoordinatingRejections());
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());  
        }
        try (
                primary1.close();  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 8 * 1024, false);
        assertEquals(0, shardStats.getCurrentCoordinatingBytes());
        assertEquals(0, nodeStats.getCurrentCoordinatingBytes());
            );
        ) {
        try (
            assertEquals(
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            expectThrows(  
            coordinating.close();
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        assertEquals(1, shardStats.getReplicaThroughputDegradationLimitsBreachedRejections());
    public void testCoordinatingPrimaryShardRejectionViaSuccessfulRequestsParam() throws InterruptedException {  
        assertEquals(15, nodeStats.getTotalPrimaryBytes());
            assertEquals(0, nodeStats.getCurrentPrimaryBytes());
                );
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getPrimaryNodeLimitsBreachedRejections()  
                assertEquals(1, shardStats.getCoordinatingRejections());  
        assertEquals(10, nodeStats.getTotalCoordinatingBytes());
        Index index = new Index("IndexName", "UUID");
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);  
            try (
        Index index = new Index("IndexName", "UUID");
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)
        assertEquals(0, shardStats.getCurrentPrimaryBytes());  
            Releasable primary = shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 15)  
                10,  
            }
        Settings settings = Settings.builder()  
        ShardId shardId = new ShardId(index, 0);  
            Releasable replica1 = shardIndexingPressure.markReplicaOperationStarted(shardId, 2 * 1024, false)
            Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 3 * 1024, false)  
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();  
    public void testCoordinatingPrimaryShardLimitIncreaseEvaluateSecondaryParam() {  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
            );  
                                                                                                                                   // Limit  
            assertEquals(1, shardStats.getReplicaNodeLimitsBreachedRejections());
                expectThrows(
        }
        }  
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 1 * 1024, false);
            );
    }
        Index index = new Index("IndexName", "UUID");
        assertEquals(2 * 1024, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
    public void testReplicaShardRejectionSkippedInShadowModeViaSuccessfulRequestsParam() throws InterruptedException {  
                    OpenSearchRejectedExecutionException.class,
        assertEquals(0, shardStats.getCurrentReplicaBytes());
        assertEquals(15, shardStats.getTotalPrimaryBytes());
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
 *
                (long) (8 * 1024 / 0.85),  
        expectThrows(AssertionError.class, assertionMessage, releasable::close);  
        assertEquals(10, shardStats.getTotalCombinedCoordinatingAndPrimaryBytes());
            .build();
            try (
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 1)  
        expectThrows(  
            // Local to coordinating node primary actions not rejected
    }
            );  
    public void testCoordinatingPrimaryShardRejectionSkippedInShadowModeViaSuccessfulRequestsParam() throws InterruptedException {
                Releasable primary1 = shardIndexingPressure.markPrimaryOperationStarted(shardId, 6, false);  
            );
            );  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryAndCoordinatingLimits()
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, 8 * 1024, false);
    }
            assertEquals(0, nodeStats.getPrimaryRejections());  
            assertEquals(1024 * 14, shardIndexingPressure.stats().getCurrentReplicaBytes());  
        assertEquals(10, shardStats.getCurrentPrimaryAndCoordinatingLimits());
                8 * 1024,
            } else {
        assertEquals(1 * 1024, shardStats.getTotalPrimaryBytes());  
            assertEquals(0, shardStats.getCoordinatingRejections());  
                (long) (2 * 1024 / 0.85),
            assertEquals(1, shardStats.getCoordinatingThroughputDegradationLimitsBreachedRejections());
        Index index = new Index("IndexName", "UUID");
        Settings settings = Settings.builder()
                (long) (4 * 1024 / 0.85),
                assertEquals(1024 * 6, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            assertEquals(0, shardStats.getCurrentPrimaryBytes());
                Releasable coordinating1 = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 1 * 1024, false)  
        Index index = new Index("IndexName", "UUID");
    public void testReplicaRejections() {  
            OpenSearchRejectedExecutionException.class,
import org.opensearch.core.index.shard.ShardId;
            assertEquals(
                IndexingPressurePerShardStats shardStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);  
        assertEquals(11 * 1024, shardStats.getTotalReplicaBytes());
            assertEquals(1024 * 12, nodeStats.getCurrentReplicaBytes());
        try (Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, 11 * 1024, false)) {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)  
        assertEquals(0, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()
                assertEquals(8, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentPrimaryBytes());
            assertEquals(12 * 1024, shardStats.getTotalPrimaryBytes());  
        Index index = new Index("IndexName", "UUID");
        );  
        if (randomBoolean) {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(  
        ShardId shardId = new ShardId(index, 0);  
                preForcedShardRejections,
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);
    }
    public void testReplicaShardRejectionSkippedInShadowModeViaThroughputDegradationParam() throws InterruptedException {
        assertEquals(1024 * 8, shardIndexingPressure.stats().getTotalCombinedCoordinatingAndPrimaryBytes());
        assertEquals(0, nodeStats.getReplicaRejections());
        assertEquals(0, shardStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
                assertEquals(1, shardStats.getCoordinatingNodeLimitsBreachedRejections());
        assertEquals(0, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
    private final Settings settings = Settings.builder()
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId, 12 * 1024, false)
            );  
        releasable = shardIndexingPressure.markReplicaOperationStarted(shardId, 1024, false);
            assertEquals(
        IndexingPressurePerShardStats shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
            }  
            );
            assertEquals(1, nodeStats.getReplicaRejections());
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, 10, false);
        assertEquals(16 * 1024, shardStats.getTotalReplicaBytes());  
        Settings settings = Settings.builder()
            if (randomBoolean) {  
        replica.close();  
        assertEquals(1 * 1024, shardStats.getTotalPrimaryBytes());
            // Replica can be forced  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            // Adding delay in the current in flight request to mimic throughput degradation  
        ) {  
        assertEquals(1, shardStats.getReplicaRejections());
                    shardIndexingPressure.shardStats()
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId);  
    public void testCoordinatingPrimaryShardRejectionSkippedInShadowModeViaThroughputDegradationParam() throws InterruptedException {
        shardStats = shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId);
        ShardId shardId = new ShardId(index, 0);
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
            assertEquals(  
        ShardId shardId = new ShardId(index, 0);  
        try (
        Settings settings = Settings.builder()  
            assertEquals(
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId).getCurrentCombinedCoordinatingAndPrimaryBytes()  
        if (randomBoolean) {
    }
