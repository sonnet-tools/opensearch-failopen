                shardLevelLimitBreached = memoryManager.isCoordinatingShardLimitBreached(tracker, nodeTotalBytes, requestStartTime);
            .totalNodeLimitsBreachedRejections(memoryManager.getTotalNodeLimitsBreachedRejections())
        StatsTracker statsTracker = operationTracker.getStatsTracker();  
            .totalThroughputDegradationLimitsBreachedRejections(memoryManager.getTotalThroughputDegradationLimitsBreachedRejections())
                + bytes
                + "node_max_replica_bytes="
        performanceTracker.incrementTotalOutstandingRequests();  
import org.opensearch.index.stats.ShardIndexingPressureStats;
            false
            );  
        PerformanceTracker performanceTracker,  
    ShardIndexingPressureStats topStats() {  
        memoryManager.tryTrackerCleanupFromHotStore(
        }  
        return new ShardIndexingPressureStats.Builder().shardIndexingPressureStore(statsPerShard)  
        }  
            statsPerShard.put(shardEntry.getKey(), shardStats);
    }
    private final ShardIndexingPressureSettings shardIndexingPressureSettings;
        return wrapReleasable(() -> {  
            }  
import org.opensearch.index.ShardIndexingPressureTracker.OperationTracker;
public class ShardIndexingPressure extends IndexingPressure {
import org.opensearch.common.settings.ClusterSettings;  
                + "]["
            .totalNodeLimitsBreachedRejections(memoryManager.getTotalNodeLimitsBreachedRejections())
        ShardIndexingPressureTracker tracker,
            if (shouldRejectRequest(nodeLevelLimitBreached, shardLevelLimitBreached)) {
        );  
/*  
        totalCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
                + nodeBytesWithoutOperation
    private static Releasable wrapReleasable(Releasable releasable) {  
                rejectShardRequest(
        boolean shardLevelLimitBreached = false;  
        RejectionTracker rejectionTracker,
        });  
            double movingAverage = (double) statsTracker.getTotalBytes() / performanceTracker.getLatencyInMillis();  
            );  
 * perform necessary actions such as throughput evaluation once the request completes.
                + "]",  
        long nodeTotalBytes = nodeCombinedBytes + nodeReplicaBytes;  
        if (forceExecution == false) {
    }
import java.util.Map;
        }
import java.util.concurrent.atomic.AtomicBoolean;
                + "shard_detail=["
            performanceTracker.updateThroughputMovingAverage(Double.doubleToLongBits(movingAverage));
        long requestStartTime,
                    tracker.getPrimaryOperationTracker().getRejectionTracker(),
            );  
import org.opensearch.index.ShardIndexingPressureTracker.RejectionTracker;
                && tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes() == 0)
                + tracker.getReplicaLimits()
            IndexingPressurePerShardStats shardStats = new IndexingPressurePerShardStats(shardEntry.getValue(), isEnforcedMode);  
        long requestLatency = TimeUnit.NANOSECONDS.toMillis(requestEndTime - requestStartTime);
        totalCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
        if (0 == bytes) {
                primaryRejections.getAndIncrement();
            .shardIndexingPressureEnforced(shardIndexingPressureSettings.isShardIndexingPressureEnforced())  
        long shardReplicaBytes = tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(bytes);
        markShardOperationStarted(statsTracker, tracker.getCoordinatingOperationTracker().getPerformanceTracker());  
            .shardIndexingPressureEnforced(isEnforcedMode)
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
    private final ShardIndexingPressureMemoryManager memoryManager;  
        long nodeReplicaBytes = currentReplicaBytes.get();
    public boolean isShardIndexingPressureEnabled() {
            .totalLastSuccessfulRequestLimitsBreachedRejections(memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections())  
                + bytes
        statsTracker.incrementCurrentBytes(-bytes);
        }
            double movingAverage = memoryManager.calculateMovingAverage(
                bytes,
                + "shard_max_coordinating_and_primary_bytes="
                requestStartTime,
        }
        if (performanceTracker.getThroughputMovingQueueSize() > shardIndexingPressureSettings.getRequestSizeWindow()) {
        ShardId shardId = tracker.getShardId();
                tracker.getCommonOperationTracker()
                    shardReplicaBytes,
        });  
 * Consumers of these interfaces are expected to trigger close on releasable, reliably for consistency.
        boolean isShadowModeBreach,
    ) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                );
            } else {
            }
    }
        performanceTracker.updateLastSuccessfulRequestTimestamp(requestEndTime);
            adjustPerformanceUponCompletion(bytes, requestStartTime, statsTracker, operationTracker.getPerformanceTracker());  
import org.opensearch.index.stats.IndexingPressurePerShardStats;  
        totalPrimaryBytes.addAndGet(bytes);
 * Overall ShardIndexingPressure provides:
                coordinatingRejections.getAndIncrement();
            if (shouldRejectRequest(nodeLevelLimitBreached, shardLevelLimitBreached)) {
            .shardIndexingPressureEnabled(shardIndexingPressureSettings.isShardIndexingPressureEnabled())
        if (requestLatency > 0) {
            tryReleaseTracker(tracker);
            currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);
        statsTracker.incrementCurrentBytes(bytes);
        double requestThroughput = (double) bytes / requestLatency;  
        currentPrimaryBytes.addAndGet(bytes);
    public Releasable markReplicaOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {  
        totalReplicaBytes.addAndGet(bytes);
            markShardOperationComplete(  
            if (nodeLevelLimitBreached == false) {  
                    tracker.getReplicaOperationTracker().getRejectionTracker(),
        final AtomicBoolean called = new AtomicBoolean();
 * @opensearch.internal  
    ) {
        boolean isShadowModeBreach = shardLevelLimitBreached;
        if (forceExecution == false) {
            .totalThroughputDegradationLimitsBreachedRejections(memoryManager.getTotalThroughputDegradationLimitsBreachedRejections())
        }  
            }
        return memoryManager.getShardIndexingPressureTracker(shardId);
            currentPrimaryBytes.addAndGet(-bytes);
            return () -> {};
            IndexingPressurePerShardStats shardStats = new IndexingPressurePerShardStats(shardEntry.getValue(), isEnforcedMode);
        shardIndexingPressureSettings = new ShardIndexingPressureSettings(clusterService, settings, primaryAndCoordinatingLimits);
        currentCoordinatingBytes.addAndGet(bytes);  
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);  
        commonOperationTracker.incrementCurrentCombinedCoordinatingAndPrimaryBytes(-bytes);  
    }
        if (forceExecution == false) {
    private void rejectShardRequest(  
        long nodeCombinedBytes = currentCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
                logger.error("ShardIndexingPressure Release is called twice", new IllegalStateException("Releasable is called twice"));  
            boolean nodeLevelLimitBreached = memoryManager.isCoordinatingNodeLimitBreached(tracker, nodeTotalBytes);
        long requestStartTime,
                + "shard_max_replica_bytes="
    ) {
        for (Map.Entry<ShardId, ShardIndexingPressureTracker> shardEntry : memoryManager.getShardIndexingPressureColdStore().entrySet()) {
        long requestStartTime,
            tryReleaseTracker(tracker);
                    nodeReplicaBytes,  
                releasable.close();
                front,  
 * Interfaces returns Releasable which when triggered will release the acquired accounting tokens values and also  
            memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker);
    private boolean shouldRejectRequest(boolean nodeLevelLimitBreached, boolean shardLevelLimitBreached) {  
import org.opensearch.common.settings.Settings;
                );  
    private void markShardOperationComplete(
        return new ShardIndexingPressureStats.Builder().shardIndexingPressureStore(statsPerShard)
        } else {
        Map<ShardId, IndexingPressurePerShardStats> statsPerShard = new HashMap<>();  
        }
        OperationTracker operationTracker  
        statsTracker.incrementTotalBytes(bytes);
                    bytes,
        long requestEndTime = System.nanoTime();  
                    nodeTotalBytes,
                requestThroughput,
            calculateRequestThroughput(bytes, requestLatency, performanceTracker, statsTracker);
            if (nodeLevelLimitBreached == false) {
        }
                    bytes,
        if (statsFlags.includeOnlyTopIndexingPressureMetrics()) {  
 * The interfaces provided by this class will be used by Transport Action layers to start accounting for an incoming request.
    }
        long bytes,
                + "node_operation_bytes="
    }  
        StatsTracker statsTracker = tracker.getPrimaryOperationTracker().getStatsTracker();
import org.opensearch.core.index.shard.ShardId;  
    }
        // In shadow mode if request was intended to be rejected, we do not account it for dynamic rejection parameters
        performanceTracker.addNewThroughout(requestThroughput);
        statsTracker.incrementRequestCount();
        performanceTracker.resetTotalOutstandingRequests();
                rejectShardRequest(
            .build();
                rejectShardRequest(  
    }  
        long shardCombinedBytes = tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(bytes);
    }
import org.opensearch.common.lease.Releasable;
                isShadowModeBreach,  
import org.opensearch.index.ShardIndexingPressureTracker.StatsTracker;
                    shardCombinedBytes,  
/**  
 * Copyright OpenSearch Contributors.
        };  
                shardLevelLimitBreached = memoryManager.isPrimaryShardLimitBreached(tracker, nodeTotalBytes, requestStartTime);
                + "] OR ["  
        markShardOperationComplete(bytes, requestStartTime, isShadowModeBreach, operationTracker);
    private void markShardOperationComplete(
        long bytes,
        }
            boolean nodeLevelLimitBreached = memoryManager.isPrimaryNodeLimitBreached(tracker, nodeTotalBytes);
            .totalLastSuccessfulRequestLimitsBreachedRejections(memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections())  
                    tracker,
 * 2. Memory Accounting at Node level. Tracking is done using the IndexingPressure artefacts to support feature seamless toggling.  
        long bytes,  
 * <p>  
    }
    }  
        boolean shardLevelLimitBreached = false;  
        long requestStartTime = System.nanoTime();
        tracker.getPrimaryOperationTracker().getStatsTracker().incrementCurrentBytes(bytes);  
            if (shouldRejectRequest(nodeLevelLimitBreached, shardLevelLimitBreached)) {
        if (0 == bytes) {
        boolean isEnforcedMode = shardIndexingPressureSettings.isShardIndexingPressureEnforced();  
    ) {
    }
                assert false : "ShardIndexingPressure Release is called twice";
        String operationType  
        }  
        throw new OpenSearchRejectedExecutionException(
    }  
        commonOperationTracker.incrementTotalCombinedCoordinatingAndPrimaryBytes(bytes);
            currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);
        PerformanceTracker performanceTracker
import java.util.HashMap;
            if (statsFlags.includeAllShardIndexingPressureTrackers()) {
        return new ShardIndexingPressureStats.Builder().shardIndexingPressureStore(Collections.emptyMap())
        rejectionTracker.incrementTotalRejections();  
                    tracker,  
        long bytes,  
 * 1. Memory Accounting at shard level. This can be enabled/disabled based on dynamic setting.
                tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(-bytes);
                    tracker,  
import java.util.concurrent.TimeUnit;  
            memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker);
        long shardCombinedBytes = tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(bytes);
        tracker.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(bytes);
                currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);  
        long bytes,
        currentPrimaryBytes.addAndGet(bytes);  
                shardLevelLimitBreached = memoryManager.isReplicaShardLimitBreached(tracker, nodeReplicaBytes, requestStartTime);
import org.apache.logging.log4j.LogManager;
                );  
        return wrapReleasable(() -> {  
}
        return nodeLevelLimitBreached || (shardLevelLimitBreached && shardIndexingPressureSettings.isShardIndexingPressureEnforced());
                + "shard_total_bytes="
            .totalLastSuccessfulRequestLimitsBreachedRejections(memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections())
                tracker.getPrimaryOperationTracker(),
                tracker.getCoordinatingOperationTracker(),
                + shardId.getIndexName()  
        return () -> {
        statsTracker.incrementCurrentBytes(bytes);
                    nodeTotalBytes,
    public Releasable markCoordinatingOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {  
            if (nodeLevelLimitBreached == false) {  
            currentReplicaBytes.addAndGet(-bytes);
        StatsTracker statsTracker = tracker.getReplicaOperationTracker().getStatsTracker();  
            .build();
        StatsTracker statsTracker
                tracker.getCommonOperationTracker()
                tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(-bytes);
    ShardIndexingPressureTracker getShardIndexingPressureTracker(ShardId shardId) {
        if (0 == bytes) {
                + ", "  
                replicaRejections.getAndIncrement();  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
                + "node_total_bytes="
    public Releasable markPrimaryOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {  
                + shardBytesWithoutOperation
    ShardIndexingPressureStats coldStats() {
                + replicaLimits
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);  
                    "replica"  
                    "primary"
            statsPerShard.put(shardEntry.getKey(), shardStats);
    }
            "rejected execution of "
        return wrapReleasable(() -> {
                + operationType  
                bytes,
    }
                + ", "  
        boolean isShadowModeBreach = shardLevelLimitBreached;
        long requestStartTime = System.nanoTime();
    ) {
                currentReplicaBytes.addAndGet(-bytes);
    }
            return allStats;
            () -> (tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes() == 0
                shardIndexingPressureSettings.getRequestSizeWindow()
        long nodeTotalBytes = nodeCombinedBytes + nodeReplicaBytes;  
                currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);  
        super(settings);  
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);
                    tracker.getCoordinatingOperationTracker().getRejectionTracker(),
        StatsTracker statsTracker,  
                + ", "  
            currentCoordinatingBytes.addAndGet(-bytes);
import org.opensearch.index.ShardIndexingPressureTracker.CommonOperationTracker;
                    "coordinating"
        markShardOperationStarted(statsTracker, tracker.getPrimaryOperationTracker().getPerformanceTracker());  
            .shardIndexingPressureEnabled(shardIndexingPressureSettings.isShardIndexingPressureEnabled())
    }
 * Shard Indexing Pressure is a framework level artefact build on top of IndexingPressure to track incoming indexing request, per shard.
            markShardOperationComplete(  
        markShardOperationStarted(statsTracker, tracker.getReplicaOperationTracker().getPerformanceTracker());
                + "], "  
                + ", "  
                + primaryAndCoordinatingLimits
        boolean isEnforcedMode = shardIndexingPressureSettings.isShardIndexingPressureEnforced();
            tracker,  
            tracker.getPrimaryOperationTracker().getStatsTracker().incrementCurrentBytes(-bytes);
    public ShardIndexingPressureStats shardStats(CommonStatsFlags statsFlags) {
            return () -> {};
import org.opensearch.index.ShardIndexingPressureTracker.PerformanceTracker;  
    }  
        long shardTotalBytes,
        totalCoordinatingBytes.addAndGet(bytes);
        long requestLatency,
            markShardOperationComplete(bytes, requestStartTime, isShadowModeBreach, tracker.getReplicaOperationTracker());  
    private static final Logger logger = LogManager.getLogger(ShardIndexingPressure.class);
            .totalNodeLimitsBreachedRejections(memoryManager.getTotalNodeLimitsBreachedRejections())
                + shardId.id()
        for (Map.Entry<ShardId, ShardIndexingPressureTracker> shardEntry : memoryManager.getShardIndexingPressureHotStore().entrySet()) {  
 */
                + "node_max_coordinating_and_primary_bytes="
    ShardIndexingPressureStats shardStats() {
        return wrapReleasable(() -> {  
        }  
        boolean isShadowModeBreach = shardLevelLimitBreached;
                allStats.addAll(coldStats());
        OperationTracker operationTracker,  
        StatsTracker statsTracker = tracker.getCoordinatingOperationTracker().getStatsTracker();
            return () -> {};
 *
        if (isShadowModeBreach == false) {
        totalPrimaryBytes.addAndGet(bytes);
            .shardIndexingPressureEnforced(isEnforcedMode)  
        });  
        return shardIndexingPressureSettings.isShardIndexingPressureEnabled();  
            currentPrimaryBytes.addAndGet(-bytes);
        if (bytes == 0) {
    private void markShardOperationStarted(StatsTracker statsTracker, PerformanceTracker performanceTracker) {
    private void adjustPerformanceUponCompletion(  
        performanceTracker.addLatencyInMillis(requestLatency);  
                performanceTracker.getThroughputMovingAverage(),
    }
        } else {
 * 3. Interfaces to access the statistics for shard trackers.
        boolean shardLevelLimitBreached = false;
                    bytes,
    private void tryReleaseTracker(ShardIndexingPressureTracker tracker) {
        });  
 * SPDX-License-Identifier: Apache-2.0
            .totalThroughputDegradationLimitsBreachedRejections(memoryManager.getTotalThroughputDegradationLimitsBreachedRejections())  
            return topStats();
                + "shard_operation_bytes="
        long nodeReplicaBytes = currentReplicaBytes.get();
                requestStartTime,
 */  
        );
    public Releasable markPrimaryOperationLocalToCoordinatingNodeStarted(ShardId shardId, long bytes) {  
        long nodeBytesWithoutOperation = nodeTotalBytes - bytes;
            return () -> {};
        }  
    ShardIndexingPressure(Settings settings, ClusterService clusterService) {
        }  
            .build();  
            memoryManager.decreaseShardReplicaLimits(tracker);
            if (called.compareAndSet(false, true)) {  
        this.memoryManager = new ShardIndexingPressureMemoryManager(shardIndexingPressureSettings, clusterSettings, settings);  
import java.util.Collections;  
            .shardIndexingPressureEnabled(shardIndexingPressureSettings.isShardIndexingPressureEnabled())
import org.opensearch.cluster.service.ClusterService;
                isShadowModeBreach,  
        Map<ShardId, IndexingPressurePerShardStats> statsPerShard = new HashMap<>();
    }
package org.opensearch.index;
                + " operation ["
    private void calculateRequestThroughput(  
            }
        long nodeCombinedBytes = currentCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
            performanceTracker.updateThroughputMovingAverage(Double.doubleToLongBits(movingAverage));
            tryReleaseTracker(tracker);
            }
        CommonOperationTracker commonOperationTracker
        long shardBytesWithoutOperation = shardTotalBytes - bytes;  
            boolean nodeLevelLimitBreached = memoryManager.isReplicaNodeLimitBreached(tracker, nodeReplicaBytes);  
                + ", "  
            }
        long requestStartTime = System.nanoTime();
        boolean isShadowModeBreach,
            ShardIndexingPressureStats allStats = shardStats();  
                    shardCombinedBytes,  
            }
        long nodeReplicaBytes = currentReplicaBytes.addAndGet(bytes);
                tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(-bytes);
            double front = performanceTracker.getFirstThroughput();  
                + tracker.getPrimaryAndCoordinatingLimits()
import org.apache.logging.log4j.Logger;
            }  
                + ", "  
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);  
        long nodeTotalBytes,  
