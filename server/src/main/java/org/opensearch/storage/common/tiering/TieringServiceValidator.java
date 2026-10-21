    private static final double CLUSTER_WRITE_BLOCK_THRESHOLD_MULTIPLIER = 0.2;
     * Calculates effective available bytes on a node after accounting for buffer space and write-block threshold.
        ClusterInfo clusterInfo,
                .append("] since we don't have [")
            } else if (availableBytes > nextMaxAvailableBytes) {
        if (isCurrentStateValid == false) {
            .collect(Collectors.toSet());
        Set<String> targetNodeIds = getTargetTierNodes(clusterState, targetTier).stream()
     * @throws IllegalArgumentException if there isn't enough space on at least two nodes to accommodate
import org.opensearch.cluster.node.DiscoveryNode;
        final IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(index);
        Integer jvmActiveUsageThresholdPercent,
import java.util.List;
                continue;
     * Validates that the index is not in RED health status before tiering operation.
            String targetState = currentTieringType.equals(HOT_TO_WARM) ? "WARM" : "HOT";
import org.opensearch.cluster.routing.IndexRoutingTable;
        return stats != null && stats.getActivePercent() > fileCacheActiveUsageThreshold;
     * - RELOCATING shards
                tieringIndex -> (getReplicaCount(clusterState, tieringIndex) + 1) * getIndexPrimaryStoreSize(
        ClusterState clusterState,
                nextMaxAvailableBytes = availableBytes;
        final ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
    ) {
        String index,
    /**
        Index index
                + "]";
        Index index,
        IndexModule.TieringState targetTier
            .allMatch(node -> isNodeExceedingFileCacheThreshold(fileCacheStatsMap, node, fileCacheActiveUsageThreshold));
                .append(finalIndexType.toString())
            HOT
            .filter(WARM.equals(targetTier) ? DiscoveryNode::isWarmNode : node -> !node.isWarmNode())
        final IndexMetadata indexMetadata = clusterState.metadata().index(index);
    ) {
    private static void validateRemoteStoreEnabled(ClusterState clusterState, Index index) {
            WARM_TO_HOT,
            throw new TieringRejectionException(
    protected static void validateWarmNodeDiskThresholdWaterMarkLow(
    }
            clusterState,
     *
            totalAddressableSpaceExcludingLowWatermark += Math.max(
import org.opensearch.cluster.routing.ShardRoutingState;
        ClusterState clusterState,
    ) {
    }
        ClusterInfo clusterInfo,
            final ValidationException e = new ValidationException();
public class TieringServiceValidator {
 * Validator for tiering service operations in OpenSearch.
     * - Include if the shard is currently on a warm node but target tier is not warm
            throw new TieringRejectionException(RejectionReason.INVALID_TIER_TRANSITION, new IllegalArgumentException(message));
import java.util.stream.Collectors;
        // Add space for incoming tiering request index
                + "] because there are no nodes found with the warm role";
     * operation. Validation of the final tiering state is performed before calling this method.
            );
        final Map<String, DiscoveryNode> nodes = clusterState.getNodes().getDataNodes();
            }
    private static int getReplicaCount(ClusterState clusterState, Index index) {
 * SPDX-License-Identifier: Apache-2.0
        validateRemoteStoreEnabled(clusterState, index);
                )
/**
        return totalAvailableBytes;
            .sum();
                nextMaxAvailableBytes = maxAvailableBytes;
     */
        }
                .append(HOT)
    public static void validateWarmToHotTiering(
        NodeResourceUsageStats stats = nodeStats.get(node.getId());
    }
    ) {
     */
     * This validation ensures there are available nodes in the target tier with sufficient
        final IndexModule.TieringState currentTieringType
        // if replica count is not 1 we need to account for shard size of primary only
     */
     * Calculates the total size of the specified index in the cluster
        int indexSizeMultiplier = getReplicaCount(clusterState, index) + 1;
    }
        Integer fileCacheActiveUsageThreshold,
    private static void validateWarmNodes(final ClusterState clusterState, final Index index) {
    /**
        Index index,
        Map<String, NodeResourceUsageStats> nodeStats = clusterInfo.getNodeResourceUsageStats();
        final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
    /**
                RejectionReason.CCR_INDEX_REJECTION,
        IndexModule.TieringState targetTier,
            throw new TieringRejectionException(RejectionReason.INSUFFICIENT_SPACE_WARM, new IllegalArgumentException(errorMsg));
     * @param currentTieringIndices The current number of indices undergoing tiering operations.
        ClusterState clusterState,
        // TODO: We need to make this validation strict by excluding nodes from the excluded DI
    }
    }
        final ClusterState state,
            if (nodeDiskUsage == null) {
        boolean isTargetTierWarm = WARM.equals(targetTier);
            String errorMsg = "Rejecting tiering request as FileCache Active Usage is high on all Warm nodes";
     *
    ) {
            clusterInfo.getNodeLeastAvailableDiskUsages(),
     *
     * @return array where [0] is largest and [1] is second-largest available space
     * Enforces backpressure on tiering operations to prevent system overload.
            .stream()
        if (currentTieringIndices >= maxConcurrentTieringRequests) {
        if (tieringIndices.isEmpty() == false) {
        Integer maxConcurrentTieringRequests,
import org.opensearch.cluster.routing.allocation.DiskThresholdEvaluator;
                    + "Index must be in %s tier to perform this migration.",
        ClusterState clusterState,
        }
        if (totalAddressableSpaceExcludingLowWatermark - tieringShardSizes - indexPrimaryStoreSize <= 0) {
    public static void checkJVMMemoryUtilizationThreshold(
     * @throws IllegalArgumentException if warm nodes lack sufficient space
        return Integer.parseInt(indexMetadata.getSettings().get(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey()));
        );
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
        ClusterState clusterState,
    public static void validateCCRIndex(ClusterState currentState, Index index, IndexModule.TieringState finalIndexType) {
     * Validates a hot-to-warm tiering request including common checks, disk threshold, and file cache usage.
     * - Include if the shard is currently on a hot node but target tier is warm
        Map<String, NodeResourceUsageStats> nodeStats,
            currentState,
        Set<Index> tieringIndices
            if (maxAvailableBytes <= availableBytes) {
        long maxNodeCapacity = 0L;
    }
                    clusterState,
import java.util.Locale;
     * @param clusterInfo the current nodes usage info for the cluster
    private static void validateShardLimit(
    /**
     */
        final Optional<String> shardLimit = shardLimitValidator.checkShardLimit(
        }
     */
                .append("].")
        final Map<String, DiskUsage> usages,
                totalShardSizes += getIndexPrimaryStoreSize(clusterState, clusterInfo, index.getName(), WARM);
import java.util.Optional;
        long maxAvailableBytes = Long.MIN_VALUE;
    /**
    ) {
        ClusterInfo clusterInfo,
    private static final long DEFAULT_FALLBACK_SHARD_SIZE = 0L;
        }
        ClusterInfo clusterInfo,
            clusterState,
     * @param clusterState current cluster state
    /**
        Set<DiscoveryNode> targetNodes = getTargetTierNodes(clusterState, WARM);
        return largestShardBytes;
                continue;
        long bufferSpace
            shardLimitValidator
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
        long totalBytes = Math.max(0, diskUsage.getTotalBytes());
     *                              the largest shard (for primary and replica placement)
    }
            }
                + "] because there are too many in-flight tiering requests of type ["
        Integer jvmActiveUsageThresholdPercent,
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        if (targetIndexType.equals(IndexModule.TieringState.WARM)) {
     *
     */
            clusterInfo,
        }
     *
     * @param index index to validate
    private static boolean isNodeExceedingJVMThreshold(
            String errorMsg = "Rejecting tiering request for index ["
            .map(DiscoveryNode::getId)
        long freeBytes = Math.max(0, diskUsage.getFreeBytes());
     */
    ) {
     */
     * @param clusterState current cluster state
        Set<Index> tieringIndices,
        ClusterState clusterState,
        boolean isCurrentStateValid = true;
        long bufferSpace
            logger.warn(
            .mapToLong(shard -> clusterInfo.getShardSize(shard, DEFAULT_FALLBACK_SHARD_SIZE))
        IndexModule.TieringState targetTier,
                + index.getName()
                    + totalAvailableBytesInTargetTier
        ClusterInfo clusterInfo,
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
        validateIndexCurrentState(clusterState, index, tieringType);
 */
        Index requestIndex,
     */
        Integer tieringIndicesSize,
        // find the size of largest shard of this index
                RejectionReason.INSUFFICIENT_SPACE_HOT,
        validateSpaceForLargestShard(clusterState, clusterInfo, index, HOT, MIN_DISK_SPACE_BUFFER);
            throw new TieringRejectionException(
     */
                largestShardBytes,
                + index.getName()
                    + " available bytes - "
        ClusterState clusterState,
        }
        }
                + index.getName()
        long totalAvailableBytes = 0;
                .append("] node with free space to fit it's largest shard");
        Set<DiscoveryNode> targetNodes = getTargetTierNodes(clusterState, targetIndexType);
    }
        ClusterState clusterState,
        }
    }
        return clusterState.routingTable()
        validateIndexHealth(clusterState, index, targetIndexType);
     * @param clusterState the current cluster state
     * Validates if warm nodes have sufficient disk space after considering watermark settings
import org.opensearch.indices.ShardLimitValidator;
        ClusterInfo clusterInfo,
        // checkFileCacheActiveUsage(clusterState,clusterInfo, fileCacheActiveUsageThreshold);
            throw new TieringRejectionException(RejectionReason.INDEX_RED_STATUS, new IllegalArgumentException(errorMsg));
                maxAvailableBytes = availableBytes;
            final StringBuilder errorMsgBuilder = new StringBuilder("Rejecting migration request for index [").append(index)
            throw new TieringRejectionException(RejectionReason.NO_WARM_NODES, new IllegalArgumentException(errorMsg));
    /**
                    HOT
     * @throws OpenSearchRejectedExecutionException If the number of current tiering operations
    private static void enforceBackpressure(
    }
            final String errorMsg = "Rejecting tiering request because index [" + index.getName() + "] does not have remote store enabled";
                currentTieringType.equals(HOT_TO_WARM) ? "HOT" : "WARM"
            .map(DiscoveryNode::getId)
        if (requestIndexBytes + totalTieringIndicesBytes >= totalAvailableBytesInTargetTier) {
        DiscoveryNode node,
        if (ClusterHealthStatus.RED.equals(indexHealth.getStatus())) {
        Integer fileCacheActiveUsageThreshold
        ClusterInfo clusterInfo,
        ClusterInfo clusterInfo,
import org.opensearch.common.ValidationException;
import org.apache.logging.log4j.Logger;
        DiskThresholdEvaluator diskThresholdEvaluator,
        }
                .append(HOT)
                    + "Total "
        if (!shard.state().equals(ShardRoutingState.STARTED)) {
        return new long[] { maxAvailableBytes, nextMaxAvailableBytes };
    }
import static org.opensearch.index.IndexModule.TieringState.WARM;
                    + requestIndexBytes
     * - Any shard not in STARTED state
            final StringBuilder errorMsgBuilder = new StringBuilder("Rejecting migration request because index [").append(index.getName())
    public static void validateCommon(
    protected static void validateSpaceForLargestShard(
import java.util.Map;
     * Validates a warm-to-hot tiering request including common checks, hot node capacity, and largest shard space.
     * Performs common validations for warm to hot tiering operations.
     * Note: This function only accounts for the following conditions :
                .append("] capacity. Please add more ")
     * @param clusterInfo cluster disk usage information
}
import org.opensearch.cluster.ClusterInfo;
            || (currentTieringType.equals(WARM_TO_HOT) && indexState.equals(WARM.toString()) == false)) {
     */
        ClusterInfo clusterInfo,
     * Validates that there are eligible nodes with the warm role in the current cluster state.
     * @param index The index for which the tiering operation is being requested.
            }
     * @param tieringIndices ongoing/pending tiering operations
     */
            isCurrentStateValid = false;
    ) {
        }
        long totalAddressableSpaceExcludingLowWatermark = 0L;
        final Settings settings = indexMetadata.getSettings();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                indexState,
        long bufferSpace
        return Math.max(0, freeBytes - bufferBytes);
                .append(targetTier)
    /** Returns the highest available disk space among nodes in the target tier. */
    }
     * Calculates the largest and second-largest available disk space among nodes in the target tier.
    }
                nodeDiskUsage.getFreeBytes() - diskThresholdEvaluator.getFreeSpaceLowThreshold(nodeDiskUsage.getTotalBytes())
     * @param targetTier Target tier where the index will be moved
     * @param clusterState the current state of the cluster
     * Performs common validations for hot to warm tiering operations.
     */
            );
            DiskUsage diskUsage = clusterInfo.getNodeLeastAvailableDiskUsages().get(nodeId);
                errorMsgBuilder.toString()
            );
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;
        long bufferBytes = Math.round(Math.min(bufferSpace, totalBytes * CLUSTER_WRITE_BLOCK_THRESHOLD_MULTIPLIER));
            );
            );
        Index index,
        final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
            shardLimitValidator
import org.apache.logging.log4j.LogManager;
        boolean isRemoteStoreEnabled = indexMetadata.getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false);
 *
        final int numberOfShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
                    + ", "
    static long getTotalAvailableBytesInTargetTier(
        validateCommon(
        return totalShardSizes;
            maxConcurrentTieringRequests,
    }
        ClusterState clusterState,
        AggregateFileCacheStats stats = fileCacheStatsMap.get(node.getId());
     * @param state the current cluster state
            jvmActiveUsageThresholdPercent,
        Integer currentTieringIndices,
        }
     * @param clusterInfo cluster disk usage and shard locations
        long largestShardBytes = getLargestShardBytes(clusterState, clusterInfo, requestIndex.getName());
    ) {
    }
        ShardLimitValidator shardLimitValidator
    /**
    }
    /** Calculates total primary shard sizes for all indices currently undergoing tiering. */
        for (String nodeId : eligibleNodeIds) {
            long availableBytes = calculateEffectiveAvailableBytes(diskUsage, bufferSpace);
            HOT_TO_WARM,
            final String errorMsg = "Rejecting tiering request because index ["
    private static long calculateEffectiveAvailableBytes(DiskUsage diskUsage, long bufferSpace) {
            throw new TieringRejectionException(
        validateWarmNodeDiskThresholdWaterMarkLow(clusterState, clusterInfo, tieringIndices, index, diskThresholdEvaluator);
     */
            final StringBuilder errorMsgBuilder = new StringBuilder("Rejecting migration request for index [").append(requestIndex)
            maxConcurrentTieringRequests,
/*
 * compatible open source license.
        return stats != null && stats.getMemoryUtilizationPercent() >= jvmActiveUsageThresholdPercent;
            }
            throw new TieringRejectionException(RejectionReason.REMOTE_STORE_NOT_ENABLED, new IllegalArgumentException(errorMsg));
        boolean allNodesExceededFileCacheThreshold = targetNodes.stream()
            );
        ClusterState currentState,
 * this file be licensed under the Apache-2.0 license or a
     * @param diskThresholdEvaluator warm node disk evaluator
        ClusterInfo clusterInfo,
            maxNodeCapacity = getHighestNodeCapacity(clusterState, clusterInfo, targetTier, bufferSpace);
    /**
     * @return the total size of the specified index in the cluster
        long nextMaxAvailableBytes = Long.MIN_VALUE;
                Locale.ROOT,
        IndexModule.TieringState targetTier,
        if (fileCacheStatsMap == null) return false;
        }
                RejectionReason.LARGEST_SHARD_SPACE_INSUFFICIENT,
            .sum();
        IndexModule.TieringState finalIndexType,
        enforceBackpressure(index, tieringIndicesSize, maxConcurrentTieringRequests, tieringType);
import org.opensearch.storage.common.tiering.TieringRejectionException.RejectionReason;
    private static long getSecondHighestNodeCapacity(
        }
     * and ongoing tiering operations. Only runs when remote data ratio is non-zero.
    /**
    /**
                + "]";
            if (diskUsage == null) {
        final Index index,
            logger.warn(
     * @param shard The shard routing to evaluate
                index.getName(),
    }
     * 2. If in STARTED state then should not be assigned to the target tier node
        ClusterState clusterState,
            String message = String.format(
     * Validates that the specified index is in the required initial tiering state for the requested
        Map<String, AggregateFileCacheStats> fileCacheStatsMap,
                .append(" nodes");
     * 1. should be a primary shard
        final IndexMetadata indexMetadata = clusterState.metadata().index(index);
     *
                    + totalTieringIndicesBytes
                .append("To avoid migration failures, Stop cross-cluster-replication for this index and retry.");
     * @throws IllegalArgumentException if there are no eligible warm nodes in the cluster
     * @param clusterState Current state of the cluster containing node information
    // Visible for Testing
    /**
import org.opensearch.cluster.DiskUsage;
    /** Returns the size in bytes of the largest primary shard for the given index. */
                0,
        IndexModule.TieringState tieringType,
                    + HOT
     * Validates that the cluster shard limit will not be exceeded after tiering.
            jvmActiveUsageThresholdPercent,
                    tieringIndex.getName(),
        // 1. Get available space in target tier
        ClusterState clusterState,
     * Validates that the index has remote store enabled before tiering operation.
                RejectionReason.CONCURRENT_LIMIT_EXCEEDED,
     */
        IndexModule.TieringState targetIndexType,
import org.opensearch.cluster.routing.ShardRouting;
        ClusterState clusterState,
    }
        final IndexMetadata indexMetadata = clusterState.metadata().getIndexSafe(index);
import org.opensearch.index.IndexModule;
import org.opensearch.cluster.health.ClusterHealthStatus;
    protected static void validateEligibleHotNodesCapacity(
        DiscoveryNode node,
            throw new TieringRejectionException(RejectionReason.HIGH_FILE_CACHE_UTILIZATION, new IllegalArgumentException(errorMsg));
            maxNodeCapacity = getSecondHighestNodeCapacity(clusterState, clusterInfo, targetTier, bufferSpace);
                "Details of node capacity and shard size: LargestShardSize: {}, MaxAvailableBytesOnNode: {}",
 * The OpenSearch Contributors require contributions made to
        if (maxNodeCapacity < largestShardBytes) {
            shardsToCreate,
     * @param clusterInfo Information about the cluster's current state including disk usage
    /**
        Integer jvmActiveUsageThresholdPercent,
     * @param currentTieringType the requested tiering transition
    private static final long MIN_DISK_SPACE_BUFFER = 20 * GB_IN_BYTES;
    }
     * The following shards are always included:
    }
        validateCommon(
                long currentShardBytes = Math.max(0, clusterInfo.getShardSize(shardRouting, DEFAULT_FALLBACK_SHARD_SIZE));
        IndexModule.TieringState targetTier,
     * @throws IllegalArgumentException if all nodes in the target tier exceed the JVM memory threshold
        ClusterInfo clusterInfo,
     *
        long requestIndexBytes = indexSizeMultiplier * getIndexPrimaryStoreSize(clusterState, clusterInfo, index.getName(), HOT);
            throw new TieringRejectionException(
        );
            for (Index index : tieringIndices) {
        }
        long tieringShardSizes = calculateShardSizesForTieringIndices(clusterState, clusterInfo, tieringIndices);
        return calculateTopTwoAvailableSpaces(clusterState, clusterInfo, targetTier, bufferSpace)[1];
            clusterState,
     * - UNASSIGNED shards
        Index index,
        Index index,
            throw new TieringRejectionException(RejectionReason.SHARD_LIMIT_EXCEEDED, e);
    private static final Logger logger = LogManager.getLogger(TieringServiceValidator.class);
 */
import org.opensearch.cluster.metadata.IndexMetadata;
    ) {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
     * @param bufferSpace required buffer space
    /**
        // Accounting the risk of cluster-write-block if the below threshold is breached.
    }
import static org.opensearch.storage.common.tiering.TieringUtils.isCCRFollowerIndex;
        // We have required nodes to place replicas of largest shard
    ) {
            throw new TieringRejectionException(RejectionReason.HIGH_JVM_UTILIZATION, new IllegalArgumentException(errorMsg));
                    + HOT
                new IllegalArgumentException(errorMsgBuilder.toString())
        ClusterInfo clusterInfo,
        long bufferSpace
            index,
import org.opensearch.common.settings.Settings;
     * @param index the name of the indices being validated
     * @param targetTier target tier to analyze
                + finalIndexType.toString()
    /**
     *
     * @param clusterInfo  the current nodes usage info for the cluster
    private static boolean shouldIncludeShard(ClusterState clusterState, ShardRouting shard, IndexModule.TieringState targetTier) {
     * @param requestIndex Name of the index being validated
            e.addValidationError(shardLimit.get());
     */
        Integer fileCacheActiveUsageThreshold
        validateEligibleHotNodesCapacity(clusterState, clusterInfo, tieringIndices, index);
        }
    private static long calculateShardSizesForTieringIndices(
        IndexModule.TieringState targetIndexType
            DiskUsage nodeDiskUsage = usages.get(node.getId());
    ) {
        ShardLimitValidator shardLimitValidator
            .mapToLong(
        long largestShardBytes = Long.MIN_VALUE;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
                .append("] since we don't have enough [")
        for (String node : targetNodeIds) {
            );
     * @param clusterState Current state of the cluster
     *
    /**
            HOT,
        for (ShardRouting shardRouting : shardRoutings) {
                    + " tieringQueue capacity to be utilized - "
     * @param index        the name of the index for which the total size is to be calculated
     */
     *         equals or exceeds the migration queue size, indicating system overload.
            finalIndexType == HOT ? RoutingPool.LOCAL_ONLY : RoutingPool.REMOTE_CAPABLE
            .filter(ShardRouting::primary)
     * 3. If UNASSIGNED/RELOCATING, should be considered
        ShardLimitValidator shardLimitValidator
     * This validation ensures that both primary and replica shards can be placed on different nodes with adequate space.
     */
     * Returns totalAvailableBytes across all nodes in the target tier
import org.opensearch.cluster.health.ClusterIndexHealth;
     * Returns set of nodes eligible for target tier operations.
            String errorMsg = "Rejecting migration request for index [" + index + "] since we don't have enough space on all warm nodes";
        validateShardLimit(clusterState, index, targetIndexType, shardLimitValidator);
    ) {
        Integer maxConcurrentTieringRequests,
     */
        validateCCRIndex(clusterState, index, tieringType);
        IndexModule.TieringState targetTier
     * Determines whether a shard should be included in the tier calculation based on its state and current location.
     * @param clusterState the current cluster state
            );
    private static void validateIndexHealth(ClusterState clusterState, Index index, IndexModule.TieringState finalIndexType) {
     * @param clusterState Current state of the cluster
                "Cannot migrate index [%s] to %s tier: index is currently in [%s] tier. "
                maxNodeCapacity
import org.opensearch.cluster.routing.RoutingPool;
                logger.warn("Disk usage information not available for node [{}]", nodeId);
     * @param index index to be validated
    private static Set<DiscoveryNode> getTargetTierNodes(final ClusterState clusterState, IndexModule.TieringState targetTier) {
    ) {
        return nodes.values()
        return calculateTopTwoAvailableSpaces(clusterState, clusterInfo, targetTier, bufferSpace)[0];
        if (shardLimit.isPresent()) {
        }
    /**
        long totalAvailableBytesInTargetTier = getTotalAvailableBytesInTargetTier(
    private static final long GB_IN_BYTES = 1024 * 1024 * 1024;
     * For STARTED shards:
import org.opensearch.cluster.ClusterState;
        var totalShardSizes = 0L;
     * @param clusterInfo Information about cluster resources including node statistics
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
    /**
    private static void validateIndexCurrentState(
        );
        ShardLimitValidator shardLimitValidator
     * @param tieringIndices set of indices undergoing tiering
     * @return true if the shard should be included in calculations, false otherwise
    }
        checkJVMMemoryUtilizationThreshold(clusterState, clusterInfo, jvmActiveUsageThresholdPercent, targetIndexType);
        ClusterInfo clusterInfo,
    ) {
import static org.opensearch.index.IndexModule.TieringState.HOT;
        // TODO: Enable file cache active usage validation once AggregateFileCacheStats is available in ClusterInfo
     * @param index the index to be validated
        if (getTargetTierNodes(clusterState, WARM).isEmpty()) {
     * JVM memory capacity to handle new tiering requests.
    }
     * Checks if JVM memory utilization threshold is exceeded on all nodes of the target tier.
        final int shardsToCreate = numberOfShards * (1 + numberOfReplicas);
        if (getReplicaCount(clusterState, requestIndex) == 0) {
        Set<Index> tieringIndices,
    }
            if (shardRouting.primary()) {
    /**
            validateWarmNodes(clusterState, index);
            logger.warn(errorMsgBuilder.toString());
        final String indexState = state.getMetadata().getIndexSafe(index).getSettings().get(INDEX_TIERING_STATE.getKey(), HOT.toString());
                    + "Size of index to be migrated - "
                new IllegalArgumentException(errorMsgBuilder.toString())
                + tieringState.toString()
        final Set<DiscoveryNode> eligibleNodes = getTargetTierNodes(clusterState, WARM);
    private static long getHighestNodeCapacity(
     * @param targetTier The target tier (HOT/WARM) we're calculating for
        return clusterState.getNodes().get(shard.currentNodeId()).isWarmNode() != isTargetTierWarm;
            return true;
                new OpenSearchRejectedExecutionException(errorMsg)
     * Validates that the index has remote store enabled.
        Set<String> eligibleNodeIds = getTargetTierNodes(clusterState, targetTier).stream()
            clusterInfo,
            .stream()
            .collect(Collectors.toSet());
    ) {
        if (allNodesExceededThreshold) {
        if (finalIndexType == IndexModule.TieringState.WARM && isCCRFollowerIndex(indexMetadata.getSettings())) {
     */
            index,
        // Calculate space for existing tiering entries
    }
     * @param targetIndexType Target tier type (e.g., HOT, WARM) where the index will be moved
     * Validates the capacity of eligible nodes in the cluster to accommodate the specified indices.
        ClusterState clusterState,
        for (DiscoveryNode node : eligibleNodes) {
        long totalTieringIndicesBytes = tieringIndices.stream()
     * Validates whether there is sufficient space in the target tier nodes to accommodate the largest shard of the index.
            }
    private static boolean isNodeExceedingFileCacheThreshold(
    private static long getLargestShardBytes(ClusterState clusterState, ClusterInfo clusterInfo, String requestIndex) {
    /**
        if (nodeStats == null) return false;
        final ClusterState clusterState,
            String errorMsg = "Rejecting tiering request as JVM Utilization is high on all [" + targetIndexType.name() + "] nodes";
    ) {
import org.opensearch.node.NodeResourceUsageStats;
import java.util.Set;
     */
        } else {
     * @param bufferSpace Minimum buffer space to maintain on nodes (in bytes)
     */
     *
                    clusterInfo,
        IndexModule.TieringState tieringState
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = clusterInfo.getNodeFileCacheStats();
    public static void validateHotToWarmTiering(
        final int numberOfReplicas = Math.min(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(settings), 1);
        }
    ) {
    /** Returns the configured replica count for the given index. */
     * Performs common validations applicable to all tiering operations.
            .filter(shard -> shouldIncludeShard(clusterState, shard, targetTier))
                .append("] is a cross-cluster-replicated index and cannot be migrated to [")
    /**
        int maxConcurrentTieringRequests,
package org.opensearch.storage.common.tiering;
    private static void checkFileCacheActiveUsage(
        Index index,
    }
    static long getIndexPrimaryStoreSize(
        }
            tieringIndices.size(),
                + "] is in RED status and cannot be migrated to ["
        List<ShardRouting> shardRoutings = clusterState.routingTable().allShards(requestIndex);
        );
                largestShardBytes = Math.max(largestShardBytes, currentShardBytes);
        }
                targetState,
            .collect(Collectors.toSet());
    private static long[] calculateTopTwoAvailableSpaces(
                new IllegalArgumentException(errorMsgBuilder.toString())
        DiskThresholdEvaluator diskThresholdEvaluator
        Integer jvmActiveUsageThresholdPercent,
            tieringIndices.size(),
            WARM,
            totalAvailableBytes += usages.get(node).getFreeBytes();
        Integer jvmActiveUsageThresholdPercent
        boolean allNodesExceededThreshold = targetNodes.stream()
            .allMatch(node -> isNodeExceedingJVMThreshold(nodeStats, node, jvmActiveUsageThresholdPercent));
    }
        long indexPrimaryStoreSize = getIndexPrimaryStoreSize(clusterState, clusterInfo, index.getName(), WARM);
        if ((currentTieringType.equals(HOT_TO_WARM) && indexState.equals(HOT.toString()) == false)
        }
            final String errorMsg = "Rejecting tiering request for index ["
            )
    ) {
     * @param maxConcurrentTieringRequests The maximum allowed number of concurrent tiering operations.
        if (!isRemoteStoreEnabled) {
        final Set<Index> tieringIndices,
import org.opensearch.core.index.Index;
    /** Returns the second-highest available disk space among nodes in the target tier. */
        if (allNodesExceededFileCacheThreshold) {
     * @throws IllegalArgumentException if there isn't enough capacity in the target tier
            .allShards(index)
        // 3. Validate capacity
        Set<Index> tieringIndices,
        Integer maxConcurrentTieringRequests,
    /**
