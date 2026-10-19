            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)  
                shardId1,  
                    .getIndexingPressureShardStats(shardId1)
        long bytes,  
        assertEquals(15, shardStats.getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
    }
                releasable.close();  
        );  
            0,  
            .getIndexingPressureShardStats(shardId1);
        // Generating a load to such that the requests in the window shows degradation in throughput.  
        assertEquals(
        );
                    primary.close();
                shardId1,  
            releasables[i].close();
            releasables[i].close();  
        expectThrows(  
        return fireConcurrentRequestsWithUniformDelay(concurrency, shardIndexingPressure, shardId, bytes, 0, operationType);  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        long bytes,
            assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes() < 50 * 200);
        nodeStats = shardIndexingPressure.stats();  
            NUM_THREADS,
                    .getPrimaryThroughputDegradationLimitsBreachedRejections()
            fireAllThenCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.COORDINATING);
        } else {
                OperationType.COORDINATING  
        ShardId shardId1 = new ShardId(index, 0);
        // Generate a load which breaches both primary parameter
        final Releasable[] releasable = fireConcurrentRequestsWithUniformDelay(  
                0,
                    releasable[counter] = shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, false);  
        for (int i = 0; i < NUM_THREADS; i++) {
        }  
        for (int i = 0; i < concurrency; i++) {
        shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);  
            operationType  
            );
            threads[i].start();  
                }  
        }
                200,
            0,  
        }
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
            200,  
                0,
    public void testReplicaThreadedUpdateToShardLimits() throws Exception {
    private Releasable[] fireConcurrentRequests(
        assertEquals(
        Settings settings = Settings.builder()  
import org.hamcrest.MatcherAssert;  
                1,
        Settings settings = Settings.builder()
        Releasable[] releasable = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.REPLICA);
        }
    }
    ) throws Exception {
        }  
            assertEquals(  
            ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.get(settings),
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        long bytes,
        } else {
            0,  
        // Generating a load to such that the requests in the window shows degradation in throughput.
            t.join();  
        }
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            shardIndexingPressure.coldStats()  
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean) {
            assertEquals(  
        shardStats = shardIndexingPressure.coldStats();
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()  
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId1, 11 * 1024, false)
        if (randomBoolean) {
                1,
        OperationType operationType
    private void fireAndCompleteConcurrentRequestsWithUniformDelay(
                shardIndexingPressure.coldStats()  
        assertEquals(10, shardStats.getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits());
                        releasable = shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, false);
            int counter = i;
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
                0,
            shardIndexingPressure,
            shardIndexingPressure,
                } catch (OpenSearchRejectedExecutionException e) {
                    .getCoordinatingThroughputDegradationLimitsBreachedRejections()
    }  
        if (randomBoolean) {  
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
                shardIndexingPressure.coldStats()  
        }
    public void testReplicaThreadedNodeLimitsAndRejection() throws Exception {
                if (operationType == OperationType.COORDINATING) {  
                shardIndexingPressure,
                .getIndexingPressureShardStats(shardId1)
        );  
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);
                    .getCoordinatingThroughputDegradationLimitsBreachedRejections()  
                .getReplicaThroughputDegradationLimitsBreachedRejections()
            OpenSearchRejectedExecutionException.class,  
    }
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 200 * 1024, false)
        if (randomBoolean) {  
            .build();
                1,
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
        assertEquals(
                .getIndexingPressureShardStats(shardId1)
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertNull(shardStoreStats);
            );
            assertEquals(rejectionCount.get(), nodeStats.getPrimaryRejections());
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
            0,
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)  
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections()  
        for (int i = 0; i < NUM_THREADS; i++) {
            0,
        MatcherAssert.assertThat(
        }  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")
                Thread.sleep(delay);  
        Releasable[] releasable;
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
            shardId1,
                shardIndexingPressure.coldStats()
 *
                shardIndexingPressure,
        } else {
        assertThat(shardStoreStats.getCurrentPrimaryAndCoordinatingLimits(), Matchers.greaterThan(100L));  
        return allOf(
                shardId1,  
        assertEquals(shardStoreStats.getCurrentPrimaryAndCoordinatingLimits(), shardStoreStats2.getCurrentPrimaryAndCoordinatingLimits());
        statsFlag.includeOnlyTopIndexingPressureMetrics(true);  
            );
        shardStats = shardIndexingPressure.coldStats();
                    }
                NUM_THREADS,
        assertEquals(
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
        expectThrows(
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")  
        ShardId shardId1 = new ShardId(index, 0);  
        }
        for (int i = 0; i < NUM_THREADS; i++) {
                }
            );
        }  
    }  
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 10, OperationType.COORDINATING);
        for (Thread t : threads) {
    }  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());  
        boolean randomBoolean = randomBoolean();
            OpenSearchRejectedExecutionException.class,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")  
        }  
import org.opensearch.cluster.service.ClusterService;
            100,
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
            OperationType.REPLICA  
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        assertNull(shardStoreStats);
                OperationType.COORDINATING  
                shardIndexingPressure,
            assertEquals(rejectionCount.get(), shardStats.getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections());
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
                .getIndexingPressureShardStats(shardId1)
        return releasable;
        ShardId shardId,  
                    .getIndexingPressureShardStats(shardId1)  
            releasables[i].close();  
        final Thread[] threads = new Thread[NUM_THREADS];
        CommonStatsFlags statsFlag = new CommonStatsFlags();
    }  
        );  
            );
        );  
        Settings settings = Settings.builder()
        } else {
import java.util.concurrent.atomic.AtomicInteger;  
        );
            0,  
                NUM_THREADS * 15,
                1,
        );
            );
        assertEquals(  
        assertEquals(  
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        assertNull(shardStoreStats);
                shardId1,  
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        );  
        final int NUM_THREADS = scaledRandomIntBetween(100, 150);
        if (randomBoolean) {
            threads[i].start();
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")  
        // Mimic the time elapsed after requests being stuck
        // If rejection count equals NUM_THREADS that means rejections happened until the last request, then we'll get shardStoreStats which
                0,
        );
                0,  
 */  
        Thread.sleep(randomIntBetween(50, 100));
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
        }  
        ShardId shardId,
    }  
        int concurrency,  
        OperationType operationType  
        ;  
        Index index = new Index("IndexName", "UUID");  
        ShardId shardId1 = new ShardId(index, 0);
                100,
            );
    ) throws Exception {
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)
        );
        if (randomBoolean) {
        int concurrency,
        long delay,
    }
                shardIndexingPressure,
                    .getIndexingPressureShardStats(shardId1)
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        assertEquals(
                    .getCoordinatingLastSuccessfulRequestLimitsBreachedRejections()
            assertEquals(
        ShardId shardId,
                0,  
                    .getCoordinatingThroughputDegradationLimitsBreachedRejections()
        } else {  
            10,
            randomIntBetween(50, 100),  
 * SPDX-License-Identifier: Apache-2.0
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);
        // No object in host store as no active shards
            NUM_THREADS,
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryRejections());  
        assertEquals(
        // Generating a load such that requests are blocked requests.
                    .getIndexingPressureShardStats(shardId1)
            10,
        // Generate a load which breaches both primary parameter
            assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes() < 50 * 200);
        ShardId shardId1 = new ShardId(index, 0);  
            assertEquals(
        if (randomBoolean) {  
            expectThrows(  
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaRejections());  
        }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)  
                    } else if (operationType == OperationType.PRIMARY) {
        long bytes,
        for (int i = 0; i < concurrency; i++) {
            );  
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()
        CommonStatsFlags statsFlag = new CommonStatsFlags();
        Index index = new Index("IndexName", "UUID");
                shardIndexingPressure.coldStats()
            );  
        }
                .getIndexingPressureShardStats(shardId1)
        if (randomBoolean) {  
                } else if (operationType == OperationType.PRIMARY) {  
            } catch (InterruptedException e) {
                    .getCoordinatingLastSuccessfulRequestLimitsBreachedRejections()
                    .getIndexingPressureShardStats(shardId1)
        ShardId shardId1 = new ShardId(index, 0);  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits(),  
            .build();
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
                    if (randomBoolean) {  
            shardStoreStats2.getCurrentPrimaryAndCoordinatingLimits()
            );
        }
        if (randomBoolean) {
            0,  
        ShardIndexingPressure shardIndexingPressure,  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
        );
            10,
    public void testCoordinatingPrimaryThreadedThroughputDegradationAndRejection() throws Exception {
        );  
        }
                0,
            fireAllThenCompleteConcurrentRequestsWithUniformDelay(  
        } else {
            .build();
                } catch (OpenSearchRejectedExecutionException e) {  
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
    public void testCoordinatingPrimaryThreadedSimultaneousUpdateToShardLimits() throws Exception {
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes()  
            if (releasable != null) {
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()  
        // Generating a concurrent + sequential load to have a fair throughput
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
        final int NUM_THREADS = scaledRandomIntBetween(80, 100);  
        ShardIndexingPressure shardIndexingPressure,
            });  
            );
import org.opensearch.index.stats.ShardIndexingPressureStats;
        } else {
    }
import org.opensearch.test.OpenSearchTestCase;
        } else {
        assertEquals(
    private Releasable[] fireConcurrentRequestsWithUniformDelay(  
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());  
                shardIndexingPressure.coldStats()  
        for (Thread t : threads) {  
        } else {  
            );
                ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.get(settings),
            100,
        MatcherAssert.assertThat(  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
}
            assertEquals(
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
                0,
                .getReplicaThroughputDegradationLimitsBreachedRejections()  
        }
            );  
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 80)
                NUM_THREADS,
            );  
        }  
            shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
            15,
                    rejectionCount.addAndGet(1);
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        ShardId shardId,
                100,
        );
            );
    public void testCoordinatingPrimaryThreadedNodeLimitsAndRejection() throws Exception {  
        assertNull(shardStoreStats);  
            fireAllThenCompleteConcurrentRequestsWithUniformDelay(  
        Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId1, 10, false);  
            OperationType.REPLICA
        ShardId shardId1 = new ShardId(index, 0);  
            assertEquals(rejectionCount.get(), nodeStats.getPrimaryRejections());
                rejectionCount.get(),
                    }
        boolean randomBoolean = randomBoolean();  
            t.join();
            shardIndexingPressure.coldStats()
                releasable.close();
        ;
                    Thread.sleep(delay);  
        } else {  
public class ShardIndexingPressureConcurrentExecutionTests extends OpenSearchTestCase {  
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        // If rejection count equals NUM_THREADS that means rejections happened until the last request, then we'll get shardStoreStats which  
                .getCurrentPrimaryAndCoordinatingLimits(),  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
    private void fireAndCompleteConcurrentRequests(
            assertEquals(
            assertNull(shardStoreStats);
                }
                    if (operationType == OperationType.COORDINATING) {
            assertEquals(
            );  
                100,
        statsFlag.includeOnlyTopIndexingPressureMetrics(true);  
                OperationType.PRIMARY  
        Releasable[] releasables;
                OpenSearchRejectedExecutionException.class,
    public void testCoordinatingPrimaryConcurrentUpdatesOnShardIndexingPressureTrackerObjects() throws Exception {
            int counter = i;
                    rejectionCount.addAndGet(1);  
        assertEquals(shardStoreStats.getCurrentReplicaLimits(), shardStoreStats2.getCurrentReplicaLimits());
        Settings settings = Settings.builder()
        assertEquals(
        // One request being successful
import org.opensearch.core.index.shard.ShardId;
        Settings settings = Settings.builder()
    ) throws Exception {
            (double) (NUM_THREADS * 15) / shardIndexingPressure.shardStats()
    private final ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);  
        assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes() < 50 * 300);
        Index index = new Index("IndexName", "UUID");
import org.opensearch.common.lease.Releasable;  
    public void testCoordinatingPrimaryThreadedUpdateToShardLimitsWithRandomBytes() throws Exception {
    public enum OperationType {
        } else {
                100,
            lessThanOrEqualTo(ShardIndexingPressureMemoryManager.UPPER_OPERATING_FACTOR.get(settings))
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        // Generate a load which breaches both primary parameter
            assertEquals(
        // Generate a load which breaches both primary parameter  
        boolean randomBoolean = randomBoolean();  
            );
                        releasables[counter] = shardIndexingPressure.markPrimaryOperationStarted(shardId1, 200, false);  
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 10, OperationType.PRIMARY);  
            .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
        Index index = new Index("IndexName", "new_uuid");
        ;  
                    .getPrimaryLastSuccessfulRequestLimitsBreachedRejections()  
            0,  
        }
                if (operationType == OperationType.COORDINATING) {
 * this file be licensed under the Apache-2.0 license or a
        long delay,  
            if (releasable != null) {
    private final Settings settings = Settings.builder()
            fireAndCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 100, OperationType.COORDINATING);  
            bytes,
                    releasables[counter] = shardIndexingPressure.markReplicaOperationStarted(shardId1, 300, false);
    }
        // Generate a load which breaches both primary parameter
            expectThrows(  
        ShardId shardId1 = new ShardId(index, 0);
        );  
            assertEquals(
        }
                10,
        final Thread[] threads = new Thread[concurrency];
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits(),
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingRejections());
                    Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, false);
    private void fireAllThenCompleteConcurrentRequestsWithUniformDelay(  
                OpenSearchRejectedExecutionException.class,
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId1, 11 * 1024, false)
            );
            releasables = fireConcurrentRequestsWithUniformDelay(  
                shardIndexingPressure.coldStats()
            assertEquals(
    }  
        );
            shardId,  
            assertEquals(10, shardStoreStats.getCurrentPrimaryAndCoordinatingLimits());  
            greaterThan(ShardIndexingPressureMemoryManager.LOWER_OPERATING_FACTOR.get(settings)),  
            assertEquals(rejectionCount.get(), nodeStats.getCoordinatingRejections());  
        statsFlag.includeOnlyTopIndexingPressureMetrics(false);
    public void testReplicaThreadedSimultaneousUpdateToShardLimits() throws Exception {
import org.hamcrest.Matchers;
        }  
                shardId1,  
        if (randomBoolean) {
            shardId,  
            releasable[i].close();  
        assertTrue(nodeStats.getCurrentReplicaBytes() < 50 * 300);
        assertEquals(
    public void testCoordinatingPrimaryThreadedUpdateToShardLimitsAndRejections() throws Exception {
        final Thread[] threads = new Thread[concurrency];  
        IndexingPressurePerShardStats shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag)
        assertTrue(nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes() < 50 * 200);
        assertEquals(rejectionCount.get(), shardStats.getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
    }  
        Settings settings = Settings.builder()
        assertEquals(  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()  
            assertEquals(
            );
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);  
        }  
                    .getIndexingPressureShardStats(shardId1)
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId1, 340 * 1024, false)
        boolean randomBoolean = randomBoolean();
            threads[i] = new Thread(() -> {
                    replica.close();
        replica.close();
import org.opensearch.common.settings.Settings;
        }
        if (randomBoolean) {
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.COORDINATING);  
        } else {
            NUM_THREADS * 15,  
            .getIndexingPressureShardStats(shardId1);
        // One request being successful
                try {
                OperationType.COORDINATING  
        statsFlag.includeAllShardIndexingPressureTrackers(true);  
        ShardId shardId1 = new ShardId(index, 0);
                1,
        );
                } else {  
        assertEquals(384, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());  
        for (Releasable releasable : releasables) {  
    }
            assertEquals(
            assertEquals(  
        } else {
        }  
        ShardId shardId,  
        boolean randomBoolean = randomBoolean();
                    }
        long delay,  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            });
                for (int j = 0; j < randomIntBetween(400, 500); j++) {  
    public void testReplicaConcurrentUpdatesOnShardIndexingPressureTrackerObjects() throws Exception {  
        );
                        Thread.sleep(delay);
            assertEquals(  
            releasables = fireConcurrentRequestsWithUniformDelay(  
        Index index = new Index("IndexName", "new_uuid");  
        }
            t.join();
        fireAndCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 100, OperationType.REPLICA);  
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
            assertNull(shardStoreStats);
            OpenSearchRejectedExecutionException.class,  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);  
                    .getIndexingPressureShardStats(shardId1)  
            t.join();
                .getReplicaLastSuccessfulRequestLimitsBreachedRejections()
        final int NUM_THREADS = scaledRandomIntBetween(80, 100);
import org.opensearch.test.ClusterServiceUtils;  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
        Index index = new Index("IndexName", "UUID");
        } else {  
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaRejections());  
        Releasable[] releasables;
                    .getPrimaryLastSuccessfulRequestLimitsBreachedRejections()
        assertEquals(
                shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes()
        ShardId shardId1 = new ShardId(index, 0);  
            threads[i] = new Thread(() -> {  
                } else {
                    .getIndexingPressureShardStats(shardId1)
        }
        final Releasable[] releasables = fireConcurrentRequestsWithUniformDelay(
                try {
                    } else {
                10,
        final Thread[] threads = new Thread[concurrency];  
                OpenSearchRejectedExecutionException.class,
        final Releasable[] releasable = new Releasable[concurrency];  
                // Do Nothing
        final Releasable[] releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 10, OperationType.REPLICA);
        );
        Index index = new Index("IndexName", "UUID");
                    .getIndexingPressureShardStats(shardId1)  
        );  
                    .getIndexingPressureShardStats(shardId1)
        assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());  
        if (randomBoolean) {
        statsFlag.includeAllShardIndexingPressureTrackers(false);
                .getIndexingPressureShardStats(shardId1)
        ShardId shardId1 = new ShardId(index, 0);  
            OperationType.COORDINATING
            shardStoreStats2.getCurrentReplicaLimits()
                NUM_THREADS,
            isInOperatingFactorRange()
import org.hamcrest.Matcher;
        assertEquals(
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        final int NUM_THREADS = scaledRandomIntBetween(100, 400);
                    .getPrimaryLastSuccessfulRequestLimitsBreachedRejections()  
        assertEquals(rejectionCount.get(), nodeStats.getReplicaRejections());  
            threads[i] = new Thread(() -> {
            100,
    }
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "250KB")
        ShardId shardId1 = new ShardId(index, 0);  
                .getCurrentReplicaLimits(),
    }
            primary.close();
                .getIndexingPressureShardStats(shardId1)
        assertEquals(384, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        Thread.sleep(randomIntBetween(50, 100));  
    }
        }  
            releasables[i].close();
        .build();  
            assertEquals(rejectionCount.get(), nodeStats.getCoordinatingRejections());
            threads[i] = new Thread(() -> {  
import org.opensearch.index.stats.IndexingPressurePerShardStats;  
                0,
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
                }
        Index index = new Index("IndexName", "UUID");  
        int concurrency,
        final int NUM_THREADS = scaledRandomIntBetween(110, 150);  
            concurrency,
        if (randomBoolean) {
            fireConcurrentAndParallelRequestsForUniformThroughPut(  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
import org.opensearch.common.settings.ClusterSettings;
    ) throws Exception {
        // Mimic the time elapsed after requests being stuck  
        ShardIndexingPressure shardIndexingPressure,  
            assertEquals(  
        if (randomBoolean) {  
        // was updated on the last request. In other cases, the shardStoreStats simply moves to the cold store and null is returned.  
                0,  
        );  
        } else {
                .getReplicaLastSuccessfulRequestLimitsBreachedRejections()  
        ShardId shardId,
        );
                shardIndexingPressure.coldStats()
            .build();  
import static org.hamcrest.Matchers.greaterThan;  
                }  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()  
        shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);  
            assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        }
            delay,
        } else {
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));
 * compatible open source license.
        boolean randomBoolean = randomBoolean();
        shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1);
        assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaRejections());
        } else {
        IndexingPressureStats nodeStats = shardIndexingPressure.stats();
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
        assertEquals(  
            operationType  
        assertNull(shardStoreStats);
    }
        }
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")  
                } else if (operationType == OperationType.PRIMARY) {  
            releasables[i].close();
                NUM_THREADS * 15,
            assertEquals(15, shardStoreStats.getCurrentReplicaLimits());
        } else {  
                shardIndexingPressure.coldStats()  
        OperationType operationType
        Index index = new Index("IndexName", "UUID");
import org.opensearch.index.stats.IndexingPressureStats;
        );
        for (Releasable releasable : releasables) {
            }
        );
                    Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes, false);
        assertNull(shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1));  
        for (int i = 0; i < NUM_THREADS; i++) {
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
    public void testReplicaThreadedUpdateToShardLimitsAndRejections() throws Exception {
        for (int i = 0; i < concurrency; i++) {
        final Releasable[] releasables = new Releasable[NUM_THREADS];
    public void testCoordinatingPrimaryThreadedLastSuccessfulRequestsAndRejection() throws Exception {
            );  
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);  
                    releasable.close();
            10,  
        assertEquals(
            () -> shardIndexingPressure.markReplicaOperationStarted(shardId1, 300 * 1024, false)
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
package org.opensearch.index;
                OpenSearchRejectedExecutionException.class,
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);
        AtomicInteger rejectionCount = new AtomicInteger();  
        } else {
            );  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        if (rejectionCount.get() == NUM_THREADS) {
        assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes());
            Releasable primary = shardIndexingPressure.markPrimaryOperationStarted(shardId1, 10, false);  
            fireAndCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 100, OperationType.PRIMARY);
                    .getIndexingPressureShardStats(shardId1)
                    // Do Nothing
                .getIndexingPressureShardStats(shardId1)  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());  
                OperationType.PRIMARY  
        assertEquals(  
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingRejections());
        Index index = new Index("IndexName", "UUID");
        }
                    .getCoordinatingLastSuccessfulRequestLimitsBreachedRejections()  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        final int NUM_THREADS = scaledRandomIntBetween(110, 150);
        expectThrows(
            releasable[i].close();
        assertNull(shardStoreStats);  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        int concurrency,
        for (int i = 0; i < NUM_THREADS; i++) {
            );
            threads[i].start();
        statsFlag.includeOnlyTopIndexingPressureMetrics(false);
        ShardId shardId,
        }
                OpenSearchRejectedExecutionException.class,  
            256,
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)
            fireConcurrentAndParallelRequestsForUniformThroughPut(  
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
        if (randomBoolean) {  
        for (int i = 0; i < concurrency; i++) {
        // Generating a load to such that the requests in the window shows degradation in throughput.  
            .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 100)
                shardIndexingPressure.coldStats()
        final Releasable[] releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 20, OperationType.REPLICA);  
        // Generating a load to have a fair throughput
            );
        Index index = new Index("IndexName", "UUID");
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());  
            );
        fireConcurrentAndParallelRequestsForUniformThroughPut(  
        }
                    Releasable replica = shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, false);
        final int NUM_THREADS = 100;  
                    Releasable releasable;
        nodeStats = shardIndexingPressure.stats();
        for (Thread t : threads) {  
        boolean randomBoolean = randomBoolean();
                    releasable[counter] = shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes, false);
            releasables = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.PRIMARY);
            assertEquals(
        }
    }
            1,
        } else {
        Index index = new Index("IndexName", "UUID");  
        IndexingPressurePerShardStats shardStoreStats = shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1);  
                    .getPrimaryThroughputDegradationLimitsBreachedRejections()
        int concurrency,
        Index index = new Index("IndexName", "UUID");
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 240 * 1024, false)
                    } else {  
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")  
        for (int i = 0; i < NUM_THREADS; i++) {
        fireAllThenCompleteConcurrentRequestsWithUniformDelay(concurrency, shardIndexingPressure, shardId, bytes, 0, operationType);  
                        releasable = shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes, false);  
                        releasables[counter] = shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 200, false);
            0,
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());  
        ShardIndexingPressureStats shardStats = shardIndexingPressure.shardStats();  
        // was updated on the last request. In other cases, the shardStoreStats simply moves to the cold store and null is returned.
                ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.get(settings),
            expectThrows(  
            10,
import org.opensearch.core.index.Index;
    private final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    coordinating.close();
        final int NUM_THREADS = 100;  
        ShardIndexingPressure shardIndexingPressure,
            shardIndexingPressure,  
                try {
        ShardId shardId1 = new ShardId(index, 0);
        }
                randomIntBetween(50, 100),
        }  
    }
    private void fireAllThenCompleteConcurrentRequests(
            assertEquals(
            });
            threads[i] = new Thread(() -> {
        for (int i = 0; i < NUM_THREADS; i++) {
        if (randomBoolean) {
            assertEquals(
        if (randomBoolean) {
            0,
        int concurrency,  
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
    public void testCoordinatingPrimaryThreadedUpdateToShardLimits() throws Exception {
        if (randomBoolean) {
        assertEquals(  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        Releasable[] releasables;
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingRejections());  
        ShardId shardId1 = new ShardId(index, 0);
        );
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        }
        }  
        assertThat(shardStoreStats.getCurrentReplicaLimits(), Matchers.greaterThan(100L));  
        ShardId shardId1 = new ShardId(index, 0);  
        COORDINATING,  
            );  
            (double) (NUM_THREADS * 15) / shardIndexingPressure.shardStats()
    public void testReplicaThreadedLastSuccessfulRequestsAndRejection() throws Exception {  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections()  
                    .getIndexingPressureShardStats(shardId1)
            shardIndexingPressure.coldStats()  
        for (int i = 0; i < NUM_THREADS; i++) {
            shardIndexingPressure,  
            shardIndexingPressure,
            try {
        );
                shardIndexingPressure,
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId1, 240 * 1024, false)
                randomIntBetween(50, 100),
                    } catch (Exception e) {
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)  
        IndexingPressurePerShardStats shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag)
    ) throws Exception {
            );
            expectThrows(
            .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
            assertEquals(
        ShardIndexingPressure shardIndexingPressure,  
    }  
                        // Do Nothing  
        assertNull(shardStoreStats);
        if (rejectionCount.get() == NUM_THREADS) {
            expectThrows(
        );  
        Index index = new Index("IndexName", "UUID");  
                        releasable = shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, false);
            bytes,
                }  
                .getIndexingPressureShardStats(shardId1)  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getReplicaNodeLimitsBreachedRejections());
            shardIndexingPressure.coldStats()
        );
            shardIndexingPressure.coldStats()
                shardId1,  
            );
        );
    }  
        Index index = new Index("IndexName", "UUID");
/*  
            );
        }  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        } else {
        // Generating a load such that requests are blocked requests.  
import static org.hamcrest.Matchers.allOf;
        assertEquals(15, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaLimits());
    }
            });
                200,
        if (randomBoolean) {  
                    releasable[counter] = shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, false);
            });
            fireAllThenCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.PRIMARY);  
        fireAllThenCompleteConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.REPLICA);
            releasable = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.PRIMARY);  
                0,  
        ShardId shardId1 = new ShardId(index, 0);
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
        );
            isInOperatingFactorRange()
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
            coordinating.close();
                shardIndexingPressure,
        assertEquals(0, nodeStats.getCurrentReplicaBytes());
        long bytes,
        long bytes,
        // Generating a load to such that the requests in the window shows degradation in throughput.  
        ShardIndexingPressureStats shardStats = shardIndexingPressure.shardStats();
            t.join();
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
        if (randomBoolean) {
    ) throws Exception {
        for (int i = 0; i < NUM_THREADS; i++) {
        OperationType operationType
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes()
        }
        assertNull(shardStoreStats);  
        assertTrue(shardStats.getIndexingPressureShardStats(shardId1).getCurrentCombinedCoordinatingAndPrimaryBytes() < 50 * 200);
                shardIndexingPressure.coldStats()  
                1,
            assertEquals(  
                100,
            0,
            );  
    private Matcher<Double> isInOperatingFactorRange() {
        );
            threads[i].start();
        REPLICA
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "15KB")
        }  
        } else {
                shardStats.getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()  
                OperationType.PRIMARY  
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        int concurrency,
            256,
                    try {  
        boolean randomBoolean = randomBoolean();
            releasable[i].close();  
            shardId1,  
        );  
            );
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        ShardIndexingPressure shardIndexingPressure,
            1,
        assertEquals(0, nodeStats.getCurrentCombinedCoordinatingAndPrimaryBytes());  
            releasable = fireConcurrentRequests(NUM_THREADS, shardIndexingPressure, shardId1, 15, OperationType.COORDINATING);
                .getReplicaThroughputDegradationLimitsBreachedRejections()
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
        final Releasable[] releasables = new Releasable[NUM_THREADS];
        AtomicInteger rejectionCount = new AtomicInteger();  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            .build();  
    }
        assertEquals(NUM_THREADS * 15, shardIndexingPressure.shardStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());  
            expectThrows(
            );  
        OperationType operationType  
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        );
            .build();  
            );
            assertEquals(0, shardStats.getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());  
        for (int i = 0; i < NUM_THREADS; i++) {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                100,
                () -> shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 11 * 1024, false)
                OpenSearchRejectedExecutionException.class,  
            shardId1,
        ShardIndexingPressure shardIndexingPressure,
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());
        OperationType operationType  
        assertEquals(
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentCoordinatingBytes());  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
                    .getPrimaryThroughputDegradationLimitsBreachedRejections()
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()
            shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryAndCoordinatingLimits()  
        assertEquals(  
        statsFlag.includeAllShardIndexingPressureTrackers(true);  
        assertEquals(rejectionCount.get(), nodeStats.getReplicaRejections());
            assertEquals(
        }
            concurrency,
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryRejections());  
            assertEquals(1, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryRejections());
            randomIntBetween(5, 15),
            shardIndexingPressure.coldStats()
            }  
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCoordinatingNodeLimitsBreachedRejections()
        for (Thread t : threads) {
        long delay,
        PRIMARY,
        fireAndCompleteConcurrentRequestsWithUniformDelay(  
        long bytes,  
        // No object in host store as no active shards
        shardStoreStats2 = shardIndexingPressure.shardStats(statsFlag).getIndexingPressureShardStats(shardId1);  
        );
        );
    private void fireConcurrentAndParallelRequestsForUniformThroughPut(
                shardIndexingPressure.coldStats()
            .put(ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS.getKey(), 1)  
            threads[i].start();
        ShardId shardId1 = new ShardId(index, 0);
        statsFlag.includeAllShardIndexingPressureTrackers(false);
        final Thread[] threads = new Thread[NUM_THREADS];
        } else {  
        // Generate a load which breaches both primary parameter
    ) throws Exception {
    public void testReplicaThreadedUpdateToShardLimitsWithRandomBytes() throws Exception {  
    public void testReplicaThreadedThroughputDegradationAndRejection() throws Exception {
            releasables[i].close();
        final int NUM_THREADS = scaledRandomIntBetween(100, 150);  
        fireAllThenCompleteConcurrentRequestsWithUniformDelay(
        }
                0,  
            );  
                shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getPrimaryNodeLimitsBreachedRejections()
            int counter = i;  
            }  
        assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentReplicaBytes());
        assertEquals(
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
                shardIndexingPressure.coldStats()
                } catch (Exception e) {
    }
        assertEquals(
        final int NUM_THREADS = scaledRandomIntBetween(100, 500);  
            Releasable coordinating = shardIndexingPressure.markCoordinatingOperationStarted(shardId1, 10, false);  
        Index index = new Index("IndexName", "UUID");
                .getReplicaLastSuccessfulRequestLimitsBreachedRejections()  
                () -> shardIndexingPressure.markPrimaryOperationStarted(shardId1, 200 * 1024, false)  
            assertEquals(0, shardIndexingPressure.coldStats().getIndexingPressureShardStats(shardId1).getCurrentPrimaryBytes());
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        assertEquals(  
        for (Thread t : threads) {
        }
                NUM_THREADS,
        if (randomBoolean) {  
        OperationType operationType
        ShardIndexingPressure shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);
        }
