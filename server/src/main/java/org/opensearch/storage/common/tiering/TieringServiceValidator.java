     * @param index index to be validated
                currentTieringType.equals(HOT_TO_WARM) ? "HOT" : "WARM"
        IndexModule.TieringState finalIndexType,
        IndexModule.TieringState tieringState  
    public static void validateHotToWarmTiering(
     * @param shard The shard routing to evaluate  
        IndexModule.TieringState targetTier,  
     * @param tieringIndices ongoing/pending tiering operations  
            .stream()  
        // We have required nodes to place replicas of largest shard  
        }
    /**
        NodeResourceUsageStats stats = nodeStats.get(node.getId());
                + "]";
            if (diskUsage == null) {  
        Integer maxConcurrentTieringRequests,
    /**
import org.opensearch.cluster.ClusterInfo;  
        if (totalAddressableSpaceExcludingLowWatermark - tieringShardSizes - indexPrimaryStoreSize <= 0) {
            totalAvailableBytes += usages.get(node).getFreeBytes();
            final String errorMsg = "Rejecting tiering request because index ["  
     *
        IndexModule.TieringState targetIndexType
    /**
            );
    ) {
import org.apache.logging.log4j.LogManager;
    private static long[] calculateTopTwoAvailableSpaces(
        final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
    }
import java.util.Map;  
    ) {  
    /**
        IndexModule.TieringState targetIndexType,  
        Map<String, NodeResourceUsageStats> nodeStats = clusterInfo.getNodeResourceUsageStats();
     */
            if (shardRouting.primary()) {
     *
     * @param state the current cluster state
     * Calculates the total size of the specified index in the cluster
        final Set<Index> tieringIndices,
     *  
        AggregateFileCacheStats stats = fileCacheStatsMap.get(node.getId());
        }  
        return totalShardSizes;
    }
        ClusterInfo clusterInfo,
        Set<Index> tieringIndices,
        Integer maxConcurrentTieringRequests,
    /**
    private static final Logger logger = LogManager.getLogger(TieringServiceValidator.class);
        ClusterState clusterState,  
        ClusterInfo clusterInfo,
        }
    private static final long GB_IN_BYTES = 1024 * 1024 * 1024;
     * @param clusterState current cluster state
                .append("].")
     */
            logger.warn(errorMsgBuilder.toString());  
        Integer jvmActiveUsageThresholdPercent,
            .filter(shard -> shouldIncludeShard(clusterState, shard, targetTier))
            currentState,  
        Set<DiscoveryNode> targetNodes = getTargetTierNodes(clusterState, targetIndexType);
import java.util.List;
                RejectionReason.CCR_INDEX_REJECTION,
        }  
    ) {  
    ) {
        if (maxNodeCapacity < largestShardBytes) {
    /**
        for (String nodeId : eligibleNodeIds) {
            return true;  
        final IndexMetadata indexMetadata = clusterState.metadata().getIndexSafe(index);
    }
            maxConcurrentTieringRequests,
        IndexModule.TieringState targetTier  
        List<ShardRouting> shardRoutings = clusterState.routingTable().allShards(requestIndex);
            HOT_TO_WARM,
    }
                .append(HOT)
        }
            HOT
            jvmActiveUsageThresholdPercent,  
        if (targetIndexType.equals(IndexModule.TieringState.WARM)) {
        Integer fileCacheActiveUsageThreshold
    }  
     * Validates that the index has remote store enabled.
import static org.opensearch.index.IndexModule.TieringState.WARM;
            logger.warn(
    /**  
     */
            throw new TieringRejectionException(RejectionReason.REMOTE_STORE_NOT_ENABLED, new IllegalArgumentException(errorMsg));
            }
            DiskUsage nodeDiskUsage = usages.get(node.getId());
     * @throws OpenSearchRejectedExecutionException If the number of current tiering operations
    private static void enforceBackpressure(
                .append(targetTier)  
    private static long calculateShardSizesForTieringIndices(
        if (allNodesExceededFileCacheThreshold) {
        long bufferSpace
                index.getName(),
                .append("To avoid migration failures, Stop cross-cluster-replication for this index and retry.");
            long availableBytes = calculateEffectiveAvailableBytes(diskUsage, bufferSpace);
     */  
        if (fileCacheStatsMap == null) return false;  
                nextMaxAvailableBytes = maxAvailableBytes;
     * and ongoing tiering operations. Only runs when remote data ratio is non-zero.
        Set<String> eligibleNodeIds = getTargetTierNodes(clusterState, targetTier).stream()  
        final ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
    }
        long totalBytes = Math.max(0, diskUsage.getTotalBytes());
    /**
        }  
     * @param index the index to be validated  
                    clusterState,  
                logger.warn("Disk usage information not available for node [{}]", nodeId);
     * Note: This function only accounts for the following conditions :  
     * - Include if the shard is currently on a warm node but target tier is not warm
            );  
        return largestShardBytes;  
            String errorMsg = "Rejecting tiering request for index ["  
            clusterState,
import org.opensearch.cluster.DiskUsage;
        Set<Index> tieringIndices,
    /**
    private static Set<DiscoveryNode> getTargetTierNodes(final ClusterState clusterState, IndexModule.TieringState targetTier) {  
    static long getTotalAvailableBytesInTargetTier(  
            );
            final String errorMsg = "Rejecting tiering request because index [" + index.getName() + "] does not have remote store enabled";
     * Returns totalAvailableBytes across all nodes in the target tier
        IndexModule.TieringState targetTier,  
                0,
        return stats != null && stats.getActivePercent() > fileCacheActiveUsageThreshold;
        Index index,
        Integer maxConcurrentTieringRequests,
import java.util.stream.Collectors;  
            throw new TieringRejectionException(RejectionReason.SHARD_LIMIT_EXCEEDED, e);  
        validateIndexHealth(clusterState, index, targetIndexType);
                Locale.ROOT,
        );
            );
        Integer fileCacheActiveUsageThreshold
    /** Returns the second-highest available disk space among nodes in the target tier. */  
            throw new TieringRejectionException(
    }
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
     * @param clusterInfo the current nodes usage info for the cluster
            .collect(Collectors.toSet());
            final StringBuilder errorMsgBuilder = new StringBuilder("Rejecting migration request for index [").append(index)
    // Visible for Testing  
            final StringBuilder errorMsgBuilder = new StringBuilder("Rejecting migration request for index [").append(requestIndex)
        }
        Index index  
    }
    static long getIndexPrimaryStoreSize(
                "Details of node capacity and shard size: LargestShardSize: {}, MaxAvailableBytesOnNode: {}",  
            jvmActiveUsageThresholdPercent,
     * @param targetIndexType Target tier type (e.g., HOT, WARM) where the index will be moved
            .allShards(index)
     * @return true if the shard should be included in calculations, false otherwise
        long totalAvailableBytesInTargetTier = getTotalAvailableBytesInTargetTier(
     * Determines whether a shard should be included in the tier calculation based on its state and current location.
     */  
    /** Returns the configured replica count for the given index. */  
        // TODO: Enable file cache active usage validation once AggregateFileCacheStats is available in ClusterInfo  
    private static int getReplicaCount(ClusterState clusterState, Index index) {
        ClusterState clusterState,  
public class TieringServiceValidator {  
    }  
import org.opensearch.cluster.routing.IndexRoutingTable;
     *
     * @param index        the name of the index for which the total size is to be calculated
            .allMatch(node -> isNodeExceedingJVMThreshold(nodeStats, node, jvmActiveUsageThresholdPercent));
    }  
    }
     * @param requestIndex Name of the index being validated
            .mapToLong(
        // Add space for incoming tiering request index
import org.opensearch.node.NodeResourceUsageStats;
    ) {
                "Cannot migrate index [%s] to %s tier: index is currently in [%s] tier. "  
        long tieringShardSizes = calculateShardSizesForTieringIndices(clusterState, clusterInfo, tieringIndices);  
 *
        Index index,  
                targetState,  
     */  
                    + HOT  
        ClusterState clusterState,  
                + "] because there are too many in-flight tiering requests of type ["
                long currentShardBytes = Math.max(0, clusterInfo.getShardSize(shardRouting, DEFAULT_FALLBACK_SHARD_SIZE));
            .collect(Collectors.toSet());  
        Index index,  
    }  
        return nodes.values()  
            tieringIndices.size(),
        final int shardsToCreate = numberOfShards * (1 + numberOfReplicas);  
        checkJVMMemoryUtilizationThreshold(clusterState, clusterInfo, jvmActiveUsageThresholdPercent, targetIndexType);
     * Calculates the largest and second-largest available disk space among nodes in the target tier.  
import org.opensearch.cluster.metadata.IndexMetadata;
            throw new TieringRejectionException(
    ) {  
    private static long calculateEffectiveAvailableBytes(DiskUsage diskUsage, long bufferSpace) {  
     * 2. If in STARTED state then should not be assigned to the target tier node
    }
                .append("] is a cross-cluster-replicated index and cannot be migrated to [")
        final Settings settings = indexMetadata.getSettings();  
     */  
        if (finalIndexType == IndexModule.TieringState.WARM && isCCRFollowerIndex(indexMetadata.getSettings())) {  
            index,  
     * Validates that there are eligible nodes with the warm role in the current cluster state.
                nodeDiskUsage.getFreeBytes() - diskThresholdEvaluator.getFreeSpaceLowThreshold(nodeDiskUsage.getTotalBytes())
    public static void validateCCRIndex(ClusterState currentState, Index index, IndexModule.TieringState finalIndexType) {
     * @param clusterState the current state of the cluster
            maxConcurrentTieringRequests,  
            String message = String.format(
        final ClusterState state,
        long bufferBytes = Math.round(Math.min(bufferSpace, totalBytes * CLUSTER_WRITE_BLOCK_THRESHOLD_MULTIPLIER));
                + index.getName()
        Integer tieringIndicesSize,  
    ) {
    /**
     * @param index the name of the indices being validated
    private static void validateShardLimit(
            .filter(ShardRouting::primary)
        ClusterState currentState,  
    }  
        // TODO: We need to make this validation strict by excluding nodes from the excluded DI
    protected static void validateWarmNodeDiskThresholdWaterMarkLow(
import org.opensearch.cluster.ClusterState;
        ClusterState clusterState,  
        }
            logger.warn(
    private static void validateIndexHealth(ClusterState clusterState, Index index, IndexModule.TieringState finalIndexType) {
        validateShardLimit(clusterState, index, targetIndexType, shardLimitValidator);
            .filter(WARM.equals(targetTier) ? DiscoveryNode::isWarmNode : node -> !node.isWarmNode())
                new IllegalArgumentException(errorMsgBuilder.toString())  
        return calculateTopTwoAvailableSpaces(clusterState, clusterInfo, targetTier, bufferSpace)[0];  
                maxNodeCapacity
        DiscoveryNode node,  
            }  
        if (getReplicaCount(clusterState, requestIndex) == 0) {  
    }  
        long freeBytes = Math.max(0, diskUsage.getFreeBytes());
     */
import java.util.Locale;
            );
        ClusterInfo clusterInfo,
    ) {
            final ValidationException e = new ValidationException();
        final Optional<String> shardLimit = shardLimitValidator.checkShardLimit(
        final IndexMetadata indexMetadata = clusterState.metadata().index(index);
        }
import org.apache.logging.log4j.Logger;
    /** Returns the size in bytes of the largest primary shard for the given index. */
        for (ShardRouting shardRouting : shardRoutings) {  
        Set<Index> tieringIndices,
            throw new TieringRejectionException(
     * @throws IllegalArgumentException if there isn't enough capacity in the target tier  
        ShardLimitValidator shardLimitValidator
import org.opensearch.index.IndexModule;
        if (shardLimit.isPresent()) {  
    ) {
                new OpenSearchRejectedExecutionException(errorMsg)
import java.util.Optional;
/**  
    /**
            String errorMsg = "Rejecting tiering request as JVM Utilization is high on all [" + targetIndexType.name() + "] nodes";
        ClusterInfo clusterInfo,  
    ) {  
        }  
     *
 * SPDX-License-Identifier: Apache-2.0
                )
                errorMsgBuilder.toString()
        if (ClusterHealthStatus.RED.equals(indexHealth.getStatus())) {
        ShardLimitValidator shardLimitValidator
        if (isCurrentStateValid == false) {
    ) {
     */
        // find the size of largest shard of this index
import org.opensearch.cluster.routing.allocation.DiskThresholdEvaluator;
        int indexSizeMultiplier = getReplicaCount(clusterState, index) + 1;
    private static boolean isNodeExceedingFileCacheThreshold(
     * This validation ensures that both primary and replica shards can be placed on different nodes with adequate space.
        return new long[] { maxAvailableBytes, nextMaxAvailableBytes };
                new IllegalArgumentException(errorMsgBuilder.toString())
                RejectionReason.LARGEST_SHARD_SPACE_INSUFFICIENT,  
    private static void validateIndexCurrentState(  
        validateIndexCurrentState(clusterState, index, tieringType);
     * @param targetTier target tier to analyze
                totalShardSizes += getIndexPrimaryStoreSize(clusterState, clusterInfo, index.getName(), WARM);
        IndexModule.TieringState targetTier
    ) {  
        Map<String, NodeResourceUsageStats> nodeStats,
import org.opensearch.cluster.health.ClusterHealthStatus;  
import org.opensearch.cluster.routing.ShardRoutingState;
     * @param clusterState Current state of the cluster containing node information
import java.util.Set;
     * @param bufferSpace Minimum buffer space to maintain on nodes (in bytes)
        Integer fileCacheActiveUsageThreshold,
     *
        if (currentTieringIndices >= maxConcurrentTieringRequests) {
        // if replica count is not 1 we need to account for shard size of primary only
        validateEligibleHotNodesCapacity(clusterState, clusterInfo, tieringIndices, index);  
package org.opensearch.storage.common.tiering;
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = clusterInfo.getNodeFileCacheStats();
        long nextMaxAvailableBytes = Long.MIN_VALUE;
        if (requestIndexBytes + totalTieringIndicesBytes >= totalAvailableBytesInTargetTier) {  
     * - Include if the shard is currently on a hot node but target tier is warm  
            );  
                .append(" nodes");  
import org.opensearch.storage.common.tiering.TieringRejectionException.RejectionReason;
        Integer jvmActiveUsageThresholdPercent
        return Math.max(0, freeBytes - bufferBytes);
        if (allNodesExceededThreshold) {
    ) {
        final IndexMetadata indexMetadata = clusterState.metadata().index(index);  
     *
     * This validation ensures there are available nodes in the target tier with sufficient
        Set<String> targetNodeIds = getTargetTierNodes(clusterState, targetTier).stream()
                RejectionReason.CONCURRENT_LIMIT_EXCEEDED,  
            .collect(Collectors.toSet());
            throw new TieringRejectionException(RejectionReason.INDEX_RED_STATUS, new IllegalArgumentException(errorMsg));
    }
        Integer jvmActiveUsageThresholdPercent,
        final ClusterState clusterState,
                RejectionReason.INSUFFICIENT_SPACE_HOT,  
        DiskThresholdEvaluator diskThresholdEvaluator
            index,
    private static void validateRemoteStoreEnabled(ClusterState clusterState, Index index) {  
        Set<Index> tieringIndices
        return stats != null && stats.getMemoryUtilizationPercent() >= jvmActiveUsageThresholdPercent;
            }
                + index.getName()
        ClusterState clusterState,
            }
            clusterInfo,
     * Checks if JVM memory utilization threshold is exceeded on all nodes of the target tier.
        ClusterState clusterState,
        }
    /**  
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
        Integer jvmActiveUsageThresholdPercent,  
        final String indexState = state.getMetadata().getIndexSafe(index).getSettings().get(INDEX_TIERING_STATE.getKey(), HOT.toString());
     * @param targetTier Target tier where the index will be moved  
    /**
                    + HOT
        ShardLimitValidator shardLimitValidator
            totalAddressableSpaceExcludingLowWatermark += Math.max(  
        if (getTargetTierNodes(clusterState, WARM).isEmpty()) {  
     * Performs common validations applicable to all tiering operations.  
                    tieringIndex.getName(),
                    + "Size of index to be migrated - "  
                maxAvailableBytes = availableBytes;
                .append("] node with free space to fit it's largest shard");
        return clusterState.routingTable()
        boolean allNodesExceededThreshold = targetNodes.stream()
            String errorMsg = "Rejecting migration request for index [" + index + "] since we don't have enough space on all warm nodes";  
        validateCommon(
     */
     * @throws IllegalArgumentException if warm nodes lack sufficient space  
        Index requestIndex,
    protected static void validateSpaceForLargestShard(
     * @param index The index for which the tiering operation is being requested.
        final Set<DiscoveryNode> eligibleNodes = getTargetTierNodes(clusterState, WARM);  
        }  
     */
                    + totalAvailableBytesInTargetTier
        long totalAddressableSpaceExcludingLowWatermark = 0L;
    }
        long bufferSpace
                + tieringState.toString()  
     * @param clusterState Current state of the cluster
     * @param bufferSpace required buffer space
        ClusterState clusterState,
        }
            String errorMsg = "Rejecting tiering request as FileCache Active Usage is high on all Warm nodes";
    /**  
        }  
     * @param diskThresholdEvaluator warm node disk evaluator
     * @param currentTieringIndices The current number of indices undergoing tiering operations.  
     * Validates if warm nodes have sufficient disk space after considering watermark settings
     */
        ClusterInfo clusterInfo,
                    + "Total "
import org.opensearch.common.ValidationException;  
        ClusterInfo clusterInfo,  
            }
            .stream()
    ) {  
        long bufferSpace
    /**
     */
 */
    private static long getSecondHighestNodeCapacity(
        ClusterState clusterState,  
    /**
    }
        Integer currentTieringIndices,
                + "] because there are no nodes found with the warm role";  
    private static boolean shouldIncludeShard(ClusterState clusterState, ShardRouting shard, IndexModule.TieringState targetTier) {
     * - Any shard not in STARTED state  
                + finalIndexType.toString()  
        }  
                    + "Index must be in %s tier to perform this migration.",
     * @param clusterState the current cluster state  
                    HOT  
                largestShardBytes,
 * compatible open source license.
        DiskThresholdEvaluator diskThresholdEvaluator,  
                .append("] capacity. Please add more ")
        ClusterInfo clusterInfo,  
                continue;
}
            if (maxAvailableBytes <= availableBytes) {  
        long bufferSpace  
                new IllegalArgumentException(errorMsgBuilder.toString())
        Integer jvmActiveUsageThresholdPercent,
     * Validates that the index has remote store enabled before tiering operation.
            || (currentTieringType.equals(WARM_TO_HOT) && indexState.equals(WARM.toString()) == false)) {
    /**  
     * Validates whether there is sufficient space in the target tier nodes to accommodate the largest shard of the index.  
     */
        long indexPrimaryStoreSize = getIndexPrimaryStoreSize(clusterState, clusterInfo, index.getName(), WARM);
     * @return array where [0] is largest and [1] is second-largest available space  
    ) {
            .mapToLong(shard -> clusterInfo.getShardSize(shard, DEFAULT_FALLBACK_SHARD_SIZE))  
     */  
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the highest available disk space among nodes in the target tier. */
    }
        ClusterState clusterState,
            WARM,
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            .allMatch(node -> isNodeExceedingFileCacheThreshold(fileCacheStatsMap, node, fileCacheActiveUsageThreshold));
        for (String node : targetNodeIds) {
        ClusterState clusterState,
        long requestIndexBytes = indexSizeMultiplier * getIndexPrimaryStoreSize(clusterState, clusterInfo, index.getName(), HOT);  
        final int numberOfReplicas = Math.min(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(settings), 1);
    }
    public static void checkJVMMemoryUtilizationThreshold(
            shardLimitValidator
     * @param clusterInfo Information about the cluster's current state including disk usage  
    ) {
    /**
     *                              the largest shard (for primary and replica placement)  
                    + requestIndexBytes
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;  
    /**  
     * @param clusterState Current state of the cluster
        String index,
     *
        }  
        long totalAvailableBytes = 0;  
            finalIndexType == HOT ? RoutingPool.LOCAL_ONLY : RoutingPool.REMOTE_CAPABLE
            )
import org.opensearch.indices.ShardLimitValidator;  
        ClusterInfo clusterInfo,  
                tieringIndex -> (getReplicaCount(clusterState, tieringIndex) + 1) * getIndexPrimaryStoreSize(
        if (tieringIndices.isEmpty() == false) {
        if ((currentTieringType.equals(HOT_TO_WARM) && indexState.equals(HOT.toString()) == false)
     *  
        final Map<String, DiscoveryNode> nodes = clusterState.getNodes().getDataNodes();
/*  
            for (Index index : tieringIndices) {  
import org.opensearch.cluster.routing.ShardRouting;  
            throw new TieringRejectionException(RejectionReason.NO_WARM_NODES, new IllegalArgumentException(errorMsg));
    }
        ClusterState clusterState,  
        } else {
            if (nodeDiskUsage == null) {  
        if (nodeStats == null) return false;  
            String targetState = currentTieringType.equals(HOT_TO_WARM) ? "WARM" : "HOT";  
            WARM_TO_HOT,  
            );
    private static void validateWarmNodes(final ClusterState clusterState, final Index index) {
            throw new TieringRejectionException(
        boolean allNodesExceededFileCacheThreshold = targetNodes.stream()
                indexState,
                    + ", "  
            throw new TieringRejectionException(RejectionReason.HIGH_JVM_UTILIZATION, new IllegalArgumentException(errorMsg));  
    }
                + index.getName()
                largestShardBytes = Math.max(largestShardBytes, currentShardBytes);  
        if (!shard.state().equals(ShardRoutingState.STARTED)) {
import org.opensearch.common.settings.Settings;
                .append(finalIndexType.toString())  
        boolean isTargetTierWarm = WARM.equals(targetTier);
        if (!isRemoteStoreEnabled) {  
        validateCCRIndex(clusterState, index, tieringType);  
        Index index,
            clusterInfo,  
     * @param clusterInfo  the current nodes usage info for the cluster  
        }
            maxNodeCapacity = getHighestNodeCapacity(clusterState, clusterInfo, targetTier, bufferSpace);
        );  
        IndexModule.TieringState targetTier,
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
        validateSpaceForLargestShard(clusterState, clusterInfo, index, HOT, MIN_DISK_SPACE_BUFFER);
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;  
     * Validates that the specified index is in the required initial tiering state for the requested
        ClusterInfo clusterInfo,
            maxNodeCapacity = getSecondHighestNodeCapacity(clusterState, clusterInfo, targetTier, bufferSpace);  
        validateCommon(  
        Map<String, AggregateFileCacheStats> fileCacheStatsMap,
        long maxNodeCapacity = 0L;  
import org.opensearch.cluster.routing.RoutingPool;
     * Validates that the cluster shard limit will not be exceeded after tiering.  
    }
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
import static org.opensearch.storage.common.tiering.TieringUtils.isCCRFollowerIndex;
        }  
 */  
        Index index,  
     * @param index index to validate
                    + " available bytes - "
        final int numberOfShards = INDEX_NUMBER_OF_SHARDS_SETTING.get(settings);
     * @param clusterState current cluster state
     * @return the total size of the specified index in the cluster
    private static boolean isNodeExceedingJVMThreshold(
    private static void checkFileCacheActiveUsage(
        ClusterInfo clusterInfo,
    ) {  
        long maxAvailableBytes = Long.MIN_VALUE;
            throw new TieringRejectionException(RejectionReason.HIGH_FILE_CACHE_UTILIZATION, new IllegalArgumentException(errorMsg));  
        ClusterState clusterState,  
    public static void validateCommon(
            clusterInfo.getNodeLeastAvailableDiskUsages(),
        ClusterInfo clusterInfo,  
            validateWarmNodes(clusterState, index);
            e.addValidationError(shardLimit.get());
     * JVM memory capacity to handle new tiering requests.  
            shardLimitValidator  
     * - RELOCATING shards
        validateWarmNodeDiskThresholdWaterMarkLow(clusterState, clusterInfo, tieringIndices, index, diskThresholdEvaluator);
        return clusterState.getNodes().get(shard.currentNodeId()).isWarmNode() != isTargetTierWarm;  
            clusterState,
        }
        return Integer.parseInt(indexMetadata.getSettings().get(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey()));  
        final IndexModule.TieringState currentTieringType  
        validateRemoteStoreEnabled(clusterState, index);
    }
     * Performs common validations for warm to hot tiering operations.
     * Performs common validations for hot to warm tiering operations.
            tieringIndices.size(),
            .sum();
 * The OpenSearch Contributors require contributions made to  
            DiskUsage diskUsage = clusterInfo.getNodeLeastAvailableDiskUsages().get(nodeId);
    ) {
    private static long getHighestNodeCapacity(  
            final StringBuilder errorMsgBuilder = new StringBuilder("Rejecting migration request because index [").append(index.getName())
     * Calculates effective available bytes on a node after accounting for buffer space and write-block threshold.
        final Index index,
     * @param clusterInfo Information about cluster resources including node statistics  
import org.opensearch.core.index.Index;  
        IndexModule.TieringState targetTier,
                + "]";
    }
            throw new TieringRejectionException(RejectionReason.INVALID_TIER_TRANSITION, new IllegalArgumentException(message));
     */
     * @throws IllegalArgumentException if there are no eligible warm nodes in the cluster  
        ClusterInfo clusterInfo,
            final String errorMsg = "Rejecting tiering request for index ["
    /**  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            clusterState,  
     * @throws IllegalArgumentException if there isn't enough space on at least two nodes to accommodate
    ) {
     *
     * @param clusterInfo cluster disk usage and shard locations
    }  
    protected static void validateEligibleHotNodesCapacity(
     */  
        IndexModule.TieringState tieringType,
     * For STARTED shards:
        }
                    + totalTieringIndicesBytes  
     * Returns set of nodes eligible for target tier operations.
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
 * Validator for tiering service operations in OpenSearch.
    public static void validateWarmToHotTiering(
     * 1. should be a primary shard
        ClusterInfo clusterInfo,
        // Accounting the risk of cluster-write-block if the below threshold is breached.  
     * @param clusterState the current cluster state
        // 1. Get available space in target tier
     */
     * Validates a warm-to-hot tiering request including common checks, hot node capacity, and largest shard space.
     * Validates the capacity of eligible nodes in the cluster to accommodate the specified indices.  
    private static final double CLUSTER_WRITE_BLOCK_THRESHOLD_MULTIPLIER = 0.2;
        final IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(index);
        DiscoveryNode node,  
     * @param maxConcurrentTieringRequests The maximum allowed number of concurrent tiering operations.
            isCurrentStateValid = false;  
     * @param clusterInfo cluster disk usage information  
        long largestShardBytes = getLargestShardBytes(clusterState, clusterInfo, requestIndex.getName());  
            shardsToCreate,
                nextMaxAvailableBytes = availableBytes;
            throw new TieringRejectionException(RejectionReason.INSUFFICIENT_SPACE_WARM, new IllegalArgumentException(errorMsg));
     * Validates a hot-to-warm tiering request including common checks, disk threshold, and file cache usage.
        // Calculate space for existing tiering entries
        Set<DiscoveryNode> targetNodes = getTargetTierNodes(clusterState, WARM);
        );
            HOT,
        return calculateTopTwoAvailableSpaces(clusterState, clusterInfo, targetTier, bufferSpace)[1];
     * @param targetTier The target tier (HOT/WARM) we're calculating for
        long largestShardBytes = Long.MIN_VALUE;  
                    + " tieringQueue capacity to be utilized - "
        final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
            } else if (availableBytes > nextMaxAvailableBytes) {  
import static org.opensearch.index.IndexModule.TieringState.HOT;  
                .append("] since we don't have enough [")
     */  
        }
    private static final long DEFAULT_FALLBACK_SHARD_SIZE = 0L;
     */
     */  
            );  
                .append("] since we don't have [")
        boolean isRemoteStoreEnabled = indexMetadata.getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false);
        final Map<String, DiskUsage> usages,
        int maxConcurrentTieringRequests,
import org.opensearch.cluster.node.DiscoveryNode;  
        Index index,
     * The following shards are always included:  
        for (DiscoveryNode node : eligibleNodes) {
    private static final long MIN_DISK_SPACE_BUFFER = 20 * GB_IN_BYTES;  
import org.opensearch.cluster.health.ClusterIndexHealth;
     *         equals or exceeds the migration queue size, indicating system overload.  
     * Validates that the index is not in RED health status before tiering operation.
        );
    /**
            .map(DiscoveryNode::getId)
        // 3. Validate capacity
        ClusterState clusterState,
     * @param currentTieringType the requested tiering transition
        ShardLimitValidator shardLimitValidator  
                    clusterInfo,
     * @param tieringIndices set of indices undergoing tiering
        boolean isCurrentStateValid = true;  
        return totalAvailableBytes;
                + "] is in RED status and cannot be migrated to ["
    private static long getLargestShardBytes(ClusterState clusterState, ClusterInfo clusterInfo, String requestIndex) {
        enforceBackpressure(index, tieringIndicesSize, maxConcurrentTieringRequests, tieringType);  
     * @throws IllegalArgumentException if all nodes in the target tier exceed the JVM memory threshold
        // checkFileCacheActiveUsage(clusterState,clusterInfo, fileCacheActiveUsageThreshold);
        long totalTieringIndicesBytes = tieringIndices.stream()  
     * Enforces backpressure on tiering operations to prevent system overload.  
    /** Calculates total primary shard sizes for all indices currently undergoing tiering. */
            .sum();  
    }
                .append(HOT)  
     * 3. If UNASSIGNED/RELOCATING, should be considered  
    /**  
            .map(DiscoveryNode::getId)  
    }  
     * operation. Validation of the final tiering state is performed before calling this method.  
                continue;
     * - UNASSIGNED shards
     */
        var totalShardSizes = 0L;
