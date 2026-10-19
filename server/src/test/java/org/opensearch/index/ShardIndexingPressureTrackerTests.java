        assertEquals(0L, rejectionTracker.getLastSuccessfulRequestLimitsBreachedRejections());  
        assertEquals(0L, statsTracker.getTotalBytes());
import org.opensearch.core.index.shard.ShardId;
        assertEquals(0L, rejectionTracker.getThroughputDegradationLimitsBreachedRejections());
        assertEquals(0L, statsTracker.getRequestCount());  
    private void assertStatsTracker(StatsTracker statsTracker) {  
/*  
public class ShardIndexingPressureTrackerTests extends OpenSearchTestCase {  
        OperationTracker replicaTracker = shardIndexingPressureTracker.getReplicaOperationTracker();
 * SPDX-License-Identifier: Apache-2.0
        CommonOperationTracker commonOperationTracker = shardIndexingPressureTracker.getCommonOperationTracker();
        assertStatsTracker(coordinatingTracker.getStatsTracker());
        assertEquals(0L, statsTracker.getCurrentBytes());
        assertEquals(100L, shardIndexingPressureTracker.getPrimaryAndCoordinatingLimits());
        assertEquals(1L, performanceTracker.getThroughputMovingQueueSize());
        assertStatsTracker(primaryTracker.getStatsTracker());
        assertRejectionTracker(replicaTracker.getRejectionTracker());
        assertEquals(0L, performanceTracker.getLastSuccessfulRequestTimestamp());  
 * compatible open source license.
        assertEquals(0L, performanceTracker.getThroughputMovingAverage());
        assertPerformanceTracker(coordinatingTracker.getPerformanceTracker());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.ShardIndexingPressureTracker.OperationTracker;  
        assertTrue(performanceTracker.addNewThroughout(10.0));  
 */  
        assertEquals(shardId, shardIndexingPressureTracker.getShardId());  
        assertEquals(0L, commonOperationTracker.getTotalCombinedCoordinatingAndPrimaryBytes());  
        assertEquals(150L, shardIndexingPressureTracker.getReplicaLimits());
        assertStatsTracker(replicaTracker.getStatsTracker());  
}
        assertRejectionTracker(primaryTracker.getRejectionTracker());
    private void assertRejectionTracker(RejectionTracker rejectionTracker) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.ShardIndexingPressureTracker.PerformanceTracker;
    }
import org.opensearch.index.ShardIndexingPressureTracker.RejectionTracker;
        assertEquals(0L, rejectionTracker.getTotalRejections());
        assertEquals(0L, commonOperationTracker.getCurrentCombinedCoordinatingAndPrimaryBytes());
        OperationTracker coordinatingTracker = shardIndexingPressureTracker.getCoordinatingOperationTracker();
import org.opensearch.index.ShardIndexingPressureTracker.StatsTracker;  
        assertPerformanceTracker(primaryTracker.getPerformanceTracker());  
        assertEquals(0L, performanceTracker.getThroughputMovingQueueSize());  
    }
        OperationTracker primaryTracker = shardIndexingPressureTracker.getPrimaryOperationTracker();  
        ShardId shardId = new ShardId("index", "uuid", 0);  
    public void testShardIndexingPressureTracker() {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0L, rejectionTracker.getNodeLimitsBreachedRejections());
        assertEquals(0L, performanceTracker.getLatencyInMillis());
        assertPerformanceTracker(replicaTracker.getPerformanceTracker());
    }
    }
import org.opensearch.index.ShardIndexingPressureTracker.CommonOperationTracker;
    private void assertPerformanceTracker(PerformanceTracker performanceTracker) {
package org.opensearch.index;
 *
        assertEquals(10.0, performanceTracker.getFirstThroughput(), 0.0);
        assertEquals(0L, performanceTracker.getTotalOutstandingRequests());
        ShardIndexingPressureTracker shardIndexingPressureTracker = new ShardIndexingPressureTracker(shardId, 100L, 150L);
        assertRejectionTracker(coordinatingTracker.getRejectionTracker());  
