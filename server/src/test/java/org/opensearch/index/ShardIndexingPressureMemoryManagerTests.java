        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
    public void testDecreaseShardReplicaLimitsToBaseLimit() {
        tracker1.compareAndSetPrimaryAndCoordinatingLimits(tracker1.getPrimaryAndCoordinatingLimits(), 1 * 1024);
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
        assertEquals(0, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
    }
        );
        assertEquals(1, memoryManager.getTotalNodeLimitsBreachedRejections());
        tracker1.getCoordinatingOperationTracker().getStatsTracker().incrementTotalBytes(60);
        assertEquals(
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
    public void testCoordinatingNodeLevelBreach() {
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        settings
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
    }
        assertEquals(1, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ClusterServiceUtils.createClusterService(settings, clusterSettings, null),
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        long delay = TimeUnit.MILLISECONDS.toNanos(100);
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        long requestStartTime = System.nanoTime();
    public void testReplicaShardLimitsSoftLimitBreachedAndMovingAverageQueueNotBuildUpAndNThroughputDegradationLimitRejections() {
            0,
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        long requestStartTime = System.nanoTime();
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() > limit1);
        assertEquals(tracker.getPrimaryAndCoordinatingLimits(), (long) (baseLimit / 0.85));
        long requestStartTime = System.nanoTime();
        assertFalse(memoryManager.isReplicaNodeLimitBreached(tracker, 1 * 1024));
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        );
        assertEquals(limit2, tracker2.getReplicaLimits());
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(
    public void testReplicaShardLimitsNotBreached() {
        long requestStartTime = System.nanoTime();
        long requestStartTime = System.nanoTime();
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
    public void testReplicaShardLimitsSoftLimitBreachedAndLessOutstandingRequestsAndNoLastSuccessfulRequestLimitRejections() {
        memoryManager.decreaseShardReplicaLimits(tracker1);
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        tracker1.compareAndSetReplicaLimits(tracker1.getReplicaLimits(), 1 * 1024);
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(15, tracker1.getReplicaLimits());
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
    private final ShardIndexingPressureMemoryManager memoryManager = new ShardIndexingPressureMemoryManager(
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
    public void testCoordinatingPrimarySoftLimitBreachedAndMovingAverageQueueNotBuildUpAndNoThroughputDegradationLimitRejections() {
        long limit2 = tracker2.getReplicaLimits();
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
            0,
    public void testReplicaShardLimitsSoftLimitBreachedAndLastSuccessfulRequestLimitRejections() {
        long requestStartTime = System.nanoTime();
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());
        assertEquals(tracker.getReplicaLimits(), (long) (baseLimit / 0.85));
}
 */
    }
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertEquals(2, memoryManager.getTotalNodeLimitsBreachedRejections());
        long limit1 = tracker1.getReplicaLimits();
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        long requestStartTime = System.nanoTime();
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(0);
    private final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
    public void testDecreaseShardPrimaryAndCoordinatingLimitsToBaseLimit() {
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        long limit2 = tracker2.getReplicaLimits();
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() > limit1);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(2d);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
    }
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        long limit1 = tracker1.getReplicaLimits();
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(limit2, tracker2.getReplicaLimits());
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker1.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(60);
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        assertEquals(2, memoryManager.getTotalNodeLimitsBreachedRejections());
        long requestStartTime = System.nanoTime();
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
 * The OpenSearch Contributors require contributions made to
        tracker1.compareAndSetReplicaLimits(tracker1.getReplicaLimits(), 1 * 1024);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
    }
        shardIndexingPressureSettings,
 * compatible open source license.
        );
        assertEquals(0, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(1, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
    public void testCoordinatingPrimarySoftLimitBreachedAndNoSecondaryParameterBreachedAndNodeLevelRejections() {
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        long limit1 = tracker1.getReplicaLimits();
        assertTrue(tracker.getReplicaLimits() > baseLimit);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker, 1 * 1024, requestStartTime));
    public void testReplicaShardLimitsSoftLimitNotBreachedAndNodeLevelRejections() {
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(1d);
package org.opensearch.index;
    }
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
        long requestStartTime = System.nanoTime();
        tracker1.getCoordinatingOperationTracker().getStatsTracker().incrementTotalBytes(60);
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(60);
        assertEquals(10, tracker1.getPrimaryAndCoordinatingLimits());
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
    public void testReplicaShardLimitsSoftLimitBreachedAndNodeLevelRejections() {
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(2d);
        long limit1 = tracker1.getReplicaLimits();
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        long limit1 = tracker1.getReplicaLimits();
    private final ShardId shardId1 = new ShardId(index, 0);
    public void testCoordinatingPrimaryShardLimitsIncreasedAndSoftLimitNotBreached() {
        assertEquals(limit1, tracker1.getReplicaLimits());
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        assertEquals(0, tracker1.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        assertEquals((long) (1 * 1024 / 0.85), tracker1.getPrimaryAndCoordinatingLimits());
    }
    }
        assertEquals(limit1, tracker1.getReplicaLimits());
        assertEquals(2, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
import org.opensearch.core.index.shard.ShardId;
        assertTrue(memoryManager.isCoordinatingNodeLimitBreached(tracker, 11 * 1024));
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 10 * 1024, requestStartTime));
        assertEquals(
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(0);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
    }
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(0, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        long requestStartTime = System.nanoTime();
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        memoryManager.decreaseShardReplicaLimits(tracker1);
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertEquals((long) (2 * 1024 / 0.85), tracker1.getReplicaLimits());
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
public class ShardIndexingPressureMemoryManagerTests extends OpenSearchTestCase {
    public void testReplicaShardLimitsSoftLimitBreachedAndNoSecondaryParameterBreachedAndNodeLevelRejections() {
            0,
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        assertEquals((long) (2 * 1024 / 0.85), tracker1.getReplicaLimits());
        assertEquals(
        assertEquals(
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - delay);
    }
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        );
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(2d);
        assertEquals((long) (512 / 0.85), tracker1.getPrimaryAndCoordinatingLimits());
        long delay = TimeUnit.MILLISECONDS.toNanos(100);
        assertEquals(limit1, tracker1.getReplicaLimits());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        assertTrue(tracker1.getReplicaLimits() < limit1);
    }
    }
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 12 * 1024);
    private final Settings settings = Settings.builder()
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
import org.opensearch.core.index.Index;
    }
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        long limit2 = tracker2.getReplicaLimits();
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        assertEquals(2, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
        assertEquals(0, tracker1.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
 * this file be licensed under the Apache-2.0 license or a
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
    }
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(1d);
    }
    }
    public void testCoordinatingPrimarySoftLimitBreachedAndThroughputDegradationLimitRejections() {
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(1, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(1 * 1024);
    private final Index index = new Index("IndexName", "UUID");
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() < limit1);
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
            0,
    public void testReplicaShardLimitsSoftLimitBreachedAndThroughputDegradationLimitRejections() {
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals(0, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
    );
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        assertEquals(1, memoryManager.getTotalNodeLimitsBreachedRejections());
        );
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        assertEquals(0, tracker1.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        long requestStartTime = System.nanoTime();
        clusterSettings,
        assertEquals(
        assertEquals(1, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertFalse(memoryManager.isCoordinatingNodeLimitBreached(tracker, 1 * 1024));
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertEquals(0, memoryManager.getTotalThroughputDegradationLimitsBreachedRejections());
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        long limit2 = tracker2.getReplicaLimits();
        tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(1);
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        long requestStartTime = System.nanoTime();
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
import org.opensearch.common.settings.ClusterSettings;
    public void testCoordinatingPrimarySoftLimitBreachedAndLastSuccessfulRequestLimitRejections() {
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(4 * 1024);
        long limit1 = tracker1.getReplicaLimits();
        settings,
        long limit1 = tracker1.getReplicaLimits();
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()
            1,
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementTotalBytes(80);
        memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker1);
    );
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        assertEquals((long) (512 / 0.85), tracker1.getReplicaLimits());
    }
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        assertEquals(0, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
    public void testDecreaseShardReplicaLimits() {
        long baseLimit = tracker.getPrimaryAndCoordinatingLimits();
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
    }
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        long limit2 = tracker2.getReplicaLimits();
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
    public void testReplicaNodeLevelBreach() {
        assertEquals(0, tracker1.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - delay);
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(512);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        .build();
        long limit2 = tracker2.getReplicaLimits();
        assertTrue(tracker1.getReplicaLimits() > limit1);
        assertEquals(limit2, tracker2.getReplicaLimits());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker1);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementTotalBytes(80);
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        tracker1.getReplicaOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
    public void testCoordinatingPrimarySoftLimitBreachedAndLessOutstandingRequestsAndNoLastSuccessfulRequestLimitRejections() {
    }
    }
        assertTrue(tracker1.getReplicaLimits() > limit1);
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertFalse(memoryManager.isCoordinatingShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        long requestStartTime = System.nanoTime();
        assertTrue(tracker1.getReplicaLimits() < limit1);
        assertEquals(0, tracker2.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
        tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(15);
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
    public void testCoordinatingPrimarySoftLimitBreachedAndNodeLevelRejections() {
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        long limit1 = tracker1.getReplicaLimits();
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        long requestStartTime = System.nanoTime();
        assertEquals(0, tracker2.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
import org.opensearch.test.ClusterServiceUtils;
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        assertTrue(memoryManager.isPrimaryNodeLimitBreached(tracker, 11 * 1024));
        long limit1 = tracker1.getReplicaLimits();
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        long baseLimit = tracker.getReplicaLimits();
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().addNewThroughout(1d);
        assertEquals(1, memoryManager.getTotalNodeLimitsBreachedRejections());
        assertEquals(limit1, tracker1.getReplicaLimits());
        assertFalse(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        assertEquals(
        tracker1.getCoordinatingOperationTracker().getStatsTracker().incrementTotalBytes(60);
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        assertEquals(0, memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections());
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(1);
    }
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
        long requestStartTime = System.nanoTime();
/*
        assertEquals(limit1, tracker1.getReplicaLimits());
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertTrue(memoryManager.isPrimaryShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        assertFalse(memoryManager.isPrimaryShardLimitBreached(tracker, 1 * 1024, requestStartTime));
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());
        long requestStartTime = System.nanoTime();
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertEquals(1, tracker1.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker2.compareAndSetPrimaryAndCoordinatingLimits(tracker2.getPrimaryAndCoordinatingLimits(), 6 * 1024);
    public void testCoordinatingPrimaryShardLimitsNotBreached() {
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(2 * 1024);
    public void testPrimaryNodeLevelBreach() {
        assertTrue(memoryManager.isCoordinatingShardLimitBreached(tracker1, 8 * 1024, requestStartTime));
        long limit1 = tracker1.getPrimaryAndCoordinatingLimits();
        long requestStartTime = System.nanoTime();
        IndexingPressure.MAX_INDEXING_BYTES.get(settings).getBytes()
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(1 * 1024);
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(5 * 1024);
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - 100);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
    }
            tracker1.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()
        assertTrue(tracker.getPrimaryAndCoordinatingLimits() > baseLimit);
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 2)
        tracker1.compareAndSetPrimaryAndCoordinatingLimits(tracker1.getPrimaryAndCoordinatingLimits(), 1 * 1024);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - 100);
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        assertTrue(memoryManager.isReplicaNodeLimitBreached(tracker, 16 * 1024));
    private final ShardId shardId2 = new ShardId(index, 1);
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(2 * 1024);
        assertFalse(memoryManager.isPrimaryNodeLimitBreached(tracker, 1 * 1024));
        assertEquals((long) (1 * 1024 / 0.85), tracker1.getPrimaryAndCoordinatingLimits());
        assertEquals(2, memoryManager.getTotalNodeLimitsBreachedRejections());
    public void testReplicaShardLimitsIncreasedAndSoftLimitNotBreached() {
import org.opensearch.common.settings.Settings;
 *
    private final ShardIndexingPressureSettings shardIndexingPressureSettings = new ShardIndexingPressureSettings(
        ShardIndexingPressureTracker tracker1 = memoryManager.getShardIndexingPressureTracker(shardId1);
    }
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addLatencyInMillis(10);
        assertTrue(tracker1.getPrimaryAndCoordinatingLimits() < limit1);
        long requestStartTime = System.nanoTime();
        tracker2.compareAndSetReplicaLimits(tracker2.getReplicaLimits(), 10 * 1024);
        assertEquals(0, tracker2.getCoordinatingOperationTracker().getRejectionTracker().getNodeLimitsBreachedRejections());
        tracker1.getReplicaOperationTracker().getStatsTracker().incrementTotalBytes(80);
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()
            0,
            1,
        tracker1.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(512);
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
    public void testDecreaseShardPrimaryAndCoordinatingLimits() {
        tracker1.getReplicaOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - 100);
import java.util.concurrent.TimeUnit;
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()
    }
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
        tracker1.getReplicaOperationTracker().getPerformanceTracker().incrementTotalOutstandingRequests();
            0,
        tracker1.getCoordinatingOperationTracker().getPerformanceTracker().addNewThroughout(1d);
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections()
        assertEquals(1, tracker1.getPrimaryOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections());
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(memoryManager.isReplicaShardLimitBreached(tracker1, 12 * 1024, requestStartTime));
        );
        tracker1.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(60);
    }
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateLastSuccessfulRequestTimestamp(requestStartTime - delay);
            tracker2.getCoordinatingOperationTracker().getRejectionTracker().getLastSuccessfulRequestLimitsBreachedRejections()
        assertEquals(limit2, tracker2.getReplicaLimits());
        assertEquals(limit2, tracker2.getPrimaryAndCoordinatingLimits());
        long limit2 = tracker2.getPrimaryAndCoordinatingLimits();
        long limit2 = tracker2.getReplicaLimits();
        assertEquals(limit1, tracker1.getPrimaryAndCoordinatingLimits());
        ShardIndexingPressureTracker tracker2 = memoryManager.getShardIndexingPressureTracker(shardId2);
        tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(10);
        tracker1.getPrimaryOperationTracker().getPerformanceTracker().updateThroughputMovingAverage(Double.doubleToLongBits(1d));
        );
        assertEquals(1, tracker1.getReplicaOperationTracker().getRejectionTracker().getThroughputDegradationLimitsBreachedRejections());
        ShardIndexingPressureTracker tracker = memoryManager.getShardIndexingPressureTracker(shardId1);
    public void testCoordinatingPrimarySoftLimitNotBreachedAndNodeLevelRejections() {
