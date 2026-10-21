    private void calculateRequestThroughput(
        OperationTracker operationTracker
            .shardIndexingPressureEnabled(shardIndexingPressureSettings.isShardIndexingPressureEnabled())
            .totalNodeLimitsBreachedRejections(memoryManager.getTotalNodeLimitsBreachedRejections())
        long shardCombinedBytes = tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(bytes);
    ShardIndexingPressureTracker getShardIndexingPressureTracker(ShardId shardId) {
            markShardOperationComplete(bytes, requestStartTime, isShadowModeBreach, tracker.getReplicaOperationTracker());
    }
        ShardId shardId = tracker.getShardId();
                    tracker.getCoordinatingOperationTracker().getRejectionTracker(),
        long shardTotalBytes,
        long nodeCombinedBytes = currentCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
            if (nodeLevelLimitBreached == false) {
    public Releasable markCoordinatingOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {
            boolean nodeLevelLimitBreached = memoryManager.isCoordinatingNodeLimitBreached(tracker, nodeTotalBytes);
                + "shard_detail=["
                + replicaLimits
            }
    ShardIndexingPressureStats coldStats() {
                + "node_operation_bytes="
    }
        boolean isShadowModeBreach = shardLevelLimitBreached;
            .shardIndexingPressureEnabled(shardIndexingPressureSettings.isShardIndexingPressureEnabled())
                primaryRejections.getAndIncrement();
        long bytes,
        }
            .shardIndexingPressureEnforced(shardIndexingPressureSettings.isShardIndexingPressureEnforced())
        }
                bytes,
            if (nodeLevelLimitBreached == false) {
            .build();
        boolean isShadowModeBreach,
                );
        statsTracker.incrementTotalBytes(bytes);
        return new ShardIndexingPressureStats.Builder().shardIndexingPressureStore(statsPerShard)
                + "node_max_coordinating_and_primary_bytes="
        StatsTracker statsTracker
 *
        totalPrimaryBytes.addAndGet(bytes);
    }
                rejectShardRequest(
                + tracker.getPrimaryAndCoordinatingLimits()
        statsTracker.incrementRequestCount();
        commonOperationTracker.incrementCurrentCombinedCoordinatingAndPrimaryBytes(-bytes);
            "rejected execution of "
        if (requestLatency > 0) {
        long requestStartTime,
import org.opensearch.index.ShardIndexingPressureTracker.PerformanceTracker;
                + "shard_max_coordinating_and_primary_bytes="
        boolean isShadowModeBreach,
import org.opensearch.index.stats.IndexingPressurePerShardStats;
        for (Map.Entry<ShardId, ShardIndexingPressureTracker> shardEntry : memoryManager.getShardIndexingPressureHotStore().entrySet()) {
                coordinatingRejections.getAndIncrement();
 * 3. Interfaces to access the statistics for shard trackers.
        this.memoryManager = new ShardIndexingPressureMemoryManager(shardIndexingPressureSettings, clusterSettings, settings);
            IndexingPressurePerShardStats shardStats = new IndexingPressurePerShardStats(shardEntry.getValue(), isEnforcedMode);
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);
        tracker.getPrimaryOperationTracker().getStatsTracker().incrementCurrentBytes(bytes);
            .totalLastSuccessfulRequestLimitsBreachedRejections(memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections())
 */
                + bytes
import org.opensearch.common.settings.Settings;
                shardLevelLimitBreached = memoryManager.isCoordinatingShardLimitBreached(tracker, nodeTotalBytes, requestStartTime);
        } else {
                + "shard_max_replica_bytes="
            return () -> {};
        memoryManager.tryTrackerCleanupFromHotStore(
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
            );
import java.util.concurrent.TimeUnit;
 * @opensearch.internal
                shardLevelLimitBreached = memoryManager.isPrimaryShardLimitBreached(tracker, nodeTotalBytes, requestStartTime);
        if (0 == bytes) {
            }
        StatsTracker statsTracker,
            boolean nodeLevelLimitBreached = memoryManager.isPrimaryNodeLimitBreached(tracker, nodeTotalBytes);
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);
        return new ShardIndexingPressureStats.Builder().shardIndexingPressureStore(Collections.emptyMap())
        OperationTracker operationTracker,
                    bytes,
 */
            markShardOperationComplete(
                shardIndexingPressureSettings.getRequestSizeWindow()
                + "], "
import java.util.concurrent.atomic.AtomicBoolean;
    private void tryReleaseTracker(ShardIndexingPressureTracker tracker) {
import java.util.Map;
        if (0 == bytes) {
import java.util.Collections;
        StatsTracker statsTracker = tracker.getPrimaryOperationTracker().getStatsTracker();
                tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(-bytes);
            }
        }
            currentPrimaryBytes.addAndGet(-bytes);
 * perform necessary actions such as throughput evaluation once the request completes.
        long nodeCombinedBytes = currentCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
        totalPrimaryBytes.addAndGet(bytes);
    public ShardIndexingPressureStats shardStats(CommonStatsFlags statsFlags) {
                    tracker,
        tracker.getPrimaryOperationTracker().getStatsTracker().incrementTotalBytes(bytes);
        Map<ShardId, IndexingPressurePerShardStats> statsPerShard = new HashMap<>();
                currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);
    private void adjustPerformanceUponCompletion(
}
        if (statsFlags.includeOnlyTopIndexingPressureMetrics()) {
/**
        long requestStartTime = System.nanoTime();
        throw new OpenSearchRejectedExecutionException(
        return wrapReleasable(() -> {
 * Consumers of these interfaces are expected to trigger close on releasable, reliably for consistency.
                + "]["
        long requestStartTime,
import org.opensearch.common.lease.Releasable;
 * <p>
        }
                rejectShardRequest(
            double movingAverage = (double) statsTracker.getTotalBytes() / performanceTracker.getLatencyInMillis();
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        }
                logger.error("ShardIndexingPressure Release is called twice", new IllegalStateException("Releasable is called twice"));
                requestStartTime,
                tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(-bytes);
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);
    ) {
                + shardId.id()
import org.opensearch.index.ShardIndexingPressureTracker.OperationTracker;
        long nodeReplicaBytes = currentReplicaBytes.get();
        PerformanceTracker performanceTracker,
                requestStartTime,
            return topStats();
        long nodeReplicaBytes = currentReplicaBytes.get();
 * The interfaces provided by this class will be used by Transport Action layers to start accounting for an incoming request.
                allStats.addAll(coldStats());
    private void markShardOperationComplete(
            ShardIndexingPressureStats allStats = shardStats();
                && tracker.getReplicaOperationTracker().getStatsTracker().getCurrentBytes() == 0)
        markShardOperationStarted(statsTracker, tracker.getReplicaOperationTracker().getPerformanceTracker());
                );
            IndexingPressurePerShardStats shardStats = new IndexingPressurePerShardStats(shardEntry.getValue(), isEnforcedMode);
            }
        StatsTracker statsTracker = tracker.getReplicaOperationTracker().getStatsTracker();
import org.opensearch.index.ShardIndexingPressureTracker.CommonOperationTracker;
        };
                    "coordinating"
        currentPrimaryBytes.addAndGet(bytes);
        long bytes,
    }
        return wrapReleasable(() -> {
            currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);
        long nodeTotalBytes = nodeCombinedBytes + nodeReplicaBytes;
                );
        boolean shardLevelLimitBreached = false;
    public boolean isShardIndexingPressureEnabled() {
            memoryManager.decreaseShardReplicaLimits(tracker);
                    tracker,
        long bytes,
        totalReplicaBytes.addAndGet(bytes);
        statsTracker.incrementCurrentBytes(-bytes);
            .totalNodeLimitsBreachedRejections(memoryManager.getTotalNodeLimitsBreachedRejections())
            .totalThroughputDegradationLimitsBreachedRejections(memoryManager.getTotalThroughputDegradationLimitsBreachedRejections())
        totalCoordinatingBytes.addAndGet(bytes);
                + ", "
                performanceTracker.getThroughputMovingAverage(),
            );
                replicaRejections.getAndIncrement();
            currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);
        CommonOperationTracker commonOperationTracker
                bytes,
            if (shouldRejectRequest(nodeLevelLimitBreached, shardLevelLimitBreached)) {
        long shardCombinedBytes = tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(bytes);
    public Releasable markPrimaryOperationLocalToCoordinatingNodeStarted(ShardId shardId, long bytes) {
                    bytes,
            tryReleaseTracker(tracker);
                    tracker,
    }
        }
        PerformanceTracker performanceTracker
                tracker.getPrimaryOperationTracker(),
        long nodeReplicaBytes = currentReplicaBytes.addAndGet(bytes);
        super(settings);
    }
        performanceTracker.incrementTotalOutstandingRequests();
            if (nodeLevelLimitBreached == false) {
        long bytes,
    }
import org.opensearch.index.ShardIndexingPressureTracker.StatsTracker;
            return () -> {};
        // In shadow mode if request was intended to be rejected, we do not account it for dynamic rejection parameters
                + tracker.getReplicaLimits()
            .totalThroughputDegradationLimitsBreachedRejections(memoryManager.getTotalThroughputDegradationLimitsBreachedRejections())
            tryReleaseTracker(tracker);
            performanceTracker.updateThroughputMovingAverage(Double.doubleToLongBits(movingAverage));
            .totalLastSuccessfulRequestLimitsBreachedRejections(memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections())
                currentCombinedCoordinatingAndPrimaryBytes.addAndGet(-bytes);
import org.opensearch.core.index.shard.ShardId;
        return nodeLevelLimitBreached || (shardLevelLimitBreached && shardIndexingPressureSettings.isShardIndexingPressureEnforced());
        long nodeTotalBytes,
            currentReplicaBytes.addAndGet(-bytes);
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
            markShardOperationComplete(
                + ", "
            .shardIndexingPressureEnforced(isEnforcedMode)
            .totalLastSuccessfulRequestLimitsBreachedRejections(memoryManager.getTotalLastSuccessfulRequestLimitsBreachedRejections())
    ShardIndexingPressure(Settings settings, ClusterService clusterService) {
            if (statsFlags.includeAllShardIndexingPressureTrackers()) {
    }
            boolean nodeLevelLimitBreached = memoryManager.isReplicaNodeLimitBreached(tracker, nodeReplicaBytes);
                + "shard_total_bytes="
        StatsTracker statsTracker = tracker.getCoordinatingOperationTracker().getStatsTracker();
        statsTracker.incrementCurrentBytes(bytes);
    private void markShardOperationComplete(
                + primaryAndCoordinatingLimits
        markShardOperationStarted(statsTracker, tracker.getCoordinatingOperationTracker().getPerformanceTracker());
                tracker.getCommonOperationTracker()
    }
                    nodeTotalBytes,
import org.opensearch.cluster.service.ClusterService;
        }
            false
    }
        performanceTracker.updateLastSuccessfulRequestTimestamp(requestEndTime);
    ShardIndexingPressureStats topStats() {
                    shardCombinedBytes,
        rejectionTracker.incrementTotalRejections();
        boolean isEnforcedMode = shardIndexingPressureSettings.isShardIndexingPressureEnforced();
                tracker.getCommonOperationTracker()
        markShardOperationStarted(statsTracker, tracker.getPrimaryOperationTracker().getPerformanceTracker());
    }
    ShardIndexingPressureStats shardStats() {
    }
        });
        ShardIndexingPressureTracker tracker,
        performanceTracker.addLatencyInMillis(requestLatency);
            () -> (tracker.getCommonOperationTracker().getCurrentCombinedCoordinatingAndPrimaryBytes() == 0
                + ", "
        if (forceExecution == false) {
            double movingAverage = memoryManager.calculateMovingAverage(
                + ", "
        long requestLatency,
            .build();
    ) {
        return () -> {
                    nodeTotalBytes,
            if (shouldRejectRequest(nodeLevelLimitBreached, shardLevelLimitBreached)) {
        commonOperationTracker.incrementTotalCombinedCoordinatingAndPrimaryBytes(bytes);
/*
    }
        if (isShadowModeBreach == false) {
        totalCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
    private boolean shouldRejectRequest(boolean nodeLevelLimitBreached, boolean shardLevelLimitBreached) {
 * Overall ShardIndexingPressure provides:
    }
                + nodeBytesWithoutOperation
                + "]",
        StatsTracker statsTracker = operationTracker.getStatsTracker();
import org.opensearch.index.stats.ShardIndexingPressureStats;
                + bytes
        }
                shardLevelLimitBreached = memoryManager.isReplicaShardLimitBreached(tracker, nodeReplicaBytes, requestStartTime);
            }
            }
        totalCombinedCoordinatingAndPrimaryBytes.addAndGet(bytes);
            tryReleaseTracker(tracker);
                + ", "
        statsTracker.incrementCurrentBytes(bytes);
    ) {
package org.opensearch.index;
                releasable.close();
                currentReplicaBytes.addAndGet(-bytes);
        );
            .build();
        return wrapReleasable(() -> {
                assert false : "ShardIndexingPressure Release is called twice";
                front,
            }
        );
 * Shard Indexing Pressure is a framework level artefact build on top of IndexingPressure to track incoming indexing request, per shard.
                    nodeReplicaBytes,
 * Interfaces returns Releasable which when triggered will release the acquired accounting tokens values and also
            .shardIndexingPressureEnforced(isEnforcedMode)
        long bytes,
        } else {
                + "shard_operation_bytes="
        performanceTracker.addNewThroughout(requestThroughput);
                requestThroughput,
            return () -> {};
    private static final Logger logger = LogManager.getLogger(ShardIndexingPressure.class);
            }
            .shardIndexingPressureEnabled(shardIndexingPressureSettings.isShardIndexingPressureEnabled())
            adjustPerformanceUponCompletion(bytes, requestStartTime, statsTracker, operationTracker.getPerformanceTracker());
 * 1. Memory Accounting at shard level. This can be enabled/disabled based on dynamic setting.
    private void rejectShardRequest(
            tracker,
            tracker.getPrimaryOperationTracker().getStatsTracker().incrementCurrentBytes(-bytes);
                isShadowModeBreach,
                rejectShardRequest(
        long requestStartTime,
        return new ShardIndexingPressureStats.Builder().shardIndexingPressureStore(statsPerShard)
public class ShardIndexingPressure extends IndexingPressure {
        });
        Map<ShardId, IndexingPressurePerShardStats> statsPerShard = new HashMap<>();
                tracker.getCoordinatingOperationTracker(),
        long shardBytesWithoutOperation = shardTotalBytes - bytes;
        if (performanceTracker.getThroughputMovingQueueSize() > shardIndexingPressureSettings.getRequestSizeWindow()) {
        return memoryManager.getShardIndexingPressureTracker(shardId);
                    tracker.getPrimaryOperationTracker().getRejectionTracker(),
        long nodeBytesWithoutOperation = nodeTotalBytes - bytes;
        long requestStartTime = System.nanoTime();
            currentPrimaryBytes.addAndGet(-bytes);
    }
                + shardBytesWithoutOperation
            if (shouldRejectRequest(nodeLevelLimitBreached, shardLevelLimitBreached)) {
            memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker);
    ) {
    private final ShardIndexingPressureSettings shardIndexingPressureSettings;
        return wrapReleasable(() -> {
 * SPDX-License-Identifier: Apache-2.0
        });
    }
                    "replica"
        String operationType
    private static Releasable wrapReleasable(Releasable releasable) {
            statsPerShard.put(shardEntry.getKey(), shardStats);
            currentCoordinatingBytes.addAndGet(-bytes);
            calculateRequestThroughput(bytes, requestLatency, performanceTracker, statsTracker);
            if (called.compareAndSet(false, true)) {
        performanceTracker.resetTotalOutstandingRequests();
                + "node_total_bytes="
        RejectionTracker rejectionTracker,
                + ", "
        });
            statsPerShard.put(shardEntry.getKey(), shardStats);
        boolean isShadowModeBreach = shardLevelLimitBreached;
                    shardCombinedBytes,
    private final ShardIndexingPressureMemoryManager memoryManager;
        boolean isEnforcedMode = shardIndexingPressureSettings.isShardIndexingPressureEnforced();
            );
                + "node_max_replica_bytes="
        long requestEndTime = System.nanoTime();
                tracker.getCommonOperationTracker().incrementCurrentCombinedCoordinatingAndPrimaryBytes(-bytes);
            .totalNodeLimitsBreachedRejections(memoryManager.getTotalNodeLimitsBreachedRejections())
        if (bytes == 0) {
 * 2. Memory Accounting at Node level. Tracking is done using the IndexingPressure artefacts to support feature seamless toggling.
        final AtomicBoolean called = new AtomicBoolean();
    }
                    bytes,
    public Releasable markReplicaOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {
        }
            } else {
 * Copyright OpenSearch Contributors.
                + shardId.getIndexName()
        markShardOperationComplete(bytes, requestStartTime, isShadowModeBreach, operationTracker);
        return shardIndexingPressureSettings.isShardIndexingPressureEnabled();
        if (forceExecution == false) {
        }
import org.opensearch.index.ShardIndexingPressureTracker.RejectionTracker;
        boolean shardLevelLimitBreached = false;
                isShadowModeBreach,
    }
                    tracker.getReplicaOperationTracker().getRejectionTracker(),
            performanceTracker.updateThroughputMovingAverage(Double.doubleToLongBits(movingAverage));
            return allStats;
                + operationType
        for (Map.Entry<ShardId, ShardIndexingPressureTracker> shardEntry : memoryManager.getShardIndexingPressureColdStore().entrySet()) {
        currentPrimaryBytes.addAndGet(bytes);
        long requestLatency = TimeUnit.NANOSECONDS.toMillis(requestEndTime - requestStartTime);
        boolean isShadowModeBreach = shardLevelLimitBreached;
        double requestThroughput = (double) bytes / requestLatency;
    ) {
        long nodeTotalBytes = nodeCombinedBytes + nodeReplicaBytes;
            memoryManager.decreaseShardPrimaryAndCoordinatingLimits(tracker);
                    shardReplicaBytes,
        shardIndexingPressureSettings = new ShardIndexingPressureSettings(clusterService, settings, primaryAndCoordinatingLimits);
        if (0 == bytes) {
        long shardReplicaBytes = tracker.getReplicaOperationTracker().getStatsTracker().incrementCurrentBytes(bytes);
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
        }
        currentCoordinatingBytes.addAndGet(bytes);
    }
                + " operation ["
import org.opensearch.common.settings.ClusterSettings;
        boolean shardLevelLimitBreached = false;
            return () -> {};
    }
    private void markShardOperationStarted(StatsTracker statsTracker, PerformanceTracker performanceTracker) {
    public Releasable markPrimaryOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {
            double front = performanceTracker.getFirstThroughput();
        long requestStartTime = System.nanoTime();
                    "primary"
            .totalThroughputDegradationLimitsBreachedRejections(memoryManager.getTotalThroughputDegradationLimitsBreachedRejections())
                + "] OR ["
        ShardIndexingPressureTracker tracker = getShardIndexingPressureTracker(shardId);
        if (forceExecution == false) {
        }
