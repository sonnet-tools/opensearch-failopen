        Releasable[] releasables;
        } else {
        assertEquals(
        assertEquals(
            if (releasable != null) {
        );
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
    }
 * compatible open source license.
        }
        ShardId shardId,
                    .getIndexingPressureShardStats(shardId1)
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId1, 10, false);
        for (int i = 0; i < concurrency; i++) {
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);
            );
        for (int i = 0; i < concurrency; i++) {
        long bytes,
            fireAllThenCompleteConcurrentRequestsWithUniformDelay(
 */
        final Thread[] threads = new Thread[concurrency];
        );
        // Generating a load to such that the requests in the window shows degradation in throughput.
        );
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingRejections());
            );
            shardStoreStats2.getCurrentReplicaLimits()
    public void testReplicaConcurrentUpdatesOnShardIndexingPressureTrackerObjects() throws Exception {
                Thread.sleep(delay);
            100,
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(
        Index index = new Index("IndexName", "UUID");
            );
            OperationType.REPLICA
        } else {
                }
            assertEquals(
            0,
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
                        releasable = shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes, false);
            0,
                    .getCoordinatingLastSuccessfulRequestLimitsBreachedRejections()
                10,
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
                shardIndexingPressure.coldStats()
        shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1);
import org.opensearch.common.settings.ClusterSettings;
    }
            10,
    ) throws Exception {
        // Generating a load to such that the requests in the window shows degradation in throughput.
                .getIndexingPressureShardStats(shardId1)
        boolean randomBoolean = randomBoolean();
        }
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);
import org.opensearch.test.OpenSearchTestCase;
                0,
                ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.get(settings),
        boolean randomBoolean = randomBoolean();
            200,
        OperationType operationType
                shardIndexingPressure,
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId1, 300 * 1024, false)
        assertEquals(NUM_THREADS * 15, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
                } else if (operationType == OperationType.PRIMARY) {
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
    }
                .getCurrentReplicaLimits(),
                OperationType.COORDINATING
            assertEquals(
            assertEquals(10, shardStoreStats.getCurrentPrimaryAndCoordinatingLimits());
        ShardId shardId1 = new ShardId(index, 0);
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingRejections());
        assertEquals(0, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
            assertEquals(
        assertEquals(10, shardStats.getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits());
                .getCurrentPrimaryAndCoordinatingLimits(),
        if (randomBoolean) {
        if (randomBoolean) {
                NUM_THREADS * 15,
        );
                .getIndexingPressureShardStats(shardId1)
            fireAllThenCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.PRIMARY);
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            shardStoreStats2.getCurrentPrimaryAndCoordinatingLimits()
            0,
        }
        fireAndCompleteConcurrentRequestsWithUniformDelay(
    private Matcher<Double> isInOperatingFactorRange() {
        );
        final Releasable[] releasables = fireConcurrentRequestsWithUniformDelay(
    ) throws Exception {
                } else {
        final int NUM_THREADS = scaledRandomIntBetween(80, 100);
                    .getCoordinatingLastSuccessfulRequestLimitsBreachedRejections()
        assertEquals(
        fireAndCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 100, OperationType.REPLICA);
            shardId1,
                shardStats.getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()
        if (randomBoolean) {
        long bytes,
            shardIndexingPressure,
            );
            threads[i] = new Thread(() -> {
        int concurrency,
        if (randomBoolean) {
        final Thread[] threads = new Thread[NUM_THREADS];
            .build();
            OpenSearchRejectedExecutionException.class,
    }
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);
                shardIndexingPressure.coldStats()
        assertEquals(384, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
            shardId,
        Settings settings = Settings.builder()
        ShardIndexingPressure shardIndexingPressure,
            assertEquals(
                    .getIndexingPressureShardStats(shardId1)
        long bytes,
        }
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
            releasables[i].close();
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                100,
        long delay,
        OperationType operationType
            randomIntBetween(50, 100),
            0,
        int concurrency,
        } else {
        // Generate a load which breaches both primary parameter
        for (int i = 0; i < NUM_THREADS; i++) {
            );
import org.hamcrest.Matcher;
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")
        } else {
        assertEquals(
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        ShardId shardId1 = new ShardId(index, 0);
            assertEquals(15, shardStoreStats.getCurrentReplicaLimits());
    private void fireAllThenCompleteConcurrentRequests(
            .build();
    ) throws Exception {
        AtomicInteger rejectionCount = new AtomicInteger();
        );
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
                    .getIndexingPressureShardStats(shardId1)
import org.opensearch.common.lease.Releasable;
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
    }
            fireAllThenCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.COORDINATING);
import org.opensearch.core.index.Index;
            if (releasable != null) {
        );
        statsFlag.includeAllShardIndexingPressureTrackers(false);
            );
                    releasable[counter] = shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, false);
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.COORDINATING);
            );
            shardIndexingPressure.coldStats()
                shardIndexingPressure.coldStats()
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 11 * 1024, false)
        } else {
                        releasable = shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, false);
    public void testCoordinatingPrimaryThreadedUpdateToShardLimitsWithRandomBytes() throws Exception {
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaRejections());
            assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
                100,
        ShardId shardId1 = new ShardId(index, 0);
        boolean randomBoolean = randomBoolean();
        CommonStatsFlags statsFlag = new CommonStatsFlags();
            assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes() < 50 * 200);
    }
        assertEquals(
            0,
        // No object in host store as no active shards
package org.opensearch.index;
        fireAllThenCompleteConcurrentRequestsWithUniformDelay(
        // Generating a concurrent + sequential load to have a fair throughput
        COORDINATING,
        // Generating a load such that requests are blocked requests.
    }
        } else {
        final Releasable[] releasables = new Releasable[NUM_THREADS];
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                OpenSearchRejectedExecutionException.class,
            try {
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
            assertEquals(
        }
                    .getIndexingPressureShardStats(shardId1)
    public void testReplicaThreadedUpdateToShardLimitsWithRandomBytes() throws Exception {
                OpenSearchRejectedExecutionException.class,
            t.join();
        int concurrency,
    }
        for (Thread t : threads) {
                for (int j = 0; j < randomIntBetween(400, 500); j++) {
    public void testCoordinatingPrimaryThreadedUpdateToShardLimitsAndRejections() throws Exception {
                OperationType.COORDINATING
        Index index = new Index("IndexName", "UUID");
        );
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        ShardId shardId,
        );
            greaterThan(ShardIndexingPressureMemoryManager.LOWER_OPERATING_FACTOR.get(settings)),
                    coordinating.close();
                .getIndexingPressureShardStats(shardId1)
        }
import org.hamcrest.Matchers;
        final Thread[] threads = new Thread[concurrency];
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);
            0,
    public void testReplicaThreadedThroughputDegradationAndRejection() throws Exception {
            isInOperatingFactorRange()
        Settings settings = Settings.builder()
        );
        if (randomBoolean) {
                1,
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
                    }
        .build();
                shardIndexingPressure.coldStats()
        assertNull(shardStoreStats);
 * SPDX-License-Identifier: Apache-2.0
        ShardId shardId,
            );
                200,
        assertEquals(
        assertEquals(shardStoreStats.getCurrentReplicaLimits(), shardStoreStats2.getCurrentReplicaLimits());
                0,
            10,
                try {
                    .getCoordinatingThroughputDegradationLimitsBreachedRejections()
        // Mimic the time elapsed after requests being stuck
        for (int i = 0; i < NUM_THREADS; i++) {
            shardId1,
        assertEquals(
            );
        assertEquals(
                0,
                shardIndexingPressure,
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
            .getIndexingPressureShardStats(shardId1);
        assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes() < 50 * 300);
        );
        Index index = new Index("IndexName", "UUID");
                    Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, false);
        assertEquals(rejectionCount.get(), nodeStats.getReplicaRejections());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        );
            concurrency,
        final Releasable[] releasable = fireConcurrentRequestsWithUniformDelay(
        if (randomBoolean) {
                100,
        );
            assertEquals(
                shardId1,
        }
            15,
            expectThrows(
public class ShardIndexingPressureConcurrentExecutionTests extends OpenSearchTestCase {
        } else {
        }
    }
        if (randomBoolean) {
        long bytes,
            shardIndexingPressure,
    }
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
            assertEquals(rejectionCount.get(), nodeStats.getCoordinatingRejections());
import org.opensearch.index.stats.IndexingPressureStats;
            shardIndexingPressure.coldStats()
        OperationType operationType
                    .getIndexingPressureShardStats(shardId1)
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                shardIndexingPressure,
    public void testReplicaThreadedNodeLimitsAndRejection() throws Exception {
        statsFlag.includeOnlyTopIndexingPressureMetrics(false);
        shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1);
                } else {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            assertNull(shardStoreStats);
            );
                randomIntBetween(50, 100),
        for (Thread t : threads) {
            shardIndexingPressure.coldStats()
        );
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
            OperationType.REPLICA
        Index index = new Index("IndexName", "UUID");
            threads[i].start();
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
            assertEquals(
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
            assertEquals(
        assertEquals(
        } else {
        }
            );
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        } else {
        assertNull(shardStoreStats);
        // Generating a load to such that the requests in the window shows degradation in throughput.
                    .getIndexingPressureShardStats(shardId1)
        Index index = new Index("IndexName", "UUID");
            );
            releasables[i].close();
            );
    public void testCoordinatingPrimaryConcurrentUpdatesOnShardIndexingPressureTrackerObjects() throws Exception {
import static org.hamcrest.Matchers.allOf;
        if (randomBoolean) {
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits(),
        fireAllThenCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.REPLICA);
 * The OpenSearch Contributors require contributions made to
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaRejections());
                1,
import org.opensearch.index.stats.IndexingPressurePerShardStats;
            expectThrows(
        ShardIndexingPressureStats shardStats = shardIndexingPressure.shardStats();
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            t.join();
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        ShardId shardId1 = new ShardId(index, 0);
            0,
        }
                .getIndexingPressureShardStats(shardId1)
                try {
                    .getPrimaryLastSuccessfulRequestLimitsBreachedRejections()
                    releasables[counter] = shardIndexingPressure.markReplicaOperationStarted(shardId1, 300, false);
            );
    }
        assertEquals(
        Thread.sleep(randomIntBetween(50, 100));
            operationType
    }
        Index index = new Index("IndexName", "UUID");
        if (randomBoolean) {
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)
                    if (operationType == OperationType.COORDINATING) {
        if (randomBoolean) {
    }
            shardId,
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        ShardId shardId1 = new ShardId(index, 0);
            int counter = i;
                0,
        }
                shardIndexingPressure.coldStats()
            fireConcurrentAndParallelRequestsForUniformThroughPut(
        }
        long bytes,
        }
        CommonStatsFlags statsFlag = new CommonStatsFlags();
        } else {
                shardId1,
            );
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()
        if (randomBoolean) {
        MatcherAssert.assertThat(
            1,
                0,
        fireConcurrentAndParallelRequestsForUniformThroughPut(
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            100,
                shardId1,
            );
        } else {
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                1,
        final Releasable[] releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 10, OperationType.REPLICA);
import java.util.concurrent.atomic.AtomicInteger;
        assertNull(shardStoreStats);
        Index index = new Index("IndexName", "new_uuid");
            });
        IndexingPressurePerShardStats shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag)
                }
                NUM_THREADS,
        shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        if (randomBoolean) {
        if (randomBoolean) {
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
    public void testReplicaThreadedUpdateToShardLimitsAndRejections() throws Exception {
                shardIndexingPressure,
        }
        assertNull(shardStoreStats);
        // Generate a load which breaches both primary parameter
                    Releasable releasable;
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
            );
    public void testReplicaThreadedLastSuccessfulRequestsAndRejection() throws Exception {
        }
        ;
        ShardId shardId1 = new ShardId(index, 0);
        );
        );
            threads[i] = new Thread(() -> {
        boolean randomBoolean = randomBoolean();
                .getReplicaThroughputDegradationLimitsBreachedRejections()
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
                0,
        }
        // Generate a load which breaches both primary parameter
                rejectionCount.get(),
            );
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections()
    }
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
            );
            256,
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
    }
        // If rejection count equals NUM_THREADS that means rejections happened until the last request, then we'll get shardStoreStats which
            .build();
                    releasable[counter] = shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes, false);
    private Releasable[] fireConcurrentRequests(
        assertThat(shardStoreStats.getCurrentReplicaLimits(), Matchers.greaterThan(100L));
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 200 * 1024, false)
            1,
        assertEquals(
        if (randomBoolean) {
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 80)
            NUM_THREADS,
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
        Index index = new Index("IndexName", "UUID");
    ) throws Exception {
                    } else {
                NUM_THREADS,
import org.hamcrest.MatcherAssert;
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId1, 240 * 1024, false)
        }
            fireAllThenCompleteConcurrentRequestsWithUniformDelay(
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        ShardId shardId,
/*
            releasables[i].close();
            assertEquals(rejectionCount.get(), nodeStats.getPrimaryRejections());
        ShardId shardId1 = new ShardId(index, 0);
    public void testReplicaThreadedUpdateToShardLimits() throws Exception {
            shardIndexingPressure,
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)
        } else {
        Releasable[] releasables;
        );
                } catch (OpenSearchRejectedExecutionException e) {
        );
        Releasable[] releasable;
    }
        for (int i = 0; i < concurrency; i++) {
        );
                NUM_THREADS,
            primary.close();
import static org.hamcrest.Matchers.greaterThan;
            shardId1,
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
        // One request being successful
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits(),
                .getIndexingPressureShardStats(shardId1)
        }
        }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
import org.opensearch.index.stats.ShardIndexingPressureStats;
        final int NUM_THREADS = 100;
            );
            });
        expectThrows(
        );
                shardIndexingPressure.coldStats()
        }
    private void fireAllThenCompleteConcurrentRequestsWithUniformDelay(
        Settings settings = Settings.builder()
            expectThrows(
        } else {
                .getReplicaLastSuccessfulRequestLimitsBreachedRejections()
        // If rejection count equals NUM_THREADS that means rejections happened until the last request, then we'll get shardStoreStats which
                    rejectionCount.addAndGet(1);
        final int NUM_THREADS = scaledRandomIntBetween(100, 150);
        }
            assertEquals(
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaRejections());
                OperationType.PRIMARY
        assertEquals(
        final Releasable[] releasable = new Releasable[concurrency];
                if (operationType == OperationType.COORDINATING) {
 *
                0,
        } else {
        Index index = new Index("IndexName", "UUID");
            }
        ShardId shardId1 = new ShardId(index, 0);
                .getIndexingPressureShardStats(shardId1)
        statsFlag.includeAllShardIndexingPressureTrackers(true);
        assertEquals(384, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes() < 50 * 200);
                        releasable = shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, false);
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
        boolean randomBoolean = randomBoolean();
        ShardId shardId1 = new ShardId(index, 0);
        boolean randomBoolean = randomBoolean();
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
                    try {
        // was updated on the last request. In other cases, the shardStoreStats simply moves to the cold store and null is returned.
    ) throws Exception {
        }
                shardId1,
            );
            assertEquals(
            releasables[i].close();
                ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.get(settings),
                    .getIndexingPressureShardStats(shardId1)
    public void testReplicaThreadedSimultaneousUpdateToShardLimits() throws Exception {
        ShardIndexingPressure shardIndexingPressure,
            );
            threads[i].start();
        assertEquals(
        nodeStats = shardIndexingPressure.stats();
        int concurrency,
        ShardId shardId,
                } catch (OpenSearchRejectedExecutionException e) {
        ShardIndexingPressure shardIndexingPressure,
        final int NUM_THREADS = 100;
            0,
                randomIntBetween(50, 100),
}
                OpenSearchRejectedExecutionException.class,
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        IndexingPressurePerShardStats shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag)
            10,
        boolean randomBoolean = randomBoolean();
                    .getIndexingPressureShardStats(shardId1)
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        if (randomBoolean) {
        ShardId shardId1 = new ShardId(index, 0);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            );
    ) throws Exception {
            }
        assertNull(shardStoreStats);
            }
        assertEquals(
                    .getIndexingPressureShardStats(shardId1)
import org.opensearch.core.index.shard.ShardId;
        assertNull(shardStoreStats);
        // Generating a load such that requests are blocked requests.
    private void fireAndCompleteConcurrentRequests(
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingRejections());
                .getReplicaLastSuccessfulRequestLimitsBreachedRejections()
            10,
        }
            threads[i] = new Thread(() -> {
        if (randomBoolean) {
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)
                0,
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        );
        assertEquals(
            releasables[i].close();
        }
                0,
        return releasable;
        Index index = new Index("IndexName", "new_uuid");
        long delay,
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")
        }
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
    private final Settings settings = Settings.builder()
            0,
    private final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
        for (Releasable releasable : releasables) {
            } catch (InterruptedException e) {
import org.opensearch.common.settings.Settings;
        final int NUM_THREADS = scaledRandomIntBetween(110, 150);
        fireAllThenCompleteConcurrentRequestsWithUniformDelay(concurrency, shardIndexingPressure, shardId, bytes, 0, operationType);
            shardIndexingPressure,
        } else {
        ShardIndexingPressureStats shardStats = shardIndexingPressure.shardStats();
        } else {
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        }
            (double) (NUM_THREADS * 15) / shardIndexingPressure.shardStats()
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "15KB")
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId1, 11 * 1024, false)
        assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes());
                    releasable.close();
    private void fireConcurrentAndParallelRequestsForUniformThroughPut(
        );
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
            releasable[i].close();
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        // Generate a load which breaches both primary parameter
            );
                        releasables[counter] = shardIndexingPressure.markPrimaryOperationStarted(shardId1, 200, false);
            fireConcurrentAndParallelRequestsForUniformThroughPut(
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
                        Thread.sleep(delay);
            256,
            });
    private void fireAndCompleteConcurrentRequestsWithUniformDelay(
    }
                    .getIndexingPressureShardStats(shardId1)
        );
        boolean randomBoolean = randomBoolean();
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
        assertEquals(shardStoreStats.getCurrentPrimaryAndCoordinatingLimits(), shardStoreStats2.getCurrentPrimaryAndCoordinatingLimits());
                    .getCoordinatingLastSuccessfulRequestLimitsBreachedRejections()
        // Generate a load which breaches both primary parameter
                1,
        assertThat(shardStoreStats.getCurrentPrimaryAndCoordinatingLimits(), Matchers.greaterThan(100L));
                    .getCoordinatingThroughputDegradationLimitsBreachedRejections()
        assertEquals(
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
                    replica.close();
                }
            releasable[i].close();
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
            );
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryRejections());
        );
        assertEquals(
        Settings settings = Settings.builder()
        statsFlag.includeOnlyTopIndexingPressureMetrics(true);
        if (randomBoolean) {
                    .getCoordinatingThroughputDegradationLimitsBreachedRejections()
            assertEquals(rejectionCount.get(), nodeStats.getPrimaryRejections());
        for (Thread t : threads) {
            10,
        // Mimic the time elapsed after requests being stuck
            threads[i] = new Thread(() -> {
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
                releasable.close();
        }
            0,
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        ;
                shardIndexingPressure,
                100,
        }
    public void testCoordinatingPrimaryThreadedLastSuccessfulRequestsAndRejection() throws Exception {
            (double) (NUM_THREADS * 15) / shardIndexingPressure.shardStats()
                0,
                OperationType.COORDINATING
import org.opensearch.cluster.service.ClusterService;
        for (int i = 0; i < NUM_THREADS; i++) {
        }
        long delay,
            releasable = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.COORDINATING);
                NUM_THREADS,
            OperationType.COORDINATING
        Settings settings = Settings.builder()
            );
            shardIndexingPressure.coldStats()
        for (Thread t : threads) {
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        );
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            assertEquals(
        assertEquals(
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
        } else {
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        for (int i = 0; i < concurrency; i++) {
    public void testCoordinatingPrimaryThreadedNodeLimitsAndRejection() throws Exception {
        MatcherAssert.assertThat(
            t.join();
        }
            assertEquals(
            assertEquals(
                    } else {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // One request being successful
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
    }
        replica.close();
        statsFlag.includeAllShardIndexingPressureTrackers(false);
            concurrency,
        }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        // No object in host store as no active shards
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
                        releasables[counter] = shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 200, false);
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        }
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes()
        OperationType operationType
    }
        ShardId shardId1 = new ShardId(index, 0);
        if (randomBoolean) {
                shardIndexingPressure.coldStats()
                        // Do Nothing
        ShardIndexingPressure shardIndexingPressure,
            expectThrows(
                    Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes, false);
                .getIndexingPressureShardStats(shardId1)
        }
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
                shardIndexingPressure.coldStats()
            int counter = i;
            t.join();
        // was updated on the last request. In other cases, the shardStoreStats simply moves to the cold store and null is returned.
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        for (int i = 0; i < NUM_THREADS; i++) {
                } else if (operationType == OperationType.PRIMARY) {
            threads[i].start();
            fireAndCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 100, OperationType.PRIMARY);
        );
            assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes() < 50 * 200);
            operationType
    ) throws Exception {
            releasable = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.PRIMARY);
        final int NUM_THREADS = scaledRandomIntBetween(100, 150);
        } else {
                .getReplicaThroughputDegradationLimitsBreachedRejections()
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")
        if (randomBoolean) {
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")
            100,
        }
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
    private Releasable[] fireConcurrentRequestsWithUniformDelay(
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()
        assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
        assertEquals(rejectionCount.get(), nodeStats.getReplicaRejections());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        REPLICA
                OpenSearchRejectedExecutionException.class,
        }
    public enum OperationType {
        Index index = new Index("IndexName", "UUID");
        }
            releasables = fireConcurrentRequestsWithUniformDelay(
    private final ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        final int NUM_THREADS = scaledRandomIntBetween(80, 100);
                }
import org.opensearch.test.ClusterServiceUtils;
            fireAndCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 100, OperationType.COORDINATING);
        if (rejectionCount.get() == NUM_THREADS) {
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 240 * 1024, false)
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
    }
        final Thread[] threads = new Thread[concurrency];
        assertEquals(15, shardStats.getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
                100,
        for (int i = 0; i < NUM_THREADS; i++) {
                0,
        );
                    } else if (operationType == OperationType.PRIMARY) {
            ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.get(settings),
        }
                    .getIndexingPressureShardStats(shardId1)
        expectThrows(
        for (Releasable releasable : releasables) {
        OperationType operationType
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        // Generate a load which breaches both primary parameter
        for (int i = 0; i < NUM_THREADS; i++) {
            assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        if (randomBoolean) {
        }
                } catch (Exception e) {
    }
                shardIndexingPressure.coldStats()
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        }
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryRejections());
            assertEquals(
        }
        ShardId shardId,
        for (int i = 0; i < NUM_THREADS; i++) {
                releasable.close();
            .build();
        Index index = new Index("IndexName", "UUID");
                shardIndexingPressure.coldStats()
        if (randomBoolean) {
                1,
            randomIntBetween(5, 15),
        ShardId shardId,
            coordinating.close();
            releasables[i].close();
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        AtomicInteger rejectionCount = new AtomicInteger();
        for (int i = 0; i < NUM_THREADS; i++) {
        if (rejectionCount.get() == NUM_THREADS) {
        } else {
        Index index = new Index("IndexName", "UUID");
                    Thread.sleep(delay);
                    }
        assertNull(shardStoreStats);
            int counter = i;
        Releasable[] releasables;
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        final Releasable[] releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 20, OperationType.REPLICA);
        ShardIndexingPressure shardIndexingPressure,
        final int NUM_THREADS = scaledRandomIntBetween(110, 150);
        shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            bytes,
                    .getPrimaryThroughputDegradationLimitsBreachedRejections()
            .getIndexingPressureShardStats(shardId1);
            lessThanOrEqualTo(ShardIndexingPressureMemoryManager.UPPER_OPERATING_FACTOR.get(settings))
        ShardIndexingPressure shardIndexingPressure,
        Settings settings = Settings.builder()
                .getIndexingPressureShardStats(shardId1)
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
    }
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            .build();
            isInOperatingFactorRange()
        OperationType operationType
                1,
            threads[i] = new Thread(() -> {
        shardStats = shardIndexingPressure.coldStats();
        ShardId shardId1 = new ShardId(index, 0);
        assertEquals(
        statsFlag.includeOnlyTopIndexingPressureMetrics(false);
    }
        }
        Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId1, 10, false);
        int concurrency,
                    .getPrimaryThroughputDegradationLimitsBreachedRejections()
            bytes,
            threads[i].start();
                if (operationType == OperationType.COORDINATING) {
                shardId1,
                // Do Nothing
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            releasable[i].close();
                OperationType.PRIMARY
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
            );
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
        return allOf(
            );
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
            NUM_THREADS,
            });
            });
                    if (randomBoolean) {
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId1, 200 * 1024, false)
            expectThrows(
                try {
            releasables = fireConcurrentRequestsWithUniformDelay(
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
                shardIndexingPressure.coldStats()
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        for (int i = 0; i < NUM_THREADS; i++) {
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
        ShardId shardId1 = new ShardId(index, 0);
        } else {
            OpenSearchRejectedExecutionException.class,
    }
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
                100,
        assertEquals(rejectionCount.get(), shardStats.getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
        ShardIndexingPressure shardIndexingPressure,
    }
        ShardId shardId1 = new ShardId(index, 0);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        nodeStats = shardIndexingPressure.stats();
    public void testCoordinatingPrimaryThreadedSimultaneousUpdateToShardLimits() throws Exception {
        );
            assertEquals(
            );
            NUM_THREADS * 15,
        statsFlag.includeAllShardIndexingPressureTrackers(true);
        assertNull(shardStoreStats);
                0,
        } else {
        Index index = new Index("IndexName", "UUID");
        Index index = new Index("IndexName", "UUID");
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 10, OperationType.PRIMARY);
                OpenSearchRejectedExecutionException.class,
            OpenSearchRejectedExecutionException.class,
        }
        OperationType operationType
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes()
        ShardId shardId1 = new ShardId(index, 0);
            assertEquals(
            );
        assertTrue(nodeStats.getCurrentReplicaBytes() < 50 * 300);
            shardIndexingPressure,
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId1, 340 * 1024, false)
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()
            expectThrows(
        );
    public void testCoordinatingPrimaryThreadedUpdateToShardLimits() throws Exception {
            assertEquals(
        Releasable[] releasable = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.REPLICA);
        int concurrency,
        expectThrows(
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
                10,
        ShardId shardId1 = new ShardId(index, 0);
                    primary.close();
        );
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.PRIMARY);
        assertTrue(nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes() < 50 * 200);
            );
        );
        }
        );
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
                    releasable[counter] = shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, false);
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)
                OpenSearchRejectedExecutionException.class,
                    .getPrimaryThroughputDegradationLimitsBreachedRejections()
        for (Thread t : threads) {
        // Generating a load to such that the requests in the window shows degradation in throughput.
            assertEquals(
        return fireConcurrentRequestsWithUniformDelay(concurrency, shardIndexingPressure, shardId, bytes, 0, operationType);
            delay,
                NUM_THREADS * 15,
                }
        } else {
                shardIndexingPressure,
        ;
        int concurrency,
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryRejections());
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId1, 11 * 1024, false)
                OperationType.PRIMARY
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
                shardId1,
        statsFlag.includeOnlyTopIndexingPressureMetrics(true);
        assertEquals(
                }
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections()
            assertEquals(rejectionCount.get(), shardStats.getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections());
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
        Thread.sleep(randomIntBetween(50, 100));
                200,
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
            shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
                    rejectionCount.addAndGet(1);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
                    // Do Nothing
        );
            shardIndexingPressure.coldStats()
                    } catch (Exception e) {
        long delay,
            );
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections()
    public void testCoordinatingPrimaryThreadedThroughputDegradationAndRejection() throws Exception {
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                    .getPrimaryLastSuccessfulRequestLimitsBreachedRejections()
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertEquals(
                shardIndexingPressure.coldStats()
            );
            0,
        // Generating a load to have a fair throughput
        assertEquals(
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            .build();
            assertEquals(
                .getReplicaThroughputDegradationLimitsBreachedRejections()
        } else {
            assertEquals(
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 10, OperationType.COORDINATING);
                    .getPrimaryLastSuccessfulRequestLimitsBreachedRejections()
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 10, false);
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
            threads[i].start();
        assertEquals(
            assertNull(shardStoreStats);
        shardStats = shardIndexingPressure.coldStats();
        final Releasable[] releasables = new Releasable[NUM_THREADS];
                    Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, false);
                    }
                .getReplicaLastSuccessfulRequestLimitsBreachedRejections()
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            shardIndexingPressure.coldStats()
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        Index index = new Index("IndexName", "UUID");
        PRIMARY,
                    .getIndexingPressureShardStats(shardId1)
        long bytes,
        final Thread[] threads = new Thread[NUM_THREADS];
            assertEquals(rejectionCount.get(), nodeStats.getCoordinatingRejections());
        long bytes,
            t.join();
