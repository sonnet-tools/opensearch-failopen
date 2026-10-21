        final IndexMetadata indexMetadata = currentState.metadata().index(index);
        logger.info(
     *
/**
     * Validates that the specified index is in the "hot" tiering state.
            logger.trace("skipping monitor as no disk usage information is available");
        return currentState.metadata().index(index).getState() == IndexMetadata.State.OPEN;
        if (indexSizes.values().stream().mapToLong(Long::longValue).sum() < totalAvailableBytesInWarmTier) {
     * @param diskThresholdSettings the disk threshold settings of the cluster
     * Validates that the specified index has the remote store setting enabled.
            return;
     *
        HashMap<Index, Long> sortedIndexSizes = indexSizes.entrySet()
import org.opensearch.cluster.ClusterState;
import java.util.stream.Collectors;
        long totalAvailableBytes = 0;
import java.util.HashMap;
        );
            }
        for (Index index : tieringValidationResult.getAcceptedIndices()) {
     *
        final Set<String> eligibleNodeIds = getEligibleNodes(currentState).stream().map(DiscoveryNode::getId).collect(Collectors.toSet());
            if (shardRouting.primary()) {
     * Calculates the total size of the specified index in the cluster.
        }
     */
        long requestIndexBytes = 0L;
            if (nodeUsage != null && nodeUsage.getFreeBytes() > diskThresholdSettings.getFreeBytesThresholdLow().getBytes()) {
import org.opensearch.cluster.routing.IndexRoutingTable;
     *
        }
     * @param currentState the current cluster state
            totalAvailableBytes += usages.get(node).getFreeBytes();
        }
            throw new IllegalArgumentException(errorMsg);
     * @param state the current cluster state
                continue;
            }
        if (usages == null) {
        final Set<Index> concreteIndices,
import java.util.Set;
     * @return true if the index is in the open state, false otherwise
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.metadata.IndexMetadata;
                + indexNames
    /**
     */
import java.util.Map;
            if (requestIndexBytes >= totalAvailableBytesInWarmTier) {
import org.opensearch.index.IndexModule;
            .sorted(Map.Entry.comparingByValue())
     * Validates that the specified index is in the open state in the current cluster state.
                totalIndexSize += clusterInfo.getShardSize(shardRouting, 0);
     * @param nodeIds the set of warm nodes ids in the cluster
     * @param state the current cluster state
import org.apache.logging.log4j.LogManager;
                tieringValidationResult.addToRejected(index, "insufficient node capacity");
        final ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
 * The OpenSearch Contributors require contributions made to
     */
    /**
    static boolean validateHotIndex(final ClusterState state, final Index index) {
    private static final Logger logger = LogManager.getLogger(TieringRequestValidator.class);
    static Set<DiscoveryNode> getEligibleNodes(final ClusterState currentState) {
    public static TieringValidationResult validateHotToWarm(
    }
     * @param indexNames the names of the indices being validated
 */
            }
                continue;
            "Disk threshold low watermark is breached on all the warm nodes, rejecting tiering request for indices: " + indexNames
     * @param currentState the current cluster state
 * compatible open source license.
        validateDiskThresholdWaterMarkNotBreached(currentState, clusterInfo, diskThresholdSettings, indexNames);
     * @return true if the index health is not in the "red" state, false otherwise
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.health.ClusterHealthStatus;
            clusterInfo.getNodeLeastAvailableDiskUsages(),
}
import org.opensearch.cluster.node.DiscoveryNode;
        }
    }
     * @param currentState current cluster state
            indexSizes.put(index, getIndexPrimaryStoreSize(currentState, clusterInfo, index.getName()));
package org.opensearch.indices.tiering;
     * @param tieringValidationResult contains the indices to validate
        List<ShardRouting> shardRoutings = clusterState.routingTable().allShards(index);
public class TieringRequestValidator {
     *
        for (Index index : concreteIndices) {
    }
        if (getEligibleNodes(currentState).isEmpty()) {
        Map<Index, Long> indexSizes = new HashMap<>();
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        final ClusterInfo clusterInfo,
     * @return true if the index is in the "hot" tiering state, false otherwise
            .stream()
            tieringValidationResult.getRejectedIndices()
import java.util.List;
     * @return the total available bytes in the warm tier
    ) {
        final String indexNames = concreteIndices.stream().map(Index::getName).collect(Collectors.joining(", "));
        return totalIndexSize;
    ) {
            }
        }
        }
     */
                return;
        final ClusterState currentState,
        return IndexModule.TieringState.HOT.name().equals(INDEX_TIERING_STATE.get(state.metadata().getIndexSafe(index).getSettings()));
        final TieringValidationResult tieringValidationResult
     * @param index        the name of the index for which the total size is to be calculated
 * @opensearch.experimental
        for (String node : nodeIds) {
     * Validates the health of the specified index in the current cluster state.
        final ClusterInfo clusterInfo,
 * Validator class to validate the tiering requests of the index
     * Validates the capacity of eligible nodes in the cluster to accommodate the specified indices
     */
     * @param clusterInfo the current nodes usage info for the cluster
    /**
import org.opensearch.cluster.routing.ShardRouting;
        }
    /**
        );
    static void validateWarmNodes(final ClusterState currentState, final String indexNames) {
     * @param clusterInfo the current nodes usage info for the cluster
     * and adds the rejected indices to tieringValidationResult
     * @throws IllegalArgumentException if the disk threshold low watermark is breached on all eligible nodes
                + "] because there are no nodes found with the warm role";
     * @param diskThresholdSettings the disk threshold settings of the cluster
     *
    }
     * @param currentState the current cluster state
    static boolean validateOpenIndex(final ClusterState currentState, final Index index) {
import org.opensearch.cluster.ClusterInfo;
            eligibleNodeIds
import org.opensearch.cluster.DiskUsage;
        }
    static long getIndexPrimaryStoreSize(ClusterState clusterState, ClusterInfo clusterInfo, String index) {
     * @param usages the current disk usage of the cluster
    /**
    }
/*
     * @param currentState the current cluster state
     * @param clusterInfo the current nodes usage info for the cluster
        return IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(state.metadata().getIndexSafe(index).getSettings());
            logger.warn(errorMsg);
    static long getTotalAvailableBytesInWarmTier(final Map<String, DiskUsage> usages, final Set<String> nodeIds) {
        validateWarmNodes(currentState, indexNames);
            }
     * @return the total size of the specified index in the cluster
            if (!validateRemoteStoreIndex(currentState, index)) {
        long totalIndexSize = 0;
        for (ShardRouting shardRouting : shardRoutings) {
    }
     * @return true if the remote store setting is enabled for the index, false otherwise
        return !ClusterHealthStatus.RED.equals(indexHealth.getStatus());
 * SPDX-License-Identifier: Apache-2.0
            tieringValidationResult.getAcceptedIndices(),
                tieringValidationResult.addToRejected(index, "index is not backed up by the remote store");
    }
        final Map<String, DiskUsage> usages = clusterInfo.getNodeLeastAvailableDiskUsages();
        final ClusterState currentState,
     */
            }
     * Note: This function only accounts for the primary shard size.
     * Validates that there are eligible nodes with the warm role in the current cluster state.
     * @param index the index to be validated
     * @param clusterState the current state of the cluster
        return nodes.values().stream().filter(DiscoveryNode::isWarmNode).collect(Collectors.toSet());
            final DiskUsage nodeUsage = usages.get(node);
                tieringValidationResult.addToRejected(index, "index is closed");
    /**
     * @param index the index to be validated
            if (!validateIndexHealth(currentState, index)) {
        long totalAvailableBytesInWarmTier = getTotalAvailableBytesInWarmTier(
     */
        final Set<String> nodeIds = getEligibleNodes(currentState).stream().map(DiscoveryNode::getId).collect(Collectors.toSet());
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        final Map<String, DiscoveryNode> nodes = currentState.getNodes().getDataNodes();
     * Validates that the disk threshold low watermark is not breached on all the eligible nodes in the cluster.
    /**
import org.opensearch.cluster.health.ClusterIndexHealth;
     * Validates the tiering request for indices going from hot to warm tier
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
    static void validateEligibleNodesCapacity(
            if (!validateOpenIndex(currentState, index)) {
        final ClusterState currentState,
        validateEligibleNodesCapacity(clusterInfo, currentState, tieringValidationResult);
    static boolean validateIndexHealth(final ClusterState currentState, final Index index) {
    /**
    }
     */
    ) {
     */
    }
        final DiskThresholdSettings diskThresholdSettings,
                tieringValidationResult.addToRejected(index, "index is red");
     */
 */
            }
     * @param index the index to be validated
                continue;
        return totalAvailableBytes;
     * @throws IllegalArgumentException if there are no eligible warm nodes in the cluster
        }
     *
     * (only for the dedicated case - to be removed later)
 *
     */
     * @param indexNames the names of the indices being validated
                continue;
    }
     * @param clusterInfo  the current nodes usage info for the cluster
     *
        for (Index index : sortedIndexSizes.keySet()) {
     * @param index the index to be validated
        throw new IllegalArgumentException(
            "Successfully accepted indices for tiering are [{}], rejected indices are [{}]",
                tieringValidationResult.addToRejected(index, "index is not in the HOT tier");
            if (!validateHotIndex(currentState, index)) {
        final TieringValidationResult tieringValidationResult = new TieringValidationResult(concreteIndices);
            return;
     *
     * Calculates the total available bytes in the warm tier of the cluster.
import org.opensearch.action.admin.indices.tiering.TieringValidationResult;
        final DiskThresholdSettings diskThresholdSettings
        final String indexNames
     * Retrieves the set of eligible(warm) nodes from the current cluster state.
        final ClusterInfo clusterInfo,
    /**
        );
    /**
     * @param concreteIndices set of indices to be validated
     *
     *
     * @return result of the validation
            final String errorMsg = "Rejecting tiering request for indices ["
     * @param currentState the current cluster state
     * @param currentState the current cluster state
            requestIndexBytes += sortedIndexSizes.get(index);
    static void validateDiskThresholdWaterMarkNotBreached(
import org.opensearch.core.index.Index;
        final IndexRoutingTable indexRoutingTable = currentState.routingTable().index(index);
    /**
     * @return the set of eligible nodes
        return tieringValidationResult;
        for (String node : nodeIds) {
    }
    static boolean validateRemoteStoreIndex(final ClusterState state, final Index index) {
