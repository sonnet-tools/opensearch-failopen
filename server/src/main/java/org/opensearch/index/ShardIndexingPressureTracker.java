    public CommonOperationTracker getCommonOperationTracker() {
        private final AtomicLong totalBytes = new AtomicLong();
        public long getThroughputMovingQueueSize() {
        private final AtomicLong requestCount = new AtomicLong();  
            return lastSuccessfulRequestLimitsBreachedRejections.incrementAndGet();  
     * b. nodeLimitsBreachedRejections - Total number of requests that were rejected due to the node level limits breached  
        return primaryAndCoordinatingLimits.compareAndSet(expectedValue, newValue);
     *  
    /**
    }
     * d. ThroughputMovingAverage - Total moving average throughput value for last N requests.
            totalOutstandingRequests.set(0L);
    private final ShardId shardId;
import org.opensearch.core.index.shard.ShardId;
     *          i.e. when a request for a shard could not be served due to node level limit was already reached.
     */
        }
    private final OperationTracker replicaOperationTracker = new OperationTracker();
            return currentBytes.addAndGet(bytes);
        public long getTotalOutstandingRequests() {
 * @opensearch.internal
     * a. StatsTracker : To track request level aggregated statistics for a shard
 * <p>
            return currentCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
     * OperationTracker bundles the different kind of attributes which needs to be tracked for every operation, per shard:  
     *
    public OperationTracker getCoordinatingOperationTracker() {
            return throughputDegradationLimitsBreachedRejections.get();
    public static class StatsTracker {  
     * StatsTracker is used to track request level aggregated statistics for a shard. This includes:
import java.util.concurrent.ConcurrentLinkedQueue;  
 * To prefer simplicity we have modelled by keeping explicit fields for different operation tracking, while tracker by itself is
            return requestCount.get();
            return throughputMovingAverage.getAndSet(newAvg);  
     */
        private final AtomicLong currentCombinedCoordinatingAndPrimaryBytes = new AtomicLong();
    }
         * Shard Window Throughput Tracker.
        }
    }
 * This class is responsible for all the tracking that needs to be performed at every Shard Level for Indexing Operations on the node.
            return throughputDegradationLimitsBreachedRejections.incrementAndGet();
     * RejectionTracker allows tracking the rejection statistics per shard. This includes:
        }
        public long updateThroughputMovingAverage(long newAvg) {
        public RejectionTracker getRejectionTracker() {
        private final AtomicLong totalOutstandingRequests = new AtomicLong();  
 * across all possible transport-write-actions i.e. Coordinator, Primary and Replica.  
    public long getPrimaryAndCoordinatingLimits() {  
     * a. totalRejections - Total number of requests that were rejected for a shard.
        public long getLastSuccessfulRequestTimestamp() {
        }  
            return currentCombinedCoordinatingAndPrimaryBytes.get();  
        }
     * a. currentCombinedCoordinatingAndPrimaryBytes - Bytes of data that is inflight/processing for a shard  
        public long getNodeLimitsBreachedRejections() {
            return throughputMovingQueue.offer(newThroughput);
            return latencyInMillis.addAndGet(latency);
 * increase the complexity of handling shard-lister events and handling other race scenarios such as request-draining etc.  
        public StatsTracker getStatsTracker() {  
        public long incrementCurrentBytes(long bytes) {  
 * 1. Coordinating Operation : To track all the individual shard bulk request on the coordinator node.  
        private final AtomicLong totalRejections = new AtomicLong();
    }
    }
    /**  
    /**
     *      when primary is local to coordinator node. Hence common accounting for coordinator and primary operation.
    }  
     * @opensearch.internal
    /**  
        public long getCurrentBytes() {
    public boolean compareAndSetPrimaryAndCoordinatingLimits(long expectedValue, long newValue) {
        private final AtomicLong nodeLimitsBreachedRejections = new AtomicLong();
            return currentBytes.get();  
        public long getCurrentCombinedCoordinatingAndPrimaryBytes() {
            return totalBytes.get();
 * Copyright OpenSearch Contributors.
         */
     * c. lastSuccessfulRequestLimitsBreachedRejections - Total number of requests that were rejected due to the
        }  
            return throughputMovingAverage.get();
        }  
     * b. totalCombinedCoordinatingAndPrimaryBytes - Total bytes that are processed/completed successfully for a shard
            return totalCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);  
        return coordinatingOperationTracker;
        public long incrementThroughputDegradationLimitsBreachedRejections() {
     *          throughput degradation in the request path for a shard i.e. partial failure.
 * <p>
        public long getTotalRejections() {  
     *      when primary is local to coordinator node. Hence common accounting for coordinator and primary operation.  
    }
    public ShardId getShardId() {
            return totalOutstandingRequests.get();
        public void updateLastSuccessfulRequestTimestamp(long timeStamp) {  
    private final OperationTracker coordinatingOperationTracker = new OperationTracker();  
        public long incrementTotalOutstandingRequests() {
        private final AtomicLong totalCombinedCoordinatingAndPrimaryBytes = new AtomicLong();  
            return totalRejections.get();
            return totalBytes.addAndGet(bytes);  
        }  
 * 2. Primary Operation : To track all the individual shard bulk request on the primary node.
        this.replicaLimits = new AtomicLong(initialReplicaLimits);
        public long incrementTotalBytes(long bytes) {
        }
    }  
        }  
            return nodeLimitsBreachedRejections.get();  
        private final ConcurrentLinkedQueue<Double> throughputMovingQueue = new ConcurrentLinkedQueue<>();
 * ShardIndexingPressureTracker therefore provides the construct to track all the write requests targeted for a ShardId on the node,
 * Tracker is uniquely identified against a Shard-Id on the node. Currently the knowledge of shard roles (such as primary vs replica)
     * b. RejectionTracker : To track the rejection statistics for a shard
     * a. latencyInMillis - Total indexing time take by requests that were processed successfully for a shard.
}  
        public void resetTotalOutstandingRequests() {  
        return shardId;  
public class ShardIndexingPressureTracker {  
     *          which keeps moving everytime a new request comes. At any given point it tracks last N requests only.
        }
 * There can be four kinds of operation tracking on a node which needs to performed for a shard:
        /**
     * c. Performance Tracker : To track the request performance statistics for a shard  
        private final AtomicLong currentBytes = new AtomicLong();
     * b. lastSuccessfulRequestTimestamp - Timestamp of last successful request for a shard.  
        }
    private final OperationTracker primaryOperationTracker = new OperationTracker();
 */
     * Common operation tracker is used to track values applicable across the operations for a specific shard role. This includes:
        return primaryOperationTracker;  
        }
     *          last successful request limits breached for a shard i.e. complete path failure (black-hole).  
        public long incrementCurrentCombinedCoordinatingAndPrimaryBytes(long bytes) {  
 *  
        public long incrementNodeLimitsBreachedRejections() {  
    private final AtomicLong primaryAndCoordinatingLimits;  
    /**
    }
            return throughputMovingQueue.poll();
        public boolean addNewThroughout(Double newThroughput) {  
package org.opensearch.index;
        }
        }
        this.primaryAndCoordinatingLimits = new AtomicLong(initialPrimaryAndCoordinatingLimits);
        public Double getFirstThroughput() {
            return lastSuccessfulRequestLimitsBreachedRejections.get();
         * We will be using atomic long to track double values as mentioned here -  
        }
        }
    public boolean compareAndSetReplicaLimits(long expectedValue, long newValue) {  
        return replicaLimits.compareAndSet(expectedValue, newValue);
        }  
            return nodeLimitsBreachedRejections.incrementAndGet();
        }
/**  
     */
            return throughputMovingQueue.size();  
        private final StatsTracker statsTracker = new StatsTracker();
        }
     * e. ThroughputMovingQueue - Queue that holds the last N requests throughput such that there exists a sliding window  
    public OperationTracker getPrimaryOperationTracker() {
        public PerformanceTracker getPerformanceTracker() {
 * 4. Common Operation : To track values applicable across the specific shard role.  
            return rejectionTracker;
     *  
     * a. currentBytes - Bytes of data that is inflight/processing for a shard.  
        return commonOperationTracker;
    }
     * d. throughputDegradationLimitsBreachedRejections - Total number of requests that were rejected due to the
 * <p>
     */  
 * is not explicit to the tracker, and it is able to track different values simultaneously based on the interaction hooks of the
        public long getTotalCombinedCoordinatingAndPrimaryBytes() {
    }
        private final PerformanceTracker performanceTracker = new PerformanceTracker();
        }  
        public long getLatencyInMillis() {  
/*  
        return primaryAndCoordinatingLimits.get();
        return replicaOperationTracker;
        }
     * c. TotalOutstandingRequests - Total requests outstanding for a shard at any given point.
        public long addLatencyInMillis(long latency) {
    private final AtomicLong replicaLimits;
         * https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/atomic/package-summary.html
        }
        public long getRequestCount() {  
import java.util.concurrent.atomic.AtomicLong;
    public static class CommonOperationTracker {
        }
    public static class OperationTracker {
        }
    }  
        }  
        public long incrementLastSuccessfulRequestLimitsBreachedRejections() {
        public long getTotalBytes() {
        }  
     * @opensearch.internal
     *
     */  
        public long incrementRequestCount() {
        public long getThroughputDegradationLimitsBreachedRejections() {  
     * @opensearch.internal
     *          EWMA cannot be used here as it evaluate the historical average, while here it just needs the average of last N requests.
        }
        }
 * agnostic of the actual shard role.
            return lastSuccessfulRequestTimestamp;  
     * Performance Tracker is used to track the request performance statistics for every operation, per shard. This includes:
        private final AtomicLong latencyInMillis = new AtomicLong();
            return latencyInMillis.get();
        private final AtomicLong throughputMovingAverage = new AtomicLong();  
     *  
     * @opensearch.internal
            return performanceTracker;  
    public OperationTracker getReplicaOperationTracker() {  
            return statsTracker;
        private final AtomicLong lastSuccessfulRequestLimitsBreachedRejections = new AtomicLong();  
 * Info is maintained at the granularity of three kinds of write operation (tasks) on the node i.e. coordinating, primary and replica.
    private final CommonOperationTracker commonOperationTracker = new CommonOperationTracker();  
        this.shardId = shardId;  
        }  
            lastSuccessfulRequestTimestamp = timeStamp;
        }
 * SPDX-License-Identifier: Apache-2.0
     * c. requestCount - Total number of requests that are processed/completed successfully for a shard.
 */  
        private final RejectionTracker rejectionTracker = new RejectionTracker();  
 * This is useful in evaluating the shard indexing back-pressure on the node, to throttle requests and also to publish runtime stats.  
        public long incrementTotalCombinedCoordinatingAndPrimaryBytes(long bytes) {
    public ShardIndexingPressureTracker(ShardId shardId, long initialPrimaryAndCoordinatingLimits, long initialReplicaLimits) {
     * b. totalBytes - Total bytes that are processed/completed successfully for a shard.
 * There is room for introducing more unique identity to the trackers based on Shard-Role or Shard-Allocation-Id, but that will also
     * @opensearch.internal
            return requestCount.incrementAndGet();
    public static class PerformanceTracker {  
    public long getReplicaLimits() {
            return totalCombinedCoordinatingAndPrimaryBytes.get();
    public static class RejectionTracker {  
        private final AtomicLong throughputDegradationLimitsBreachedRejections = new AtomicLong();
        public long getLastSuccessfulRequestLimitsBreachedRejections() {
            return totalRejections.incrementAndGet();
        public long incrementTotalRejections() {
 * 3. Replica Operation : To track all the individual shard bulk request on the replica node.
        }
    }
        return replicaLimits.get();  
        }  
        public long getThroughputMovingAverage() {
    }
        private volatile long lastSuccessfulRequestTimestamp = 0;
 * operation type i.e. write-action layers.  
    }  
            return totalOutstandingRequests.incrementAndGet();  
