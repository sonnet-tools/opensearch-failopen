        1.0d,
import org.opensearch.common.settings.ClusterSettings;
 * issues, such as throughput degradation (Secondary Parameter - 1) and time since last request was successful (Secondary Parameter - 2).
    }
            if (((double) shardCurrentBytes / currentShardLimit) > this.upperOperatingFactor) {
            }
        long nodeTotalBytes,
                nodeTotalBytes,
                    .entrySet()
        if (nodeReplicaBytes > this.shardIndexingPressureSettings.getNodeReplicaLimits()) {
        Settings settings
        double degradationLimits
        clusterSettings.addSettingsUpdateConsumer(LOWER_OPERATING_FACTOR, this::setLowerOperatingFactor);
    private volatile double nodeSoftLimit;
                operationTracker.getRejectionTracker().incrementThroughputDegradationLimitsBreachedRejections();
 * this file be licensed under the Apache-2.0 license or a
    }
    }
    /**
    }
 * is greater than primary_parameter.node.soft_limit, then MemoryManager will evaluate deeper parameters for shards to identify any
        );
            if (shardThroughputDegradationLimitsBreached) {
        this.replicaThroughputDegradationLimits = this.primaryAndCoordinatingThroughputDegradationLimits * 1.5;
            logger.debug(
        0.0d,
                tracker::compareAndSetPrimaryAndCoordinatingLimits
                    .stream()
                operationTracker.getPerformanceTracker(),
        return false;
            BooleanSupplier increaseShardLimitSupplier = () -> increaseShardLimits(
                tracker::compareAndSetPrimaryAndCoordinatingLimits
        BiPredicate<Long, Long> updateShardLimitPredicate,
import java.util.Map;
                nodeTotalBytes,
    );
    /**
    public ShardIndexingPressureMemoryManager(
        long nodeLimit,
                tracker.getPrimaryOperationTracker(),
    }
    private boolean evaluateThroughputDegradationLimitsBreached(
        BiPredicate<Long, Long> updateShardLimitPredicate
                ShardIndexingPressureTracker::getPrimaryAndCoordinatingLimits,
    private final AtomicLong totalThroughputDegradationLimitsBreachedRejections = new AtomicLong();
        this.nodeSoftLimit = nodeSoftLimit;
                incrementNodeLimitBreachedRejectionCount(operationTracker.getRejectionTracker());
import java.util.function.BooleanSupplier;
        Setting.Property.NodeScope,
        boolean shardMemoryLimitsBreached = ((double) shardCombinedBytes / shardPrimaryAndCoordinatingLimits) > this.upperOperatingFactor;
    /**
    /**
        long currentShardLimit;
            logger.debug(
}
    }
            boolean isShardLimitsIncreased = increaseShardLimitSupplier.getAsBoolean();
     * Degradation for a shard can be evaluated using average throughput of last N requests,
    private void setLowerOperatingFactor(double lowerOperatingFactor) {
            );
    }
        return shardIndexingPressureStore.getShardIndexingPressureHotStore();
    }
    }
            return false;
        } else {
                return true;
                    newShardLimit
 * <p>
    /**
 * @opensearch.internal
    double calculateMovingAverage(long currentAverage, double frontValue, double currentValue, int count) {
    ) {
        LongSupplier shardCurrentBytesSupplier,
        }
        final boolean shardMemoryLimitsBreached = ((double) shardReplicaBytes / shardReplicaLimits) > this.upperOperatingFactor;
        0.7d,
    /**
 * <p>
                nodeTotalBytes,
    );
import java.util.function.ToLongFunction;
                requestStartTime,
                tracker::getPrimaryAndCoordinatingLimits,
 * the historical throughput average. If the factor by which it has increased is greater than the degradation limit threshold, this
     * This determines the max time elapsed since any request was processed successfully. Appropriate action is taken
    ) {
            BooleanSupplier increaseShardLimitSupplier = () -> increaseShardLimits(
        clusterSettings.addSettingsUpdateConsumer(SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT, this::setSuccessfulRequestElapsedTimeout);
        Setting.Property.Dynamic
    Map<ShardId, ShardIndexingPressureTracker> getShardIndexingPressureHotStore() {
            shardIndexingPressureSettings.getShardPrimaryAndCoordinatingBaseLimits()
     */
    public static final Setting<Double> NODE_SOFT_LIMIT = Setting.doubleSetting(
                tracker::getPrimaryAndCoordinatingLimits,
                increaseShardLimitSupplier
                    shardId.id(),
    }
 * SPDX-License-Identifier: Apache-2.0
     */
            }
            BooleanSupplier increaseShardLimitSupplier = () -> increaseShardLimits(
    boolean isPrimaryNodeLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes) {
    long getTotalThroughputDegradationLimitsBreachedRejections() {
                        currentShardLimit,
 */
        double throughputMovingAverage = Double.longBitsToDouble(performanceTracker.getThroughputMovingAverage());
     */
        boolean shardMemoryLimitsBreached = ((double) shardCombinedBytes / shardPrimaryAndCoordinatingLimits) > this.upperOperatingFactor;
                increaseShardLimitSupplier
                if (totalShardLimitsExceptCurrentShard + newShardLimit > nodeLimit) {
        LongSupplier shardLimitSupplier,
 * goes above operating_factor.upper of current shard limits. MemoryManager attempts to update the new shard limit such that the new value
    private volatile int maxOutstandingRequests;
        5.0d,
     */
        0.0d,
                    "Shard Limits Already Decreased ["
                () -> tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes(),
 * remains within the operating_factor.optimal range of current shard utilization.
    }
        this.shardIndexingPressureStore = new ShardIndexingPressureStore(shardIndexingPressureSettings, clusterSettings, settings);
    }
            if (((double) shardCurrentBytes / currentShardLimit) > this.lowerOperatingFactor) {
     * Checks if the shard level memory threshold is breached for coordinating operations.
                this.totalLastSuccessfulRequestLimitsBreachedRejections.incrementAndGet();
                return true;
                operationTracker.getRejectionTracker().incrementLastSuccessfulRequestLimitsBreachedRejections();
        if (((double) nodeTotalBytes / nodeLimit) < this.nodeSoftLimit) {
                        + "shard_detail=[{}][{}], "
        } else {
        clusterSettings.addSettingsUpdateConsumer(NODE_SOFT_LIMIT, this::setNodeSoftLimit);
        long shardReplicaBytes = tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes();
        // Shard memory limits is breached when the current utilization is greater than operating_factor.upper limit.
    /**
            boolean shardThroughputDegradationLimitsBreached = evaluateThroughputDegradationLimitsBreached(
 * timeout threshold value, while there a number of outstanding requests greater than the max outstanding requests then this parameter
        }
import org.opensearch.core.index.shard.ShardId;
    public static final Setting<Double> UPPER_OPERATING_FACTOR = Setting.doubleSetting(
    boolean isReplicaShardLimitBreached(ShardIndexingPressureTracker tracker, long nodeReplicaBytes, long requestStartTime) {
import java.util.function.LongSupplier;
    /**
            if (isShardLimitsIncreased == false) {
                "Node limits breached for replica operation [node_replica_bytes={} , " + "node_replica_limits={}]",
            );
        0.0d,
        this.successfulRequestElapsedTimeout = successfulRequestElapsedTimeout;
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
        long newShardLimit;
            );
        }
        }
                );
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
        logger.debug(
        if (shardMemoryLimitsBreached) {
        clusterSettings.addSettingsUpdateConsumer(OPTIMAL_OPERATING_FACTOR, this::setOptimalOperatingFactor);
    }
                    .map(Map.Entry::getValue)
    long getTotalLastSuccessfulRequestLimitsBreachedRejections() {
            && throughputMovingQueueSize >= this.shardIndexingPressureSettings.getRequestSizeWindow()
    );
                        + "current_shard_limit_bytes={}, "
            () -> tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes(),
    private volatile double optimalOperatingFactor;
        this.successfulRequestElapsedTimeout = SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.get(settings);
        this.upperOperatingFactor = upperOperatingFactor;
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()
                    shardId.getIndexName(),
        Setting.Property.Dynamic
    private static final Logger logger = LogManager.getLogger(ShardIndexingPressureMemoryManager.class);
 * The Shard Indexing Pressure Memory Manager is the construct responsible for increasing and decreasing the allocated shard limit
        PerformanceTracker performanceTracker,
                nodeTotalBytes,
    public static final Setting<Double> LOWER_OPERATING_FACTOR = Setting.doubleSetting(
    private void setNodeSoftLimit(double nodeSoftLimit) {
            return false;
                () -> tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
                ShardIndexingPressureTracker::getPrimaryAndCoordinatingLimits,
    Map<ShardId, ShardIndexingPressureTracker> getShardIndexingPressureColdStore() {
    void decreaseShardReplicaLimits(ShardIndexingPressureTracker tracker) {
    public static final Setting<Double> THROUGHPUT_DEGRADATION_LIMITS = Setting.doubleSetting(
        Setting.Property.Dynamic
            return true;
        this.replicaThroughputDegradationLimits = this.primaryAndCoordinatingThroughputDegradationLimits * 1.5;
        if (nodeTotalBytes > this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()) {
                operationTracker.getStatsTracker(),
            );
        Setting.Property.Dynamic
            currentShardLimit = shardLimitSupplier.getAsLong();
        BooleanSupplier increaseShardLimitSupplier
                increaseShardLimitSupplier
        ShardId shardId,
                        + "expected_shard_limit_bytes={}]",
        return false;
            return onShardLimitBreached(
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()
        Setting.Property.Dynamic
        decreaseShardLimits(
                this.totalThroughputDegradationLimitsBreachedRejections.incrementAndGet();
            }
        clusterSettings.addSettingsUpdateConsumer(MAX_OUTSTANDING_REQUESTS, this::setMaxOutstandingRequests);
        do {
    void decreaseShardPrimaryAndCoordinatingLimits(ShardIndexingPressureTracker tracker) {
     * the successful request elapsed-timeout threshold, and the total number of outstanding requests is greater than
        Setting.Property.NodeScope,
    );
                logger.debug(
    }
 * compatible open source license.
            }
            shardIndexingPressureSettings.getShardReplicaBaseLimits()
     * the degradation limits threshold.
        if (nodeTotalBytes > this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()) {
        // Shard memory limits is breached when the current utilization is greater than operating_factor.upper limit.
    }
        this.nodeSoftLimit = NODE_SOFT_LIMIT.get(settings).doubleValue();
        "shard_indexing_pressure.primary_parameter.node.soft_limit",
        long shardPrimaryAndCoordinatingLimits = tracker.getPrimaryAndCoordinatingLimits();
            }
     */
        } else {
        this.maxOutstandingRequests = MAX_OUTSTANDING_REQUESTS.get(settings).intValue();
        this.primaryAndCoordinatingThroughputDegradationLimits = THROUGHPUT_DEGRADATION_LIMITS.get(settings).doubleValue();
                ShardIndexingPressureTracker::getReplicaLimits,
        // Shard memory limits is breached when the current utilization is greater than operating_factor.upper limit.
        return totalNodeLimitsBreachedRejections.get();
                }
            long shardCurrentBytes = shardCurrentBytesSupplier.getAsLong();
            newShardLimit = Math.max((long) (shardCurrentBytes / this.optimalOperatingFactor), shardBaseLimit);
import java.util.function.BiPredicate;
    );
            && (requestStartTime - performanceTracker.getLastSuccessfulRequestTimestamp()) > this.successfulRequestElapsedTimeout.nanos()
 * is considered to be breached.
    public static final Setting<Integer> MAX_OUTSTANDING_REQUESTS = Setting.intSetting(
        long shardPrimaryAndCoordinatingLimits = tracker.getPrimaryAndCoordinatingLimits();
import org.opensearch.index.ShardIndexingPressureTracker.OperationTracker;
                long totalShardLimitsExceptCurrentShard = this.shardIndexingPressureStore.getShardIndexingPressureHotStore()
 * 1. ThroughputDegradationLimitsBreached - When the moving window throughput average has increased by a factor compared to
            return ((Double.longBitsToDouble(currentAverage) * count) + currentValue - frontValue) / count;
        TimeValue.timeValueMillis(300000),
        this.lowerOperatingFactor = lowerOperatingFactor;
        this.totalNodeLimitsBreachedRejections.incrementAndGet();
            );
                tracker.getCoordinatingOperationTracker(),
    /**
                requestStartTime,
                    );
     * This evaluation returns true if throughput of last N request divided by the total lifetime requests throughput is greater than
            return true;
                tracker::compareAndSetReplicaLimits
import org.opensearch.common.unit.TimeValue;
    }
            boolean isShardLimitsIncreased = increaseShardLimitSupplier.getAsBoolean();
                this.shardIndexingPressureSettings.getNodeReplicaLimits()
    ) {
    }
                        totalShardLimitsExceptCurrentShard,
    private void setUpperOperatingFactor(double upperOperatingFactor) {
        } while (!updateShardLimitPredicate.test(currentShardLimit, newShardLimit));
                this.shardIndexingPressureSettings.getNodeReplicaLimits(),
            return currentValue;
                            + "shard_current_limit_bytes={}, "
            }
    boolean isReplicaNodeLimitBreached(ShardIndexingPressureTracker tracker, long nodeReplicaBytes) {
 * 2. If the limits assigned to the shard is breached(Primary Parameter) and the node level overall occupancy across all shards
        return throughputMovingAverage > 0
        );
            );
    boolean isCoordinatingShardLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes, long requestStartTime) {
    boolean isCoordinatingNodeLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes) {
        "shard_indexing_pressure.secondary_parameter.successful_request.max_outstanding_requests",
    /**
        0.75d,
        long shardReplicaLimits = tracker.getReplicaLimits();
        return totalLastSuccessfulRequestLimitsBreachedRejections.get();
        } else {
        this.lowerOperatingFactor = LOWER_OPERATING_FACTOR.get(settings).doubleValue();
                tracker.getShardId(),
package org.opensearch.index;
        0.95d,
    private volatile TimeValue successfulRequestElapsedTimeout;
     * Checks if the node level memory threshold is breached for replica operations.
        } while (!updateShardLimitPredicate.test(currentShardLimit, newShardLimit));
        "shard_indexing_pressure.operating_factor.optimal",
        StatsTracker statsTracker,
    }
        this.shardIndexingPressureSettings = shardIndexingPressureSettings;
            "Increased Shard Limit [" + "shard_detail=[{}][{}], old_shard_limit_bytes={}, " + "new_shard_limit_bytes={}]",
import org.opensearch.index.ShardIndexingPressureTracker.StatsTracker;
                    logger.debug(
    }
    private final AtomicLong totalNodeLimitsBreachedRejections = new AtomicLong();
                this.shardIndexingPressureSettings.getNodeReplicaLimits(),
        100,
            return !isShardLimitsIncreased;
     */
 * The OpenSearch Contributors require contributions made to
 * Secondary Parameters covered above:
 */
import org.opensearch.common.settings.Settings;
        this.optimalOperatingFactor = OPTIMAL_OPERATING_FACTOR.get(settings).doubleValue();
        Setting.Property.NodeScope,
        ClusterSettings clusterSettings,
        this.upperOperatingFactor = UPPER_OPERATING_FACTOR.get(settings).doubleValue();
    public static final Setting<Double> OPTIMAL_OPERATING_FACTOR = Setting.doubleSetting(
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
        0.0d,
        LongSupplier shardCurrentBytesSupplier,
                nodeReplicaBytes,
                            + "total_shard_limits_bytes_except_current_shard={}, "
    }
    /**
     * Appropriate action is taken once the outcome of above expression breaches the below defined threshold value is breached.
                tracker::getReplicaLimits,
     * the maximum outstanding request-count threshold.
        }
 *
        rejectionTracker.incrementNodeLimitsBreachedRejections();
        long nodeLimit,
        // the current node utilization is greater than primary_parameter.node.soft_limit of total node limits.
        long shardCombinedBytes = tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes();
    void tryTrackerCleanupFromHotStore(ShardIndexingPressureTracker tracker, BooleanSupplier condition) {
    private volatile double replicaThroughputDegradationLimits;
                return;
        long currentShardLimit;
    );
                requestStartTime,
        clusterSettings.addSettingsUpdateConsumer(UPPER_OPERATING_FACTOR, this::setUpperOperatingFactor);
        );
            () -> tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
 * <p>
        ShardId shardId,
    private boolean evaluateLastSuccessfulRequestDurationLimitsBreached(PerformanceTracker performanceTracker, long requestStartTime) {
            shardId.getIndexName(),
     */
        double throughputHistoricalAverage = (double) statsTracker.getTotalBytes() / performanceTracker.getLatencyInMillis();
            logger.debug(
                tracker.getReplicaOperationTracker(),
                () -> tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
        Setting.Property.NodeScope,
        // Secondary Parameters (i.e. LastSuccessfulRequestDuration and Throughput) is taken into consideration when
        ToLongFunction<ShardIndexingPressureTracker> getShardLimitFunction,
     */
    }
    }
            return onShardLimitBreached(
        }
        "shard_indexing_pressure.secondary_parameter.successful_request.elapsed_timeout",
        logger.debug(
     * once the below below defined threshold value is breached.
        return (performanceTracker.getLastSuccessfulRequestTimestamp() > 0)
    }
 * is not greater than primary_parameter.node.soft_limit, MemoryManager will increase the shard limits without any deeper evaluation.
                "Node limits breached for primary operation [node_total_bytes={}, " + "node_primary_and_coordinating_limits={}]",
/**
    }
     */
 * MemoryManager attempts to increase of decrease the shard limits in case the shard utilization goes below operating_factor.lower or
        return shardIndexingPressureStore.getShardIndexingPressureTracker(shardId);
    }
    private volatile double lowerOperatingFactor;
     * Checks if the node level memory threshold is breached for coordinating operations.
 * This helps identify detect any duress state with the shard, requesting more memory.
    }
import org.apache.logging.log4j.Logger;
                tracker.getShardId(),
                incrementNodeLimitBreachedRejectionCount(operationTracker.getRejectionTracker());
        if (shardMemoryLimitsBreached) {
            if (shardLastSuccessfulRequestDurationLimitsBreached) {
     */
            );
        clusterSettings.addSettingsUpdateConsumer(THROUGHPUT_DEGRADATION_LIMITS, this::setThroughputDegradationLimits);
                    .mapToLong(getShardLimitFunction)
            return onShardLimitBreached(
    private void decreaseShardLimits(
 *
                "Node limits breached for coordinating operation [node_total_bytes={} , " + "node_primary_and_coordinating_limits={}]",
    boolean isPrimaryShardLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes, long requestStartTime) {
        return shardIndexingPressureStore.getShardIndexingPressureColdStore();
    /**
            );
        "shard_indexing_pressure.secondary_parameter.throughput.degradation_factor",
        decreaseShardLimits(
     * This determines the max outstanding request that are yet to be processed successfully. Appropriate
            incrementNodeLimitBreachedRejectionCount(tracker.getCoordinatingOperationTracker().getRejectionTracker());
            shardId.getIndexName(),
                nodeReplicaBytes,
     * Checks if the node level memory threshold is breached for primary operations.
/*
    private void setSuccessfulRequestElapsedTimeout(TimeValue successfulRequestElapsedTimeout) {
                    .filter(entry -> (shardId != entry.getKey()))
        do {
     * where N being {@link ShardIndexingPressureSettings#REQUEST_SIZE_WINDOW}, divided by lifetime average throughput.
     * This evaluation returns true if the difference in the current timestamp and last successful request timestamp is greater than
            incrementNodeLimitBreachedRejectionCount(tracker.getPrimaryOperationTracker().getRejectionTracker());
import org.opensearch.common.settings.Setting;
            tracker::compareAndSetReplicaLimits,
                    .sum();
     * Checks if the shard level memory threshold is breached for replica operations.
        return false;
        } else {
    private void incrementNodeLimitBreachedRejectionCount(RejectionTracker rejectionTracker) {
                primaryAndCoordinatingThroughputDegradationLimits
        if (count > 0) {
                        "Failed To Increase Shard Limit [shard_detail=[{}][{}}], "
public class ShardIndexingPressureMemoryManager {
 * based on incoming requests. A shard limits defines the maximum memory that a shard can occupy in the heap for request objects.
        this.optimalOperatingFactor = optimalOperatingFactor;
        Setting.Property.Dynamic
        LongSupplier shardLimitSupplier,
        Setting.Property.NodeScope,
    public static final Setting<TimeValue> SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT = Setting.positiveTimeSetting(
            tracker::getPrimaryAndCoordinatingLimits,
     * Checks if the shard level memory threshold is breached for primary operations.
    private final ShardIndexingPressureStore shardIndexingPressureStore;
        );
 * Based on the overall memory utilization on the node, and current traffic needs shard limits will be modified:
            tracker::getReplicaLimits,
    ) {
     */
    }
     * The node level soft limit determines when the secondary parameters for shard is to be evaluated for degradation.
    private volatile double upperOperatingFactor;
            currentShardLimit,
    private void setMaxOutstandingRequests(int maxOutstandingRequests) {
     */
                        newShardLimit
                    currentShardLimit,
        long requestStartTime,
 * parameter is considered to be breached.
        Setting.Property.NodeScope,
            return !isShardLimitsIncreased;
                        shardId.getIndexName(),
    }
        long shardCombinedBytes = tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes();
            long shardCurrentBytes = shardCurrentBytesSupplier.getAsLong();
                            + "expected_shard_limits_bytes={}]",
            && performanceTracker.getTotalOutstandingRequests() > this.maxOutstandingRequests;
    ) {
    /**
        }
    ShardIndexingPressureTracker getShardIndexingPressureTracker(ShardId shardId) {
    }
            shardId.id(),
        OperationTracker operationTracker,
            );
        if (shardMemoryLimitsBreached) {
    private volatile double primaryAndCoordinatingThroughputDegradationLimits;
        0.85d,
                tracker.getShardId(),
            tracker.getShardId(),
            tracker::compareAndSetPrimaryAndCoordinatingLimits,
        this.primaryAndCoordinatingThroughputDegradationLimits = throughputDegradationLimits;
    );
        long shardBaseLimit
 * <p>
    /**
    long getTotalNodeLimitsBreachedRejections() {
            currentShardLimit = shardLimitSupplier.getAsLong();
                return true;
        return totalThroughputDegradationLimitsBreachedRejections.get();
            shardId.id(),
        this.maxOutstandingRequests = maxOutstandingRequests;
     * Verifies and returns true if the shard limit is hard-breached i.e. shard limit cannot be increased further. Otherwise
            newShardLimit
        Setting.Property.NodeScope,
     * Shard operating factor can be evaluated using currentShardBytes/shardLimits. Outcome of this expression is categorized as
     */
     */
        long throughputMovingQueueSize = performanceTracker.getThroughputMovingQueueSize();
            return false;
import org.opensearch.index.ShardIndexingPressureTracker.RejectionTracker;
                newShardLimit = (long) (shardCurrentBytes / this.optimalOperatingFactor);
import java.util.concurrent.atomic.AtomicLong;
            boolean shardLastSuccessfulRequestDurationLimitsBreached = evaluateLastSuccessfulRequestDurationLimitsBreached(
            );
        }
 * 2. LastSuccessfulRequestDurationLimitsBreached - When the time since the last successful request completed is greater than the max
                requestStartTime
 * 1. If the limits assigned to a shard is breached (Primary Parameter) while the node level overall occupancy across all shards
            } else {
        "shard_indexing_pressure.operating_factor.upper",
     * lower, optimal and upper boundary, and appropriate action is taken once the below defined threshold values are breached.
            currentShardLimit,
            );
            "Decreased Shard Limit [shard_detail=[{}][{}], " + "old_shard_limit_bytes={}, new_shard_limit_bytes={}]",
            if (isShardLimitsIncreased == false) {
     * action is taken once the below defined threshold value is breached.
        Setting.Property.Dynamic
            tracker.getShardId(),
        ShardIndexingPressureSettings shardIndexingPressureSettings,
            incrementNodeLimitBreachedRejectionCount(tracker.getReplicaOperationTracker().getRejectionTracker());
    private void setThroughputDegradationLimits(double throughputDegradationLimits) {
        return true;
import org.opensearch.index.ShardIndexingPressureTracker.PerformanceTracker;
import org.apache.logging.log4j.LogManager;
     * increases the shard limit and returns false.
            return true;
    private final AtomicLong totalLastSuccessfulRequestLimitsBreachedRejections = new AtomicLong();
    private boolean increaseShardLimits(
        "shard_indexing_pressure.operating_factor.lower",
                        shardId.id(),
        long newShardLimit;
            && throughputHistoricalAverage / throughputMovingAverage > degradationLimits;
                operationTracker.getPerformanceTracker(),
    private boolean onShardLimitBreached(
    }
    private void setOptimalOperatingFactor(double optimalOperatingFactor) {
            newShardLimit
        shardIndexingPressureStore.tryTrackerCleanupFromHotStore(tracker, condition);
                    return false;
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
    private final ShardIndexingPressureSettings shardIndexingPressureSettings;
