        }
        public long getCurrentBytes() {
        private final AtomicLong throughputMovingAverage = new AtomicLong();
            return totalCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
        return primaryOperationTracker;
 * There can be four kinds of operation tracking on a node which needs to performed for a shard:
            return currentCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
     * RejectionTracker allows tracking the rejection statistics per shard. This includes:
        public long getTotalOutstandingRequests() {
    }
        private volatile long lastSuccessfulRequestTimestamp = 0;
        }
        }
        }
     * c. TotalOutstandingRequests - Total requests outstanding for a shard at any given point.
        return primaryAndCoordinatingLimits.compareAndSet(expectedValue, newValue);
            return totalOutstandingRequests.get();
 */
        public long incrementTotalRejections() {
 * Tracker is uniquely identified against a Shard-Id on the node. Currently the knowledge of shard roles (such as primary vs replica)
        public long incrementTotalOutstandingRequests() {
     *          throughput degradation in the request path for a shard i.e. partial failure.
import org.opensearch.core.index.shard.ShardId;
        public void updateLastSuccessfulRequestTimestamp(long timeStamp) {
    public long getReplicaLimits() {
        private final AtomicLong throughputDegradationLimitsBreachedRejections = new AtomicLong();
        private final AtomicLong requestCount = new AtomicLong();
     * c. Performance Tracker : To track the request performance statistics for a shard
     */
        }
        private final AtomicLong totalRejections = new AtomicLong();
        public long getThroughputMovingAverage() {
        public long addLatencyInMillis(long latency) {
     *
        public long incrementThroughputDegradationLimitsBreachedRejections() {
     * d. throughputDegradationLimitsBreachedRejections - Total number of requests that were rejected due to the
     * c. requestCount - Total number of requests that are processed/completed successfully for a shard.
        private final AtomicLong latencyInMillis = new AtomicLong();
        private final AtomicLong totalBytes = new AtomicLong();
        }
        this.replicaLimits = new AtomicLong(initialReplicaLimits);
    public static class PerformanceTracker {
            totalOutstandingRequests.set(0L);
    public static class OperationTracker {
        public long incrementNodeLimitsBreachedRejections() {
     * a. currentCombinedCoordinatingAndPrimaryBytes - Bytes of data that is inflight/processing for a shard
        public long getTotalRejections() {
        }
        public long incrementCurrentCombinedCoordinatingAndPrimaryBytes(long bytes) {
            return currentBytes.addAndGet(bytes);
     */
    public boolean compareAndSetPrimaryAndCoordinatingLimits(long expectedValue, long newValue) {
            return requestCount.incrementAndGet();
    public long getPrimaryAndCoordinatingLimits() {
        return shardId;
        private final AtomicLong nodeLimitsBreachedRejections = new AtomicLong();
     * a. currentBytes - Bytes of data that is inflight/processing for a shard.
        public long getCurrentCombinedCoordinatingAndPrimaryBytes() {
    }
    public static class StatsTracker {
 * 2. Primary Operation : To track all the individual shard bulk request on the primary node.
            return lastSuccessfulRequestLimitsBreachedRejections.get();
            return throughputMovingQueue.offer(newThroughput);
 * ShardIndexingPressureTracker therefore provides the construct to track all the write requests targeted for a ShardId on the node,
        }
}
    }
     *          which keeps moving everytime a new request comes. At any given point it tracks last N requests only.
    }
            return totalBytes.get();
        public long getThroughputDegradationLimitsBreachedRejections() {
        private final AtomicLong lastSuccessfulRequestLimitsBreachedRejections = new AtomicLong();
            return throughputDegradationLimitsBreachedRejections.get();
        }
 * To prefer simplicity we have modelled by keeping explicit fields for different operation tracking, while tracker by itself is
 * <p>
    public OperationTracker getPrimaryOperationTracker() {
        return commonOperationTracker;
            return nodeLimitsBreachedRejections.get();
    public static class RejectionTracker {
 * increase the complexity of handling shard-lister events and handling other race scenarios such as request-draining etc.
        public boolean addNewThroughout(Double newThroughput) {
        private final AtomicLong totalCombinedCoordinatingAndPrimaryBytes = new AtomicLong();
    }
    private final AtomicLong replicaLimits;
        return coordinatingOperationTracker;
    }
        }
        public long incrementTotalBytes(long bytes) {
     * d. ThroughputMovingAverage - Total moving average throughput value for last N requests.
        return replicaLimits.get();
        }
            return totalRejections.incrementAndGet();
     * OperationTracker bundles the different kind of attributes which needs to be tracked for every operation, per shard:
        }
        return replicaLimits.compareAndSet(expectedValue, newValue);
package org.opensearch.index;
     * b. RejectionTracker : To track the rejection statistics for a shard
     * Performance Tracker is used to track the request performance statistics for every operation, per shard. This includes:
    /**
     * a. totalRejections - Total number of requests that were rejected for a shard.
 */
        public long incrementLastSuccessfulRequestLimitsBreachedRejections() {
            return currentCombinedCoordinatingAndPrimaryBytes.get();
            return latencyInMillis.addAndGet(latency);
     *
    /**
 * @opensearch.internal
            return currentBytes.get();
 * 4. Common Operation : To track values applicable across the specific shard role.
     *          i.e. when a request for a shard could not be served due to node level limit was already reached.
            return nodeLimitsBreachedRejections.incrementAndGet();
        private final AtomicLong currentCombinedCoordinatingAndPrimaryBytes = new AtomicLong();
        this.shardId = shardId;
     * b. nodeLimitsBreachedRejections - Total number of requests that were rejected due to the node level limits breached
            return lastSuccessfulRequestLimitsBreachedRejections.incrementAndGet();
            return throughputMovingAverage.get();
            return totalCombinedCoordinatingAndPrimaryBytes.get();
        }
        }
    }
/**
    private final OperationTracker replicaOperationTracker = new OperationTracker();
     * @opensearch.internal
     * b. lastSuccessfulRequestTimestamp - Timestamp of last successful request for a shard.
    /**
            return totalOutstandingRequests.incrementAndGet();
        /**
        }
        return replicaOperationTracker;
            return performanceTracker;
        public long incrementTotalCombinedCoordinatingAndPrimaryBytes(long bytes) {
        public long getThroughputMovingQueueSize() {
    public CommonOperationTracker getCommonOperationTracker() {
    private final AtomicLong primaryAndCoordinatingLimits;
        public RejectionTracker getRejectionTracker() {
        }
    }
        public StatsTracker getStatsTracker() {
        public long updateThroughputMovingAverage(long newAvg) {
        }
    }
        }
     * e. ThroughputMovingQueue - Queue that holds the last N requests throughput such that there exists a sliding window
         * Shard Window Throughput Tracker.
        public long incrementCurrentBytes(long bytes) {
     */
        }
     * a. latencyInMillis - Total indexing time take by requests that were processed successfully for a shard.
        public long getLastSuccessfulRequestLimitsBreachedRejections() {
 * agnostic of the actual shard role.
        }
     * c. lastSuccessfulRequestLimitsBreachedRejections - Total number of requests that were rejected due to the
        return primaryAndCoordinatingLimits.get();
            return totalBytes.addAndGet(bytes);
            return latencyInMillis.get();
            return throughputDegradationLimitsBreachedRejections.incrementAndGet();
    public ShardId getShardId() {
    }
        public long getLastSuccessfulRequestTimestamp() {
     */
    }
        }
 * <p>
            return lastSuccessfulRequestTimestamp;
    }
        private final RejectionTracker rejectionTracker = new RejectionTracker();
/*
        private final StatsTracker statsTracker = new StatsTracker();
        private final ConcurrentLinkedQueue<Double> throughputMovingQueue = new ConcurrentLinkedQueue<>();
     * @opensearch.internal
        public long incrementRequestCount() {
            return throughputMovingQueue.poll();
     * b. totalCombinedCoordinatingAndPrimaryBytes - Total bytes that are processed/completed successfully for a shard
    }
     * @opensearch.internal
        public PerformanceTracker getPerformanceTracker() {
         * https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/atomic/package-summary.html
    public boolean compareAndSetReplicaLimits(long expectedValue, long newValue) {
        public void resetTotalOutstandingRequests() {
     * a. StatsTracker : To track request level aggregated statistics for a shard
    public OperationTracker getReplicaOperationTracker() {
 * This class is responsible for all the tracking that needs to be performed at every Shard Level for Indexing Operations on the node.
 * across all possible transport-write-actions i.e. Coordinator, Primary and Replica.
     *
        public long getRequestCount() {
        }
        }
    }
    private final OperationTracker primaryOperationTracker = new OperationTracker();
        this.primaryAndCoordinatingLimits = new AtomicLong(initialPrimaryAndCoordinatingLimits);
         * We will be using atomic long to track double values as mentioned here -
    private final OperationTracker coordinatingOperationTracker = new OperationTracker();
public class ShardIndexingPressureTracker {
        }
     * StatsTracker is used to track request level aggregated statistics for a shard. This includes:
        }
     * b. totalBytes - Total bytes that are processed/completed successfully for a shard.
        private final AtomicLong totalOutstandingRequests = new AtomicLong();
     * @opensearch.internal
    }
     */
        }
 * This is useful in evaluating the shard indexing back-pressure on the node, to throttle requests and also to publish runtime stats.
        public long getTotalCombinedCoordinatingAndPrimaryBytes() {
        public Double getFirstThroughput() {
     *
            lastSuccessfulRequestTimestamp = timeStamp;
import java.util.concurrent.ConcurrentLinkedQueue;
     *      when primary is local to coordinator node. Hence common accounting for coordinator and primary operation.
            return throughputMovingQueue.size();
        }
        }
        }
     * Common operation tracker is used to track values applicable across the operations for a specific shard role. This includes:
            return requestCount.get();
        }
        }
        }
 * is not explicit to the tracker, and it is able to track different values simultaneously based on the interaction hooks of the
 * <p>
    /**
    private final ShardId shardId;
        private final PerformanceTracker performanceTracker = new PerformanceTracker();
            return statsTracker;
        public long getNodeLimitsBreachedRejections() {
 * There is room for introducing more unique identity to the trackers based on Shard-Role or Shard-Allocation-Id, but that will also
    public OperationTracker getCoordinatingOperationTracker() {
 *
 * SPDX-License-Identifier: Apache-2.0
     *
 * Copyright OpenSearch Contributors.
            return totalRejections.get();
         */
    /**
            return throughputMovingAverage.getAndSet(newAvg);
import java.util.concurrent.atomic.AtomicLong;
        public long getLatencyInMillis() {
        }
        public long getTotalBytes() {
        private final AtomicLong currentBytes = new AtomicLong();
    private final CommonOperationTracker commonOperationTracker = new CommonOperationTracker();
 * Info is maintained at the granularity of three kinds of write operation (tasks) on the node i.e. coordinating, primary and replica.
    public static class CommonOperationTracker {
 * operation type i.e. write-action layers.
     *      when primary is local to coordinator node. Hence common accounting for coordinator and primary operation.
 * 3. Replica Operation : To track all the individual shard bulk request on the replica node.
 * 1. Coordinating Operation : To track all the individual shard bulk request on the coordinator node.
            return rejectionTracker;
    public ShardIndexingPressureTracker(ShardId shardId, long initialPrimaryAndCoordinatingLimits, long initialReplicaLimits) {
     *          EWMA cannot be used here as it evaluate the historical average, while here it just needs the average of last N requests.
     * @opensearch.internal
     *          last successful request limits breached for a shard i.e. complete path failure (black-hole).
