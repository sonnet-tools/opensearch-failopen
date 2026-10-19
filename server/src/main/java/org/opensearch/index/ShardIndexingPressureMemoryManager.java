    }  
        Setting.Property.Dynamic
        "shard_indexing_pressure.secondary_parameter.successful_request.elapsed_timeout",  
            if (((double) shardCurrentBytes / currentShardLimit) > this.upperOperatingFactor) {  
                tracker::getReplicaLimits,
    }
            return onShardLimitBreached(  
        long nodeLimit,  
    /**  
        return throughputMovingAverage > 0  
        long shardBaseLimit
     * This determines the max time elapsed since any request was processed successfully. Appropriate action is taken
     */
import org.apache.logging.log4j.Logger;
        clusterSettings.addSettingsUpdateConsumer(SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT, this::setSuccessfulRequestElapsedTimeout);  
        0.75d,
                        shardId.id(),
 * compatible open source license.
            tracker.getShardId(),
            );
        if (shardMemoryLimitsBreached) {  
                        currentShardLimit,  
        Settings settings  
                tracker::getPrimaryAndCoordinatingLimits,  
            && throughputMovingQueueSize >= this.shardIndexingPressureSettings.getRequestSizeWindow()
        clusterSettings.addSettingsUpdateConsumer(OPTIMAL_OPERATING_FACTOR, this::setOptimalOperatingFactor);  
                incrementNodeLimitBreachedRejectionCount(operationTracker.getRejectionTracker());
        this.shardIndexingPressureSettings = shardIndexingPressureSettings;
            return true;  
                () -> tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes(),
    private void setUpperOperatingFactor(double upperOperatingFactor) {  
            );  
    private boolean evaluateLastSuccessfulRequestDurationLimitsBreached(PerformanceTracker performanceTracker, long requestStartTime) {
     */  
    }
                this.shardIndexingPressureSettings.getNodeReplicaLimits()
    }  
    ) {
 * Based on the overall memory utilization on the node, and current traffic needs shard limits will be modified:  
            return true;
        }  
     */  
        final boolean shardMemoryLimitsBreached = ((double) shardReplicaBytes / shardReplicaLimits) > this.upperOperatingFactor;
     */  
    /**
                "Node limits breached for coordinating operation [node_total_bytes={} , " + "node_primary_and_coordinating_limits={}]",
     * This evaluation returns true if throughput of last N request divided by the total lifetime requests throughput is greater than
        1.0d,
                        + "shard_detail=[{}][{}], "  
                requestStartTime
 * <p>
 * the historical throughput average. If the factor by which it has increased is greater than the degradation limit threshold, this
            if (isShardLimitsIncreased == false) {
                this.shardIndexingPressureSettings.getNodeReplicaLimits(),  
            shardId.id(),
            if (isShardLimitsIncreased == false) {  
 * Secondary Parameters covered above:  
     * Checks if the node level memory threshold is breached for coordinating operations.
        decreaseShardLimits(
        }
    private boolean onShardLimitBreached(
        if (shardMemoryLimitsBreached) {
        Setting.Property.NodeScope,
    );  
     * Appropriate action is taken once the outcome of above expression breaches the below defined threshold value is breached.
                tracker::compareAndSetReplicaLimits
import java.util.function.ToLongFunction;  
                this.totalLastSuccessfulRequestLimitsBreachedRejections.incrementAndGet();
                    .entrySet()  
            long shardCurrentBytes = shardCurrentBytesSupplier.getAsLong();
                    shardId.getIndexName(),  
        } while (!updateShardLimitPredicate.test(currentShardLimit, newShardLimit));
                incrementNodeLimitBreachedRejectionCount(operationTracker.getRejectionTracker());
        long shardPrimaryAndCoordinatingLimits = tracker.getPrimaryAndCoordinatingLimits();
                increaseShardLimitSupplier
    private void setMaxOutstandingRequests(int maxOutstandingRequests) {
        do {
            }
            } else {  
            }  
                nodeTotalBytes,
    boolean isPrimaryShardLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes, long requestStartTime) {
    /**  
                tracker.getReplicaOperationTracker(),
    void decreaseShardReplicaLimits(ShardIndexingPressureTracker tracker) {
        0.85d,  
        Setting.Property.NodeScope,
            return false;
     * the degradation limits threshold.
        100,  
import org.opensearch.index.ShardIndexingPressureTracker.PerformanceTracker;  
            () -> tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes(),
        return false;
    private final ShardIndexingPressureSettings shardIndexingPressureSettings;  
                "Node limits breached for replica operation [node_replica_bytes={} , " + "node_replica_limits={}]",
        ShardId shardId,
        StatsTracker statsTracker,  
        this.lowerOperatingFactor = lowerOperatingFactor;
                tracker.getShardId(),
        if (nodeTotalBytes > this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()) {
import java.util.function.LongSupplier;
 * MemoryManager attempts to increase of decrease the shard limits in case the shard utilization goes below operating_factor.lower or
        do {
    private volatile double primaryAndCoordinatingThroughputDegradationLimits;
        long throughputMovingQueueSize = performanceTracker.getThroughputMovingQueueSize();
                requestStartTime,
        clusterSettings.addSettingsUpdateConsumer(MAX_OUTSTANDING_REQUESTS, this::setMaxOutstandingRequests);  
            shardId.id(),  
 * is greater than primary_parameter.node.soft_limit, then MemoryManager will evaluate deeper parameters for shards to identify any
    private void setThroughputDegradationLimits(double throughputDegradationLimits) {  
     */  
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
import org.opensearch.common.settings.ClusterSettings;  
                        newShardLimit
        long nodeTotalBytes,
    private volatile double optimalOperatingFactor;
            boolean shardThroughputDegradationLimitsBreached = evaluateThroughputDegradationLimitsBreached(
    public static final Setting<Double> THROUGHPUT_DEGRADATION_LIMITS = Setting.doubleSetting(
        OperationTracker operationTracker,
        logger.debug(
            return false;  
package org.opensearch.index;
            currentShardLimit = shardLimitSupplier.getAsLong();  
    private void incrementNodeLimitBreachedRejectionCount(RejectionTracker rejectionTracker) {  
    long getTotalThroughputDegradationLimitsBreachedRejections() {
                ShardIndexingPressureTracker::getPrimaryAndCoordinatingLimits,
            tracker::getReplicaLimits,  
            incrementNodeLimitBreachedRejectionCount(tracker.getCoordinatingOperationTracker().getRejectionTracker());
                    return false;
     */
                operationTracker.getStatsTracker(),
 * This helps identify detect any duress state with the shard, requesting more memory.
        Setting.Property.Dynamic  
                        shardId.getIndexName(),
    }
    private volatile double upperOperatingFactor;
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()
    ) {
            tracker::compareAndSetPrimaryAndCoordinatingLimits,  
        this.nodeSoftLimit = nodeSoftLimit;  
            && (requestStartTime - performanceTracker.getLastSuccessfulRequestTimestamp()) > this.successfulRequestElapsedTimeout.nanos()  
            );  
     */  
    /**  
        ToLongFunction<ShardIndexingPressureTracker> getShardLimitFunction,  
        return true;  
 *
    }
    Map<ShardId, ShardIndexingPressureTracker> getShardIndexingPressureColdStore() {
        double throughputHistoricalAverage = (double) statsTracker.getTotalBytes() / performanceTracker.getLatencyInMillis();
        return totalNodeLimitsBreachedRejections.get();
    );
    }
            return !isShardLimitsIncreased;
        Setting.Property.NodeScope,  
    private void setSuccessfulRequestElapsedTimeout(TimeValue successfulRequestElapsedTimeout) {
    }
        this.primaryAndCoordinatingThroughputDegradationLimits = THROUGHPUT_DEGRADATION_LIMITS.get(settings).doubleValue();
     * This determines the max outstanding request that are yet to be processed successfully. Appropriate
    boolean isReplicaShardLimitBreached(ShardIndexingPressureTracker tracker, long nodeReplicaBytes, long requestStartTime) {  
        } while (!updateShardLimitPredicate.test(currentShardLimit, newShardLimit));  
        TimeValue.timeValueMillis(300000),
    }  
                return true;
    }
        this.upperOperatingFactor = UPPER_OPERATING_FACTOR.get(settings).doubleValue();
import org.opensearch.core.index.shard.ShardId;
            return true;
            return false;
        this.primaryAndCoordinatingThroughputDegradationLimits = throughputDegradationLimits;
            return onShardLimitBreached(
 * <p>
            "Decreased Shard Limit [shard_detail=[{}][{}], " + "old_shard_limit_bytes={}, new_shard_limit_bytes={}]",
                    .sum();
            shardIndexingPressureSettings.getShardPrimaryAndCoordinatingBaseLimits()
    );  
                return;
        );  
        0.0d,
        );  
     */  
                        + "expected_shard_limit_bytes={}]",
            return onShardLimitBreached(
    long getTotalLastSuccessfulRequestLimitsBreachedRejections() {
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
    Map<ShardId, ShardIndexingPressureTracker> getShardIndexingPressureHotStore() {
            tracker.getShardId(),  
    }
            BooleanSupplier increaseShardLimitSupplier = () -> increaseShardLimits(
            && throughputHistoricalAverage / throughputMovingAverage > degradationLimits;
                    newShardLimit  
 * The Shard Indexing Pressure Memory Manager is the construct responsible for increasing and decreasing the allocated shard limit  
        // Shard memory limits is breached when the current utilization is greater than operating_factor.upper limit.
        this.shardIndexingPressureStore = new ShardIndexingPressureStore(shardIndexingPressureSettings, clusterSettings, settings);  
                    .stream()
                increaseShardLimitSupplier  
            return ((Double.longBitsToDouble(currentAverage) * count) + currentValue - frontValue) / count;  
        this.optimalOperatingFactor = optimalOperatingFactor;  
    /**  
            );
     * Checks if the shard level memory threshold is breached for primary operations.
    }  
/**
public class ShardIndexingPressureMemoryManager {
            tracker::compareAndSetReplicaLimits,
    private volatile double replicaThroughputDegradationLimits;
                    logger.debug(
    ) {
                return true;
                    currentShardLimit,
                ShardIndexingPressureTracker::getPrimaryAndCoordinatingLimits,
        long shardReplicaLimits = tracker.getReplicaLimits();  
            if (shardThroughputDegradationLimitsBreached) {
            () -> tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
    public static final Setting<Double> NODE_SOFT_LIMIT = Setting.doubleSetting(  
            tracker::getPrimaryAndCoordinatingLimits,
        decreaseShardLimits(  
 * is considered to be breached.  
        Setting.Property.Dynamic  
    private volatile double lowerOperatingFactor;  
    private boolean increaseShardLimits(
     */
        Setting.Property.Dynamic  
    }
            );
            BooleanSupplier increaseShardLimitSupplier = () -> increaseShardLimits(  
    );
     * lower, optimal and upper boundary, and appropriate action is taken once the below defined threshold values are breached.
        this.replicaThroughputDegradationLimits = this.primaryAndCoordinatingThroughputDegradationLimits * 1.5;  
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()  
        ShardIndexingPressureSettings shardIndexingPressureSettings,
     * Checks if the node level memory threshold is breached for replica operations.  
    );
            return !isShardLimitsIncreased;  
 * this file be licensed under the Apache-2.0 license or a
    }
        // the current node utilization is greater than primary_parameter.node.soft_limit of total node limits.
    private final ShardIndexingPressureStore shardIndexingPressureStore;
 * timeout threshold value, while there a number of outstanding requests greater than the max outstanding requests then this parameter
                }
        long requestStartTime,
                tracker::compareAndSetPrimaryAndCoordinatingLimits  
 * parameter is considered to be breached.  
     * Checks if the node level memory threshold is breached for primary operations.
                newShardLimit = (long) (shardCurrentBytes / this.optimalOperatingFactor);
        PerformanceTracker performanceTracker,
import org.opensearch.common.settings.Settings;
        "shard_indexing_pressure.secondary_parameter.throughput.degradation_factor",
                        + "current_shard_limit_bytes={}, "
    void decreaseShardPrimaryAndCoordinatingLimits(ShardIndexingPressureTracker tracker) {
    double calculateMovingAverage(long currentAverage, double frontValue, double currentValue, int count) {
                            + "expected_shard_limits_bytes={}]",  
    private void setNodeSoftLimit(double nodeSoftLimit) {
        } else {
    private static final Logger logger = LogManager.getLogger(ShardIndexingPressureMemoryManager.class);  
        if (nodeTotalBytes > this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits()) {
    boolean isCoordinatingShardLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes, long requestStartTime) {
    ShardIndexingPressureTracker getShardIndexingPressureTracker(ShardId shardId) {  
            long shardCurrentBytes = shardCurrentBytesSupplier.getAsLong();  
        BooleanSupplier increaseShardLimitSupplier  
        double degradationLimits
    }
    boolean isReplicaNodeLimitBreached(ShardIndexingPressureTracker tracker, long nodeReplicaBytes) {
            );  
        );
        }
    }
        clusterSettings.addSettingsUpdateConsumer(UPPER_OPERATING_FACTOR, this::setUpperOperatingFactor);  
            if (((double) shardCurrentBytes / currentShardLimit) > this.lowerOperatingFactor) {  
            if (shardLastSuccessfulRequestDurationLimitsBreached) {
            boolean isShardLimitsIncreased = increaseShardLimitSupplier.getAsBoolean();
     * Verifies and returns true if the shard limit is hard-breached i.e. shard limit cannot be increased further. Otherwise
        Setting.Property.NodeScope,
     * This evaluation returns true if the difference in the current timestamp and last successful request timestamp is greater than  
            );  
            incrementNodeLimitBreachedRejectionCount(tracker.getPrimaryOperationTracker().getRejectionTracker());
 * remains within the operating_factor.optimal range of current shard utilization.
            currentShardLimit,
    /**
    boolean isPrimaryNodeLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes) {  
    }
        return shardIndexingPressureStore.getShardIndexingPressureColdStore();  
        clusterSettings.addSettingsUpdateConsumer(NODE_SOFT_LIMIT, this::setNodeSoftLimit);
        this.optimalOperatingFactor = OPTIMAL_OPERATING_FACTOR.get(settings).doubleValue();
    public static final Setting<Double> OPTIMAL_OPERATING_FACTOR = Setting.doubleSetting(
        } else {
 * 2. LastSuccessfulRequestDurationLimitsBreached - When the time since the last successful request completed is greater than the max
     * increases the shard limit and returns false.
    public static final Setting<Double> UPPER_OPERATING_FACTOR = Setting.doubleSetting(
            currentShardLimit = shardLimitSupplier.getAsLong();
                ShardIndexingPressureTracker::getReplicaLimits,  
    );  
 */  
        double throughputMovingAverage = Double.longBitsToDouble(performanceTracker.getThroughputMovingAverage());  
        } else {  
        clusterSettings.addSettingsUpdateConsumer(LOWER_OPERATING_FACTOR, this::setLowerOperatingFactor);  
 * SPDX-License-Identifier: Apache-2.0
                "Node limits breached for primary operation [node_total_bytes={}, " + "node_primary_and_coordinating_limits={}]",  
                    shardId.id(),
    private void decreaseShardLimits(  
    }
 * goes above operating_factor.upper of current shard limits. MemoryManager attempts to update the new shard limit such that the new value  
    private volatile TimeValue successfulRequestElapsedTimeout;
        clusterSettings.addSettingsUpdateConsumer(THROUGHPUT_DEGRADATION_LIMITS, this::setThroughputDegradationLimits);
            newShardLimit
}
        "shard_indexing_pressure.secondary_parameter.successful_request.max_outstanding_requests",
    }  
        long nodeLimit,  
    /**
                    .mapToLong(getShardLimitFunction)
                requestStartTime,  
    private volatile int maxOutstandingRequests;
     * Checks if the shard level memory threshold is breached for coordinating operations.  
        } else {
        this.successfulRequestElapsedTimeout = SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.get(settings);
     * action is taken once the below defined threshold value is breached.
        long currentShardLimit;  
    /**
    public static final Setting<Integer> MAX_OUTSTANDING_REQUESTS = Setting.intSetting(
import org.opensearch.common.settings.Setting;
        "shard_indexing_pressure.operating_factor.lower",
            currentShardLimit,  
        Setting.Property.Dynamic
 * based on incoming requests. A shard limits defines the maximum memory that a shard can occupy in the heap for request objects.
        shardIndexingPressureStore.tryTrackerCleanupFromHotStore(tracker, condition);
        long currentShardLimit;
        );
        this.successfulRequestElapsedTimeout = successfulRequestElapsedTimeout;
        long newShardLimit;  
                    "Shard Limits Already Decreased ["
        return false;  
    private final AtomicLong totalLastSuccessfulRequestLimitsBreachedRejections = new AtomicLong();  
     * The node level soft limit determines when the secondary parameters for shard is to be evaluated for degradation.
    }
        boolean shardMemoryLimitsBreached = ((double) shardCombinedBytes / shardPrimaryAndCoordinatingLimits) > this.upperOperatingFactor;
                operationTracker.getRejectionTracker().incrementThroughputDegradationLimitsBreachedRejections();  
        this.replicaThroughputDegradationLimits = this.primaryAndCoordinatingThroughputDegradationLimits * 1.5;
            logger.debug(
        }  
        5.0d,  
 * 2. If the limits assigned to the shard is breached(Primary Parameter) and the node level overall occupancy across all shards
        return false;
        return totalLastSuccessfulRequestLimitsBreachedRejections.get();
        // Shard memory limits is breached when the current utilization is greater than operating_factor.upper limit.  
                tracker::compareAndSetPrimaryAndCoordinatingLimits
import org.apache.logging.log4j.LogManager;
    /**  
import org.opensearch.index.ShardIndexingPressureTracker.StatsTracker;
    }
            );
    public static final Setting<Double> LOWER_OPERATING_FACTOR = Setting.doubleSetting(  
                return true;
            );
                    .map(Map.Entry::getValue)  
                nodeReplicaBytes,  
            shardId.getIndexName(),
            "Increased Shard Limit [" + "shard_detail=[{}][{}], old_shard_limit_bytes={}, " + "new_shard_limit_bytes={}]",  
        Setting.Property.NodeScope,
    public ShardIndexingPressureMemoryManager(  
    boolean isCoordinatingNodeLimitBreached(ShardIndexingPressureTracker tracker, long nodeTotalBytes) {
 *
                increaseShardLimitSupplier
     * Shard operating factor can be evaluated using currentShardBytes/shardLimits. Outcome of this expression is categorized as  
    ) {
            logger.debug(
    }  
        this.nodeSoftLimit = NODE_SOFT_LIMIT.get(settings).doubleValue();  
                requestStartTime,
        this.maxOutstandingRequests = MAX_OUTSTANDING_REQUESTS.get(settings).intValue();
                tracker.getPrimaryOperationTracker(),  
                operationTracker.getRejectionTracker().incrementLastSuccessfulRequestLimitsBreachedRejections();  
        this.lowerOperatingFactor = LOWER_OPERATING_FACTOR.get(settings).doubleValue();
        }
            boolean isShardLimitsIncreased = increaseShardLimitSupplier.getAsBoolean();  
     */
import org.opensearch.index.ShardIndexingPressureTracker.OperationTracker;
                            + "shard_current_limit_bytes={}, "
     */
 * 1. ThroughputDegradationLimitsBreached - When the moving window throughput average has increased by a factor compared to
                nodeTotalBytes,  
 * <p>
        BiPredicate<Long, Long> updateShardLimitPredicate
import org.opensearch.index.ShardIndexingPressureTracker.RejectionTracker;
            newShardLimit = Math.max((long) (shardCurrentBytes / this.optimalOperatingFactor), shardBaseLimit);
     */
    ) {  
        0.0d,  
            shardId.getIndexName(),
                nodeReplicaBytes,
    private final AtomicLong totalThroughputDegradationLimitsBreachedRejections = new AtomicLong();
            incrementNodeLimitBreachedRejectionCount(tracker.getReplicaOperationTracker().getRejectionTracker());  
     * once the below below defined threshold value is breached.  
        Setting.Property.Dynamic
                tracker.getCoordinatingOperationTracker(),
                if (totalShardLimitsExceptCurrentShard + newShardLimit > nodeLimit) {
            BooleanSupplier increaseShardLimitSupplier = () -> increaseShardLimits(
import java.util.concurrent.atomic.AtomicLong;
     */
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
                        "Failed To Increase Shard Limit [shard_detail=[{}][{}}], "  
        0.95d,
    }
    /**
    private volatile double nodeSoftLimit;
     * the successful request elapsed-timeout threshold, and the total number of outstanding requests is greater than
        this.upperOperatingFactor = upperOperatingFactor;
     * where N being {@link ShardIndexingPressureSettings#REQUEST_SIZE_WINDOW}, divided by lifetime average throughput.
        0.0d,  
    }  
                primaryAndCoordinatingThroughputDegradationLimits
                );
     */  
    private final AtomicLong totalNodeLimitsBreachedRejections = new AtomicLong();
    private void setOptimalOperatingFactor(double optimalOperatingFactor) {
                () -> tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),  
        0.7d,
    }
/*  
        }
            }  
        boolean shardMemoryLimitsBreached = ((double) shardCombinedBytes / shardPrimaryAndCoordinatingLimits) > this.upperOperatingFactor;  
    private void setLowerOperatingFactor(double lowerOperatingFactor) {
 */
        LongSupplier shardLimitSupplier,  
            );
                operationTracker.getPerformanceTracker(),
        ClusterSettings clusterSettings,
    }
                        totalShardLimitsExceptCurrentShard,
    }
     * Degradation for a shard can be evaluated using average throughput of last N requests,  
    }  
                tracker.getShardId(),  
        rejectionTracker.incrementNodeLimitsBreachedRejections();
        } else {
    }  
        // Shard memory limits is breached when the current utilization is greater than operating_factor.upper limit.
            }  
    void tryTrackerCleanupFromHotStore(ShardIndexingPressureTracker tracker, BooleanSupplier condition) {  
                operationTracker.getPerformanceTracker(),  
                this.shardIndexingPressureSettings.getNodeReplicaLimits(),  
        if (nodeReplicaBytes > this.shardIndexingPressureSettings.getNodeReplicaLimits()) {  
        return totalThroughputDegradationLimitsBreachedRejections.get();  
        LongSupplier shardCurrentBytesSupplier,
        if (shardMemoryLimitsBreached) {
    /**
                nodeTotalBytes,
        return shardIndexingPressureStore.getShardIndexingPressureHotStore();
        this.maxOutstandingRequests = maxOutstandingRequests;  
 * is not greater than primary_parameter.node.soft_limit, MemoryManager will increase the shard limits without any deeper evaluation.  
                tracker.getShardId(),
        logger.debug(  
        // Secondary Parameters (i.e. LastSuccessfulRequestDuration and Throughput) is taken into consideration when  
        long shardReplicaBytes = tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes();
        this.totalNodeLimitsBreachedRejections.incrementAndGet();
        if (((double) nodeTotalBytes / nodeLimit) < this.nodeSoftLimit) {
            boolean shardLastSuccessfulRequestDurationLimitsBreached = evaluateLastSuccessfulRequestDurationLimitsBreached(  
        if (count > 0) {
                            + "total_shard_limits_bytes_except_current_shard={}, "
     * the maximum outstanding request-count threshold.
        long shardCombinedBytes = tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes();
            logger.debug(  
            );  
            }
        LongSupplier shardCurrentBytesSupplier,
        long shardCombinedBytes = tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes();  
        ShardId shardId,
                tracker::getPrimaryAndCoordinatingLimits,
        Setting.Property.NodeScope,
                this.shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits(),
                    .filter(entry -> (shardId != entry.getKey()))
 * issues, such as throughput degradation (Secondary Parameter - 1) and time since last request was successful (Secondary Parameter - 2).  
                long totalShardLimitsExceptCurrentShard = this.shardIndexingPressureStore.getShardIndexingPressureHotStore()
                logger.debug(
import java.util.Map;
        return (performanceTracker.getLastSuccessfulRequestTimestamp() > 0)
        Setting.Property.NodeScope,
        }  
 * @opensearch.internal  
     * Checks if the shard level memory threshold is breached for replica operations.
    }  
        LongSupplier shardLimitSupplier,
    long getTotalNodeLimitsBreachedRejections() {  
            newShardLimit
        "shard_indexing_pressure.operating_factor.upper",  
        long newShardLimit;
        "shard_indexing_pressure.primary_parameter.node.soft_limit",
import java.util.function.BooleanSupplier;
 * The OpenSearch Contributors require contributions made to  
 * 1. If the limits assigned to a shard is breached (Primary Parameter) while the node level overall occupancy across all shards
    /**
    );
        BiPredicate<Long, Long> updateShardLimitPredicate,
            return currentValue;
        return shardIndexingPressureStore.getShardIndexingPressureTracker(shardId);
                    );  
            && performanceTracker.getTotalOutstandingRequests() > this.maxOutstandingRequests;
 * <p>
                nodeTotalBytes,
        Setting.Property.Dynamic
    /**
                this.totalThroughputDegradationLimitsBreachedRejections.incrementAndGet();
import java.util.function.BiPredicate;  
            }  
    /**  
                () -> tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes(),
        long shardPrimaryAndCoordinatingLimits = tracker.getPrimaryAndCoordinatingLimits();
    public static final Setting<TimeValue> SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT = Setting.positiveTimeSetting(
        0.0d,
    private boolean evaluateThroughputDegradationLimitsBreached(
        "shard_indexing_pressure.operating_factor.optimal",
import org.opensearch.common.unit.TimeValue;  
            shardIndexingPressureSettings.getShardReplicaBaseLimits()
        }
