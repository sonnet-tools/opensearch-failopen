    }  
    }  
        assertEquals(
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(1d);  
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - 100);  
    public void testReplicaShardLimitsSoftLimitBreachedAndThroughputDegradationLimitRejections() {
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        tracker1.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(60);
        long requestStartTime = System.nanoTime();
        assertFalse(memoryManager.isPrimaryNodeLimitBreached(tracker, 1 * 1024));  
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);  
    }
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()  
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));  
        assertEquals(  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();  
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(1 * 1024);
        memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker1);
        assertEquals((long) (1 * 1024 / 0.85), tracker1.getPrimaryAndCoordinatingLimits());
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
    }  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);  
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - delay);
    }  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        memoryManager.decreaseShardReplicaLimits(tracker1);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(2d);  
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
            0,
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
    public void testCoordinatingPrimarySoftLimitBreachedAndLessOutstandingRequestsAndNoLastSuccessfulRequestLimitRejections() {
        assertEquals(1, memoryManager.getTotalNodeLimitsBreachedRejections());
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()
 * SPDX-License-Identifier: Apache-2.0
        memoryManager.decreaseShardReplicaLimits(tracker1);  
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
    public void testReplicaShardLimitsSoftLimitBreachedAndNodeLevelRejections() {
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        long limit1 = tracker1.getReplicaLimits();
    }
    }  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        assertEquals(
    public void testReplicaShardLimitsIncreasedAndSoftLimitNotBreached() {
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
    }
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertTrue(memoryManager.isReplicaNodeLimitBreached(tracker, 16 * 1024));
        assertEquals(limit2, tracker2.getReplicaLimits());
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
    public void testReplicaShardLimitsSoftLimitBreachedAndLastSuccessfulRequestLimitRejections() {
        long requestStartTime = System.nanoTime();  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        long limit2 = tracker2.getReplicaLimits();
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);  
        long limit2 = tracker2.getReplicaLimits();  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        assertEquals((long) (512 / 0.85), tracker1.getReplicaLimits());
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 2)
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.compareAndSetPrimaryAndCoordinatingLimits(tracker1.getPrimaryAndCoordinatingLimits(), 1 * 1024);  
    private final Index index = new Index("IndexName", "UUID");
        );  
        assertEquals(limit1, tracker1.getReplicaLimits());  
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
    public void testCoordinatingPrimaryShardLimitsNotBreached() {
        tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(1);
        tracker1.compareAndSetPrimaryAndCoordinatingLimits(tracker1.getPrimaryAndCoordinatingLimits(), 1 * 1024);
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(0, tracker1.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());  
        assertEquals(limit1, tracker1.getReplicaLimits());
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
    public void testReplicaShardLimitsNotBreached() {
        tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(15);
        assertEquals((long) (1 * 1024 / 0.85), tracker1.getPrimaryAndCoordinatingLimits());  
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
    }  
            0,
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - 100);  
import org.opensearch.common.settings.Settings;
        assertFalse(memoryManager.isCoordinatingNodeLimitBreached(tracker, 1 * 1024));
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")  
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);  
            0,  
        long requestStartTime = System.nanoTime();
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(tracker.getReplicaLimits(), (long) (baseLimit / 0.85));
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
    public void testCoordinatingNodeLevelBreach() {
        long requestStartTime = System.nanoTime();
        assertEquals(0, tracker1.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - 100);
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);  
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(0, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
    }
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(1d);  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
    );  
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(512);  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
            1,
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
    }  
        assertEquals((long) (512 / 0.85), tracker1.getPrimaryAndCoordinatingLimits());
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));  
    public void testDecreaseShardReplicaLimitsToBaseLimit() {  
        );  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() < limit1);
        tracker1.getCoordinatingOperationTracker().getStatsTracker().incrementTotalBytes(60);
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(2, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
    public void testDecreaseShardPrimaryAndCoordinatingLimitsToBaseLimit() {
        assertTrue(tracker1.getReplicaLimits() > limit1);
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
        assertEquals(0, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
            0,
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));  
import org.opensearch.common.settings.ClusterSettings;
        tracker1.getCoordinatingOperationTracker().getStatsTracker().incrementTotalBytes(60);  
        assertEquals(limit2, tracker2.getReplicaLimits());
 * The OpenSearch Contributors require contributions made to  
        long requestStartTime = System.nanoTime();  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
    }  
    }  
        assertEquals(1, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
        tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(1);
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);  
        );
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);  
    }  
import org.opensearch.test.ClusterServiceUtils;
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(1d);  
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());
        long limit1 = tracker1.getReplicaLimits();
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        long requestStartTime = System.nanoTime();
        assertEquals(  
        assertEquals((long) (2 * 1024 / 0.85), tracker1.getReplicaLimits());
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() > limit1);
        long delay = TimeUnit.MILLISECONDS.toNanos(100);
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
        assertTrue(tracker1.getReplicaLimits() > limit1);
        .build();
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(2 * 1024);
        assertEquals(1, memoryManager.getTotalNodeLimitsBreachedRejections());
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(2 * 1024);
        long requestStartTime = System.nanoTime();
        assertEquals(15, tracker1.getReplicaLimits());  
import org.opensearch.core.index.Index;  
    public void testReplicaShardLimitsSoftLimitNotBreachedAndNodeLevelRejections() {
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);  
    private final ShardIndexingPressureMemoryManager memoryManager = new ShardIndexingPressureMemoryManager(
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(0);
    public void testReplicaShardLimitsSoftLimitBreachedAndLessOutstandingRequestsAndNoLastSuccessfulRequestLimitRejections() {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(10);  
        assertEquals(0, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        assertEquals(0, tracker1.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
    private final Settings settings = Settings.builder()  
        clusterSettings,
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);  
    }  
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() < limit1);
    public void testDecreaseShardPrimaryAndCoordinatingLimits() {  
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
    private final ShardId shardId1 = new ShardId(index, 0);
        assertEquals(1, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
        assertEquals((long) (2 * 1024 / 0.85), tracker1.getReplicaLimits());  
        long limit2 = tracker2.getReplicaLimits();
        assertEquals(1, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
    private final ShardId shardId2 = new ShardId(index, 1);  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementTotalBytes(80);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        long limit2 = tracker2.getReplicaLimits();
        assertEquals(
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(0);
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertEquals(1, memoryManager.getTotalNodeLimitsBreachedRejections());
        long requestStartTime = System.nanoTime();  
        assertEquals(0, tracker1.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());  
    public void testReplicaShardLimitsSoftLimitBreachedAndNoSecondaryParameterBreachedAndNodeLevelRejections() {  
    public void testCoordinatingPrimarySoftLimitBreachedAndLastSuccessfulRequestLimitRejections() {
        assertFalse(memoryManager.isReplicaNodeLimitBreached(tracker, 1 * 1024));
        assertEquals(10, tracker1.getPrimaryAndCoordinatingLimits());  
        assertTrue(tracker1.getReplicaLimits() < limit1);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
import java.util.concurrent.TimeUnit;
        assertTrue(memoryManager.isCoordinatingNodeLimitBreached(tracker, 11 * 1024));  
        shardIndexingPressureSettings,  
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()
    public void testCoordinatingPrimarySoftLimitBreachedAndMovingAverageQueueNotBuildUpAndNoThroughputDegradationLimitRejections() {
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        long requestStartTime = System.nanoTime();  
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);  
    private final ShardIndexingPressureSettings shardIndexingPressureSettings = new ShardIndexingPressureSettings(
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()
        assertEquals(0, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - delay);
}
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));  
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
    }
    public void testReplicaShardLimitsSoftLimitBreachedAndMovingAverageQueueNotBuildUpAndNThroughputDegradationLimitRejections() {
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertTrue(tracker1.getReplicaLimits() < limit1);
        tracker1.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(60);
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        assertEquals(0, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()  
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()  
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
            1,
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());  
        assertEquals(0, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(1 * 1024);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
    public void testReplicaNodeLevelBreach() {
        assertEquals(tracker.getPrimaryAndCoordinatingLimits(), (long) (baseLimit / 0.85));
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertEquals(  
    public void testCoordinatingPrimarySoftLimitBreachedAndNodeLevelRejections() {
        tracker1.compareAndSetReplicaLimits(tracker1.getReplicaLimits(), 1 * 1024);
    }
        long limit1 = tracker1.getReplicaLimits();
    private final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        long limit1 = tracker1.getReplicaLimits();  
        long requestStartTime = System.nanoTime();  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));  
        memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker1);  
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));  
        settings
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        long limit1 = tracker1.getReplicaLimits();
        ClusterServiceUtils.createClusterService(settings, clusterSettings, null),
        long limit1 = tracker1.getReplicaLimits();
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 10 * 1024);  
    }  
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        assertEquals(limit1, tracker1.getReplicaLimits());
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);  
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        IndexingPressure.MAX_INDEXING_BYTES.get(settings).getBytes()
 *
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
            0,
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();  
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
    }
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
    }
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()
        );  
    }  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertEquals(2, memoryManager.getTotalNodeLimitsBreachedRejections());
        long requestStartTime = System.nanoTime();
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        long limit2 = tracker2.getReplicaLimits();
        assertEquals(1, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
    public void testDecreaseShardReplicaLimits() {
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(1d);  
        );
        assertEquals(2, memoryManager.getTotalNodeLimitsBreachedRejections());
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());  
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 10 * 1024, requestStartTime));
        long delay = TimeUnit.MILLISECONDS.toNanos(100);  
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(limit2, tracker2.getReplicaLimits());  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        long limit1 = tracker1.getReplicaLimits();
        long requestStartTime = System.nanoTime();  
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
package org.opensearch.index;
        assertEquals(limit1, tracker1.getReplicaLimits());  
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);  
public class ShardIndexingPressureMemoryManagerTests extends OpenSearchTestCase {
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);  
        assertEquals(limit1, tracker1.getReplicaLimits());  
        long baseLimit = tracker.getPrimaryAndCoordinatingLimits();
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        assertTrue(tracker.getReplicaLimits() > baseLimit);  
        );
        assertTrue(memoryManager.isPrimaryNodeLimitBreached(tracker, 11 * 1024));
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(2d);  
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
    }
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
    }
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);  
        long limit1 = tracker1.getReplicaLimits();
        long requestStartTime = System.nanoTime();
        settings,  
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();  
    public void testCoordinatingPrimarySoftLimitNotBreachedAndNodeLevelRejections() {
        assertEquals(0, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
    }
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(
        assertEquals(2, memoryManager.getTotalNodeLimitsBreachedRejections());  
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        long limit2 = tracker2.getReplicaLimits();
        assertEquals(1, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);  
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementTotalBytes(80);
 */  
import org.opensearch.core.index.shard.ShardId;
            0,
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() > limit1);
    public void testCoordinatingPrimarySoftLimitBreachedAndThroughputDegradationLimitRejections() {  
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
    public void testPrimaryNodeLevelBreach() {  
        tracker1.getCoordinatingOperationTracker().getStatsTracker().incrementTotalBytes(60);
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(2d);
        tracker1.compareAndSetReplicaLimits(tracker1.getReplicaLimits(), 1 * 1024);  
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(512);  
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));  
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());  
        assertEquals(limit2, tracker2.getReplicaLimits());
        long requestStartTime = System.nanoTime();
        );
        long requestStartTime = System.nanoTime();  
/*  
    }
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        long requestStartTime = System.nanoTime();  
        tracker1.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(60);  
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - delay);
    public void testCoordinatingPrimaryShardLimitsIncreasedAndSoftLimitNotBreached() {
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));  
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementTotalBytes(80);  
        long baseLimit = tracker.getReplicaLimits();
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(1d);
    public void testCoordinatingPrimarySoftLimitBreachedAndNoSecondaryParameterBreachedAndNodeLevelRejections() {
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
    );
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addLatencyInMillis(10);  
        assertTrue(tracker.getPrimaryAndCoordinatingLimits() > baseLimit);
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        long limit1 = tracker1.getReplicaLimits();
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        long requestStartTime = System.nanoTime();  
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(1d);  
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        long limit2 = tracker2.getReplicaLimits();
        );
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);  
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()  
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();  
 * compatible open source license.
        long requestStartTime = System.nanoTime();
        assertEquals(2, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
