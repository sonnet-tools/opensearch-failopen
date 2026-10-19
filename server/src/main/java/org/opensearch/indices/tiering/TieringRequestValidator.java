    /**
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
            tieringValidationResult.getAcceptedIndices(),
        }
        final ClusterState currentState,
        return totalIndexSize;
import java.util.HashMap;
import org.opensearch.index.IndexModule;  
        final IndexRoutingTable indexRoutingTable = currentState.routingTable().index(index);
     * @param index the index to be validated  
    static void validateDiskThresholdWaterMarkNotBreached(
     *
    static Set<DiscoveryNode> getEligibleNodes(final ClusterState currentState) {
        }
        final Set<Index> concreteIndices,
import org.opensearch.cluster.ClusterState;
        }
     * @return true if the remote store setting is enabled for the index, false otherwise
     */  
        final String indexNames = concreteIndices.stream().map(Index::getName).collect(Collectors.joining(", "));  
    static long getIndexPrimaryStoreSize(ClusterState clusterState, ClusterInfo clusterInfo, String index) {  
     * @return result of the validation
        return IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(state.metadata().getIndexSafe(index).getSettings());
     * Calculates the total size of the specified index in the cluster.
import org.opensearch.cluster.routing.ShardRouting;  
        HashMap<Index, Long> sortedIndexSizes = indexSizes.entrySet()
     *  
import org.opensearch.core.index.Index;
        throw new IllegalArgumentException(
        final ClusterInfo clusterInfo,  
            "Successfully accepted indices for tiering are [{}], rejected indices are [{}]",  
import org.apache.logging.log4j.LogManager;
        if (getEligibleNodes(currentState).isEmpty()) {
    ) {  
        long totalAvailableBytesInWarmTier = getTotalAvailableBytesInWarmTier(  
    }
    public static TieringValidationResult validateHotToWarm(  
    }
        return currentState.metadata().index(index).getState() == IndexMetadata.State.OPEN;
     */
    static boolean validateOpenIndex(final ClusterState currentState, final Index index) {  
    ) {  
        for (Index index : sortedIndexSizes.keySet()) {
            }
        Map<Index, Long> indexSizes = new HashMap<>();
        if (usages == null) {
package org.opensearch.indices.tiering;
            }
        final ClusterState currentState,
     * @param index the index to be validated
     */
     */
     * @param indexNames the names of the indices being validated
     * @param currentState the current cluster state
                tieringValidationResult.addToRejected(index, "index is closed");
import java.util.stream.Collectors;  
            "Disk threshold low watermark is breached on all the warm nodes, rejecting tiering request for indices: " + indexNames
import org.opensearch.cluster.health.ClusterHealthStatus;
    static boolean validateIndexHealth(final ClusterState currentState, final Index index) {
        final String indexNames
        return nodes.values().stream().filter(DiscoveryNode::isWarmNode).collect(Collectors.toSet());
                + indexNames
        final DiskThresholdSettings diskThresholdSettings,
     * @return the total available bytes in the warm tier
        final TieringValidationResult tieringValidationResult
            clusterInfo.getNodeLeastAvailableDiskUsages(),
        for (Index index : tieringValidationResult.getAcceptedIndices()) {  
            .sorted(Map.Entry.comparingByValue())  
            logger.warn(errorMsg);  
    /**
            logger.trace("skipping monitor as no disk usage information is available");  
        for (ShardRouting shardRouting : shardRoutings) {  
 * @opensearch.experimental  
     * @param currentState the current cluster state
            eligibleNodeIds
    /**  
     * Calculates the total available bytes in the warm tier of the cluster.  
    /**
        return !ClusterHealthStatus.RED.equals(indexHealth.getStatus());
import java.util.Map;
    static void validateEligibleNodesCapacity(
            if (!validateOpenIndex(currentState, index)) {  
import org.opensearch.action.admin.indices.tiering.TieringValidationResult;  
        }  
import org.opensearch.cluster.ClusterInfo;
            throw new IllegalArgumentException(errorMsg);
     * Validates that the specified index has the remote store setting enabled.  
     * @param currentState the current cluster state
        }
        return IndexModule.TieringState.HOT.name().equals(INDEX_TIERING_STATE.get(state.metadata().getIndexSafe(index).getSettings()));  
    }  
            }
     *  
        final ClusterState currentState,
            if (nodeUsage != null && nodeUsage.getFreeBytes() > diskThresholdSettings.getFreeBytesThresholdLow().getBytes()) {  
        final ClusterInfo clusterInfo,  
    /**
     * @param nodeIds the set of warm nodes ids in the cluster  
     * @param clusterInfo the current nodes usage info for the cluster
     * and adds the rejected indices to tieringValidationResult
     * Validates that the specified index is in the open state in the current cluster state.  
     * @param diskThresholdSettings the disk threshold settings of the cluster  
            }  
     */
     *
        );  
            if (!validateHotIndex(currentState, index)) {
 * this file be licensed under the Apache-2.0 license or a
        }
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;  
     * Validates that there are eligible nodes with the warm role in the current cluster state.  
            }
     * @param index the index to be validated  
     */
    }
 * The OpenSearch Contributors require contributions made to  
        long requestIndexBytes = 0L;  
     */
import org.apache.logging.log4j.Logger;
     * (only for the dedicated case - to be removed later)
    /**  
    /**
     * @param currentState the current cluster state  
                tieringValidationResult.addToRejected(index, "index is not backed up by the remote store");  
 */
     * Validates that the specified index is in the "hot" tiering state.
     * @param usages the current disk usage of the cluster
        );  
            indexSizes.put(index, getIndexPrimaryStoreSize(currentState, clusterInfo, index.getName()));
            requestIndexBytes += sortedIndexSizes.get(index);
        if (indexSizes.values().stream().mapToLong(Long::longValue).sum() < totalAvailableBytesInWarmTier) {
    static boolean validateHotIndex(final ClusterState state, final Index index) {
        long totalAvailableBytes = 0;
    }  
    }
 * Validator class to validate the tiering requests of the index
            }
        validateDiskThresholdWaterMarkNotBreached(currentState, clusterInfo, diskThresholdSettings, indexNames);
            tieringValidationResult.getRejectedIndices()
        final Map<String, DiscoveryNode> nodes = currentState.getNodes().getDataNodes();  
     * Validates the health of the specified index in the current cluster state.
                totalIndexSize += clusterInfo.getShardSize(shardRouting, 0);
        final DiskThresholdSettings diskThresholdSettings
        }  
     * @param tieringValidationResult contains the indices to validate  
            totalAvailableBytes += usages.get(node).getFreeBytes();  
     * @param state the current cluster state
    /**  
        validateEligibleNodesCapacity(clusterInfo, currentState, tieringValidationResult);
     * Validates the capacity of eligible nodes in the cluster to accommodate the specified indices
        return totalAvailableBytes;
/**
            .stream()
     * @param state the current cluster state
            if (!validateRemoteStoreIndex(currentState, index)) {
import org.opensearch.cluster.DiskUsage;  
        for (String node : nodeIds) {
     * @return true if the index health is not in the "red" state, false otherwise
                return;
        long totalIndexSize = 0;
     * @param clusterState the current state of the cluster
    /**  
        final ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
     * @param currentState the current cluster state  
                continue;
            if (!validateIndexHealth(currentState, index)) {
     * @param concreteIndices set of indices to be validated
 */  
                tieringValidationResult.addToRejected(index, "index is red");
        logger.info(
     */  
    }
     * @return true if the index is in the "hot" tiering state, false otherwise  
     * @param diskThresholdSettings the disk threshold settings of the cluster  
 * SPDX-License-Identifier: Apache-2.0
     * @throws IllegalArgumentException if the disk threshold low watermark is breached on all eligible nodes
        for (String node : nodeIds) {
     * @return true if the index is in the open state, false otherwise
    /**
                continue;  
    static boolean validateRemoteStoreIndex(final ClusterState state, final Index index) {  
     * Validates the tiering request for indices going from hot to warm tier
import org.opensearch.cluster.health.ClusterIndexHealth;
            if (requestIndexBytes >= totalAvailableBytesInWarmTier) {  
     */
public class TieringRequestValidator {
        final Set<String> nodeIds = getEligibleNodes(currentState).stream().map(DiscoveryNode::getId).collect(Collectors.toSet());  
     * @param currentState the current cluster state
    /**
     * @throws IllegalArgumentException if there are no eligible warm nodes in the cluster
            }  
        final Map<String, DiskUsage> usages = clusterInfo.getNodeLeastAvailableDiskUsages();
     */
     *
    }  
     *  
import org.opensearch.cluster.routing.IndexRoutingTable;
        return tieringValidationResult;
        final Set<String> eligibleNodeIds = getEligibleNodes(currentState).stream().map(DiscoveryNode::getId).collect(Collectors.toSet());
    }
            if (shardRouting.primary()) {
                continue;
     * @param index        the name of the index for which the total size is to be calculated  
     *
                tieringValidationResult.addToRejected(index, "index is not in the HOT tier");
        final ClusterInfo clusterInfo,  
     * @return the total size of the specified index in the cluster
        final IndexMetadata indexMetadata = currentState.metadata().index(index);  
/*  
     * Retrieves the set of eligible(warm) nodes from the current cluster state.  
        validateWarmNodes(currentState, indexNames);
     *  
 *
import org.opensearch.cluster.node.DiscoveryNode;
                + "] because there are no nodes found with the warm role";
    static long getTotalAvailableBytesInWarmTier(final Map<String, DiskUsage> usages, final Set<String> nodeIds) {  
     * @param index the index to be validated
     * @param currentState current cluster state  
        }
     * @param clusterInfo the current nodes usage info for the cluster
import java.util.Set;
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
     * @param clusterInfo the current nodes usage info for the cluster
     * @return the set of eligible nodes  
     *
     *
     * Validates that the disk threshold low watermark is not breached on all the eligible nodes in the cluster.
        List<ShardRouting> shardRoutings = clusterState.routingTable().allShards(index);
    private static final Logger logger = LogManager.getLogger(TieringRequestValidator.class);
}  
import java.util.List;  
    }  
            final DiskUsage nodeUsage = usages.get(node);
        }  
        for (Index index : concreteIndices) {  
     * @param clusterInfo  the current nodes usage info for the cluster
                tieringValidationResult.addToRejected(index, "insufficient node capacity");
        );  
    ) {
            return;
     *
    }  
     * Note: This function only accounts for the primary shard size.
    static void validateWarmNodes(final ClusterState currentState, final String indexNames) {
     * @param indexNames the names of the indices being validated
            return;
                continue;  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            final String errorMsg = "Rejecting tiering request for indices ["  
     */  
        final TieringValidationResult tieringValidationResult = new TieringValidationResult(concreteIndices);
