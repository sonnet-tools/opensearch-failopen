        for (ShardRouting shard : routingNodes.unassigned()) {
                );
                    if (logger.isDebugEnabled()) {
                }
     */
        }
        logger.debug("Allocating unassigned {}. Nodes available in queue: [{}]", (primaries ? "primaries" : "replicas"), nodeQueue.size());
        assert shardsToBalance >= 0 : "Shards to balance should be greater than 0, but found negative";
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
            final RoutingNode targetNode = eligibleNodes.poll();
        List<RoutingNode> remoteRoutingNodes = getRemoteRoutingNodes();
        int numNodesToCheck = eligibleNodes.size();
        if (allocated == false) {
     *
        return shard.started() == false || RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) == false;
                }
        final UnassignedInfo.AllocationStatus status = anyNodesThrottled
        logger.trace("Performing balancing for remote shards.");
        Map<String, UnassignedIndexShards> unassignedShardMap
                        unassignedInfo.getMessage(),
     * Prior to allocation operations done by {@link RemoteShardsBalancer}, the ignored remote shards are moved back to
        final int avgPrimaryPerNode = (totalPrimaryShardCount + remoteRoutingNodes.size() - 1) / remoteRoutingNodes.size();
    }
                            node.nodeId(),
        Queue<RoutingNode> eligibleNodes = new ArrayDeque<>();
    /**
                continue;
    public static class UnassignedIndexShards {
        return "[" + shard.getIndexName() + "]" + "[" + shard.getId() + "]" + "[" + (shard.primary() ? "p" : "r") + "]";
        final Map<String, Integer> nodePrimaryShardCount = calculateNodePrimaryShardCount(remoteRoutingNodes);
        throw new UnsupportedOperationException("remote shards balancer does not support decision operations");
     * @param shard the ineligible shard to be moved
                if (numNodesToCheck == 0) {
                    new UnassignedInfo(
import java.util.HashSet;
            }
                : UnassignedInfo.AllocationStatus.DECIDERS_NO;
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getNodePool(rNode))) {
    }
    private void failUnattemptedShards() {
            final long shardSize = allocation.clusterInfo().getShardSize(shard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
                if (numNodesToCheck == 0) {
                    Decision nodeDecision = allocation.deciders().canAllocateAnyShardToNode(targetNode, allocation);
     * @param shard the unassigned shard which needs to be allocated
    private Decision tryRelocateShard(ShardRouting shard, RoutingNode destinationNode) {
        final List<ShardRouting> forceMoveShards = new ArrayList<>();
    private List<RoutingNode> getRemoteRoutingNodes() {
    }
                    allocation.clusterInfo().getShardSize(shard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
import org.opensearch.cluster.routing.allocation.decider.Decision;
                );
        // Iterate through all shards index by index and allocate them
                            );
        return primaryShardCount;
        classifyNodesForShardMovement(eligibleNodes, excludedNodes);
            if (nodeDecision.type() == Decision.Type.NO) {
        if ((allocationDecision.type() == Decision.Type.YES) && (rebalanceDecision.type() == Decision.Type.YES)) {
        logger.trace(
import org.opensearch.cluster.routing.allocation.MoveDecision;
        throw new UnsupportedOperationException("remote shards balancer does not support decision operations");
            if (allocateDecision.type() == Decision.Type.YES) {
import java.util.List;
        Queue<RoutingNode> nodeQueue,
import java.util.ArrayDeque;
        long shardsToBalance = primaryCount.get(sourceNode.nodeId()) - avgPrimary;
        return unassignedShardMap;
    private Map<String, Integer> calculateNodePrimaryShardCount(List<RoutingNode> remoteRoutingNodes) {
                        unassignedInfo.getReason(),
        ignoreRemainingShards(unassignedShardMap);
                    if (logger.isDebugEnabled()) {
                }
            /* canAllocateAnyShardToNode decision can be THROTTLE for throttled nodes. To classify
    }
        }
public final class RemoteShardsBalancer extends ShardsBalancer {
                // Remote shards do not have an existing store to recover from and can be recovered from an empty source
                Decision shardLevelDecision = allocation.deciders().canAllocate(shard, allocation);
            RoutingNode sourceNode = excludedNodes.poll();
                    }
                excludedNodes.size(),
        Decision allocationDecision = allocation.deciders().canAllocate(shard, destinationNode, allocation);
            logger.debug("Allocating shards for index: [{}]", index);
                excludedNodes.add(node);
            primaryShardCount.put(node.nodeId(), totalPrimaryShardsPerNode);
            logger.info("Relocated shard [{}] to node [{}] during primary Rebalance", shard, targetShard.currentNodeId());
                throttled = throttled || allocateDecision.type() == Decision.Type.THROTTLE;
            rebalanceDecision.toString()
import org.opensearch.cluster.routing.RecoverySource;
            }
            UnassignedInfo unassignedInfo = shard.unassignedInfo();
            for (ShardRouting shard : indexShards.getReplicas()) {
                if (ineligibleForMove(shardRouting)) {
                    allocation.changes()
                && (shard.primary() || shard.unassignedInfo().isDelayed() == false)) {
 */
                    );
import org.opensearch.cluster.routing.RoutingPool;
        eligibleNodes.forEach(sourceNode -> {
                    logger.trace(
    }
        throw new UnsupportedOperationException("remote shards balancer does not support decision operations");
            }
            }
        // move shards that cannot remain on eligible nodes
            }
            } else {
 * The OpenSearch Contributors require contributions made to
        }
     */
    private void tryRebalanceNode(
                Decision nodeLevelDecision = allocation.deciders().canAllocateAnyShardToNode(node, allocation);
            } else if (nodeDecision.type() == Decision.Type.YES) {
            } else if (nodePrimaryShardCount.get(node.nodeId()) < avgPrimaryPerNode) {
        assert destinationNode.getByShardId(shard.shardId()) == null;
        List<RoutingNode> nodeList = getRemoteRoutingNodes();
    }
                        }
    /**
                ? UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED
                            "Ignoring shard: [{}] as is cannot be allocated to any node. Shard level decisions: [{}][{}].",
                unassignedRemotePrimaryShardCount++;
                logger.trace("there are no eligible nodes available, return");
            ShardRouting shard = unassignedIterator.next();
        List<RoutingNode> nodeList = new ArrayList<>();
                unassignedIterator.updateUnassigned(
                if (logger.isTraceEnabled()) {
                eligibleNodes.size(),
            Queue<ShardRouting> shardsToAllocate = primaries ? indexShards.getPrimaries() : indexShards.getReplicas();
    MoveDecision decideMove(ShardRouting shardRouting) {
                return;
     */
            tryShardMovementToEligibleNode(eligibleNodes, shard);
                    continue;
    /**
                unassignedShards.add(unassignedShard);
        for (RoutingNode node : remoteRoutingNodes) {
                        "Cannot move shard: {} to node: [{}]. Decisions: [{}]",
import java.util.Map;
    private final RoutingAllocation allocation;
        RoutingNode sourceNode,
            return Decision.THROTTLE;
        if (remoteRoutingNodes.isEmpty()) {
    /**
                if (eligibleNodes.isEmpty()) {
                        "Cannot allocate shard: {} on node [{}]. Decisions: [{}]",
    }
    ) {
                break;
        while (shardsToBalance > 0 && shardIterator.hasNext() && targetNodes.isEmpty() == false) {
    @Override
     * For every primary shard for which this method is invoked, relocation of the shard id performed.
                }
import org.opensearch.cluster.routing.RoutingNode;
                    }
                    allocation.routingTable()
                                targetNode.nodeId(),
                routingNodes.unassigned().ignoreShard(shard, status, allocation.changes());
            }
            logger.debug("No remote searcher nodes available for unassigned remote shards.");
                routingNodes.unassigned().ignoreShard(shard, status, allocation.changes());
                } else {
                    forceMoveShards.add(shardRouting);
            int totalPrimaryShardsPerNode = 0;
            ShardRouting shard = shardIterator.next();
 * A {@link RemoteShardsBalancer} used by the {@link BalancedShardsAllocator} to perform allocation operations
                        unassignedInfo.getUnassignedTimeInNanos(),
                    assert eligibleNodes.stream().allMatch(rn -> nodesCheckedForShard.contains(rn.nodeId()));
                continue;
        return new ArrayDeque<>(nodeList);
        }
                if (logger.isTraceEnabled()) {
            }
                return;
                    if (logger.isTraceEnabled()) {
     * Groups unassigned shards within the allocation based on the index.
    }
            rebalanceDecision.type(),
    }
import java.util.Queue;
 *
            destinationNode.nodeId(),
                        shardShortSummary(shard),
import org.opensearch.cluster.routing.RoutingNodes;
                            shardLevelDecision.getDecisions(),
     * @param remoteRoutingNodes routing nodes for which the aggregation needs to be performed
    private void allocateUnassignedShards(
        private final Queue<ShardRouting> primaries = new ArrayDeque<>();
            }
    /**
                }
        }
            unassignedShardMap.get(index).addShard(shard);
            // skip the node that the target shard is currently allocated on
            ShardRouting targetShard = routingNodes.relocateShard(shard, destinationNode.nodeId(), shardSize, allocation.changes()).v2();
     */
            while (shardsToAllocate.isEmpty() == false && nodeQueue.isEmpty() == false) {
                    } else {
     * It does so without accounting for the local shards located on any nodes within the cluster.
                throttledNodeCount++;
        for (RoutingNode node : remoteRoutingNodes) {
        while (nodeQueue.isEmpty() == false) {
                eligibleNodes.offer(targetNode);
 */
                eligibleNodes.add(node);
        this.routingNodes = allocation.routingNodes();
            }
                                nodeDecision.toString()
     */
                    routingNodes.unassigned().ignoreShard(shard, UnassignedInfo.AllocationStatus.DECIDERS_NO, allocation.changes());
                );
        }
                    targetNode.nodeId(),
    // indicates if there are any nodes being throttled for allocating any unassigned shards
     */
                if (nodeLevelDecision.type() == Decision.Type.YES) {
            }
        public Queue<ShardRouting> getPrimaries() {
                    continue;
                    primaryCount.merge(targetNode.nodeId(), 1, Integer::sum);
                } else {
            if (currentShardDecision.type() == Decision.Type.YES) {
                    if (RecoverySource.Type.SNAPSHOT.equals(shard.recoverySource().getType()) == false
import org.apache.logging.log4j.Logger;
                    eligibleNodes.offer(targetNode);
     * @param nodeQueue ordered list of nodes to try allocation
                // Break out if all nodes in the queue have been checked for this shard
    private boolean anyNodesThrottled = false;
        }
            for (final ShardRouting ineligibleShard : sourceNode) {
    private void unassignIgnoredRemoteShards(RoutingAllocation routingAllocation) {
    }
            shard.id(),
            if (unassignedShardMap.containsKey(index) == false) {
                        && isWarmIndex(allocation.metadata().getIndexSafe(shard.index())) == false) {
            }
                    logger.trace(
import java.util.Collections;
 * for remote shards within the cluster.
    }
    /**
        unassignIgnoredRemoteShards(allocation);
            shard.currentNodeId(),
import java.util.Iterator;
        return nodeList;
    ) {
    }
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) == false) {
    }
                }
                // If all the target nodes are exhausted for the current shard; skip to next shard
                if (shardLevelDecision.type() == Decision.Type.NO) {
                if (primaryCount.get(targetNode.nodeId()) >= avgPrimary) {
            if (shard.primary()) {
                nodeList.add(rNode);
     */
                unassignedShards.ignoreShard(shard, shard.unassignedInfo().getLastAllocationStatus(), routingAllocation.changes());
}
            --numNodesToCheck;
                || shard.primary() == false
 * SPDX-License-Identifier: Apache-2.0
        allocateUnassignedShards(false, nodeQueue, unassignedShardMap);
            RoutingNode node = nodeQueue.poll();
                if (targetNode.getByShardId(shard.shardId()) != null) {
                }
        }
                tryShardMovementToEligibleNode(eligibleNodes, ineligibleShard);
    public RemoteShardsBalancer(Logger logger, RoutingAllocation allocation) {
                    allocation.snapshotShardSizeInfo(),
    @Override
        }
                    logger.trace("Avg shard limit reached for node: [{}]. Removing from queue.", targetNode.nodeId());
                replicas.add(shard);
                break;
                    return;
        public Queue<ShardRouting> getReplicas() {
        Set<String> nodesCheckedForRelocation = new HashSet<>();
        ArrayDeque<RoutingNode> targetNodes,
    MoveDecision decideRebalance(ShardRouting shardRouting) {
        boolean throttled = false;
            return Decision.YES;
/**
                if (allocation.deciders().canRemain(shardRouting, sourceNode, allocation) == Decision.NO) {
        final Map<String, Integer> primaryCount
     */
                    ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE,
            allocationDecision.type(),
                        shard.currentNodeId(),
                if (shard.primary()) {
            --numNodesToCheck;
    }
                    }
        }
                        targetNode.nodeId()
            for (ShardRouting shard : indexShards.getPrimaries()) {
        }
            Decision nodeDecision = allocation.deciders().canAllocateAnyShardToNode(node, allocation);
        }
        }
        HashMap<String, UnassignedIndexShards> unassignedShardMap = new HashMap<>();
        RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = routingNodes.unassigned().iterator();
            logger.debug(
                    shard,
                }
                primaries.add(shard);
                    if (nodeLevelDecision.type() == Decision.Type.THROTTLE) {
        // If any nodes are throttled during allocation, mark all remaining unassigned shards as THROTTLED
                throttledNodeCount
            if (nodeQueue.isEmpty()) {
        Decision rebalanceDecision = allocation.deciders().canRebalance(shard, allocation);
     */
                && shard.unassigned()
        }
                    }
                // to re-fetch any shard blocks from the repository.
        }
                continue;
            RoutingPool pool = RoutingPool.getShardPool(shard, routingAllocation);
        if (routingNodes.unassigned().isEmpty()) {
import java.util.HashMap;
        for (ShardRouting shard : routingNodes.unassigned().drain()) {
            Decision allocateDecision = allocation.deciders().canAllocate(shard, node, allocation);
                eligibleNodes.offer(targetNode);
    }
     * @opensearch.internal
                }
        final Map<String, Integer> primaryShardCount = new HashMap<>();
                    && shard.primary()
            } else {
                }
            // Find an active primary shard to relocate
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) && shard.primary()) {
            } else {
                "Excluded Node Count: [{}], Eligible Node Count: [{}], Throttled Node Count: [{}]",
     * {@link UnassignedIndexShards} maintains a queue of unassigned remote shards for allocation operations within
        // move shards that are currently assigned on excluded nodes
            for (ShardRouting shard : node) {
                    targetNodes.offer(targetNode);
    }
                            shardShortSummary(shard),
            }
                        unassignedInfo.getNumFailedAllocations(),
            } else {
        while (eligibleNodes.isEmpty() == false && excludedNodes.isEmpty() == false) {
                    && (shard.initializing() || shard.started())) {
                    continue;
import org.opensearch.cluster.routing.UnassignedInfo;
     * @return list of {@link RoutingPool#REMOTE_CAPABLE} routing nodes.
            return primaries;
             */
     * the cluster.
        }
        private final Queue<ShardRouting> replicas = new ArrayDeque<>();
                if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation))
            }
    @Override
            RoutingNode sourceNode = sourceNodes.poll();
                }
            while (targetNodes.isEmpty() == false) {
            UnassignedIndexShards indexShards = unassignedShardMap.get(index);
            );
        for (ShardRouting shard : unassignedShards.drainIgnored()) {
                    logger.trace("there are no eligible nodes available, return");
                        unassignedInfo.getUnassignedTimeInMillis(),
import static org.opensearch.action.admin.indices.tiering.TieringUtils.isWarmIndex;
 * compatible open source license.
        });
                }
    }
            "Relocating shard [{}] from node [{}] to node [{}]. AllocationDecision: [{}]. AllocationExplanation: [{}]. "
            }
    }
                    continue;
                ShardRouting unassignedShard = shard;
                    shard,
        final ArrayDeque<RoutingNode> sourceNodes = new ArrayDeque<>();
            }
                if (logger.isDebugEnabled()) {
        final ArrayDeque<RoutingNode> targetNodes = new ArrayDeque<>();
            for (final ShardRouting shardRouting : sourceNode) {
                            node.nodeId(),
     * @return map of node id to primary shard count
                ShardRouting shard = shardsToAllocate.poll();
     * @return {@link UnassignedIndexShards} grouped by index name
                routingNodes.relocateShard(
    void moveShards() {
                final Decision nodeLevelDecision = allocation.deciders().canAllocateAnyShardToNode(targetNode, allocation);
                        shardShortSummary(shard),
                    );
                sourceNodes.add(node);
    /**
        }
                unassignedShardMap.put(index, new UnassignedIndexShards());
    public Map<String, UnassignedIndexShards> groupUnassignedShardsByIndex() {
        for (final ShardRouting shard : forceMoveShards) {
        RoutingNodes.UnassignedShards unassignedShards = routingAllocation.routingNodes().unassigned();
        // until either sourceNode is balanced OR no more active primary shard available OR all the target nodes are exhausted
        this.allocation = allocation;
        int unassignedRemotePrimaryShardCount = 0;
                        unassignedInfo.isDelayed(),
    }
        );
    private Queue<RoutingNode> getShuffledRemoteNodes() {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                        if (logger.isTraceEnabled()) {
            if (nodePrimaryShardCount.get(node.nodeId()) > avgPrimaryPerNode) {
        }
            if (shardsToAllocate.isEmpty()) {
    private String shardShortSummary(ShardRouting shard) {
                assert nodesCheckedForShard.add(targetNode.nodeId());
     * Unassigned shards from {@link LocalShardsBalancer} are ignored since the balancer cannot allocate remote shards.
        Map<String, UnassignedIndexShards> unassignedShardMap = groupUnassignedShardsByIndex();
            allocationDecision.toString(),
     * Allocates unassigned remote shards on the routing node which are filtered using
                    assert nodesCheckedForShard.add(targetNode.nodeId());
        boolean allocated = false;
            }
                            nodeLevelDecision.getExplanation()
    private void ignoreRemainingShards(Map<String, UnassignedIndexShards> unassignedShardMap) {
        final Set<String> nodesCheckedForShard = new HashSet<>();
        public void addShard(ShardRouting shard) {
                        logger.debug(
                    totalPrimaryShardsPerNode++;
                if (shard.assignedToNode()) {
                    continue;
    private final Logger logger;
            return;
            if (shard.started() == false
                if (rebalanceDecision.type() == Decision.Type.YES) {
                        targetNodes.offer(targetNode);
                }
            }
import org.opensearch.common.Randomness;
     * Performs heuristic, naive weight-based balancing for remote shards within the cluster by using average nodes per
                    }
                    }
        if (nodeQueue.isEmpty()) {
    void allocateUnassigned() {
        while (sourceNodes.isEmpty() == false && targetNodes.isEmpty() == false) {
                // Find a valid target node that can accommodate the current shard relocation
                    // the target node from the target list
        }
     * @param eligibleNodes set of nodes that are still accepting shards
            logger.debug("No unassigned remote shards found.");
     * unassigned status.
                RoutingNode targetNode = targetNodes.poll();
    private void allocateUnassignedPrimaries(Queue<RoutingNode> nodeQueue, Map<String, UnassignedIndexShards> unassignedShardMap) {
                if (logger.isTraceEnabled()) {
            logger.debug("No eligible remote nodes found to perform balancing");
    /**
        }
     */
                if (targetNodes.stream().allMatch(node -> nodesCheckedForRelocation.contains(node.nodeId()))) {
                }
            }
            : UnassignedInfo.AllocationStatus.DECIDERS_NO;
        return Decision.NO;
    private void classifyNodesForShardMovement(Queue<RoutingNode> eligibleNodes, Queue<RoutingNode> excludedNodes) {
                            shardLevelDecision.getExplanation()
        int avgPrimary,
    private void tryShardMovementToEligibleNode(Queue<RoutingNode> eligibleNodes, ShardRouting shard) {
 *
                        unassignedInfo.getFailure(),
                allocated = true;
    AllocateUnassignedDecision decideAllocateUnassigned(ShardRouting shardRouting) {
        if ((allocationDecision.type() == Decision.Type.THROTTLE) || (rebalanceDecision.type() == Decision.Type.THROTTLE)) {
            UnassignedInfo.AllocationStatus status = (throttled || anyNodesThrottled)
                if (numNodesToCheck == 0) {
        this.logger = logger;
     * {@link #groupUnassignedShardsByIndex}
                    break;
     */
                        Collections.emptySet()
    /**
                                nodeDecision.getDecisions(),
        while (eligibleNodes.isEmpty() == false) {
 * @opensearch.internal
                    logger.debug(
        while (unassignedIterator.hasNext()) {
            if (shard.primary() && unassignedInfo.getLastAllocationStatus() == UnassignedInfo.AllocationStatus.NO_ATTEMPT) {
    }
            final Decision currentShardDecision = allocation.deciders().canAllocate(shard, targetNode, allocation);
     * Filters out and returns the list of {@link RoutingPool#REMOTE_CAPABLE} nodes from the routing nodes in cluster.
                if (ineligibleForMove(ineligibleShard)) {
                    shardsToBalance--;
                        logger.trace(
                    );
            return replicas;
                    logger.trace("Assigned shard [{}] to [{}]", shardShortSummary(shard), node.nodeId());
                        );
            if (eligibleNodes.isEmpty()) {
        allocateUnassignedShards(true, nodeQueue, unassignedShardMap);
                    allocation.clusterInfo(),
            return;
     * Calculates the total number of primary shards per node.
                    nodeQueue.offer(node);
        int totalPrimaryShardCount = nodePrimaryShardCount.values().stream().reduce(0, Integer::sum);
                // Try relocate the shard on the target node
                    // If the relocation attempt failed for the shard, check if the target node can accommodate any other shard; else remove
    @Override
                        nodesCheckedForRelocation.add(targetNode.nodeId());
            routingNodes.unassigned().ignoreShard(shard, status, allocation.changes());
    /**
                        anyNodesThrottled = true;
                        );
            tryRebalanceNode(sourceNode, targetNodes, avgPrimaryPerNode, nodePrimaryShardCount);
                            nodeLevelDecision.getDecisions()
 * this file be licensed under the Apache-2.0 license or a
     * @param eligibleNodes contains the list of classified nodes eligible to accept shards
                    ),
                        UnassignedInfo.AllocationStatus.DECIDERS_NO,
    private boolean ineligibleForMove(ShardRouting shard) {
        List<RoutingNode> remoteRoutingNodes = getRemoteRoutingNodes();
        }
                }
                // Break out if all eligible nodes have been examined
                // Shard when moved to an unassigned state updates the recovery source to be ExistingStoreRecoverySource
                }
                        unassignedShard = shard.updateUnassigned(shard.unassignedInfo(), RecoverySource.EmptyStoreRecoverySource.INSTANCE);
                }
     * Tries to move a shard assigned to an excluded node to an eligible node.
                tryAllocateUnassignedShard(nodeQueue, shard);
     * Tries to allocate an unassigned shard to one of the nodes within the node queue.
     * cluster as the metric for shard distribution.
    }
                        node.nodeId(),
package org.opensearch.cluster.routing.allocation.allocator;
                        allocateDecision.getDecisions()
/*
                    break;
            return;
                nodeQueue.offer(node);
            }
                            "Cannot allocate any shard to node: [{}]. Removing from queue. Node level decisions: [{}],[{}]",
                if (nodeLevelDecision.type() == Decision.Type.YES) {
                        "Moving shard: {} from node: [{}] to node: [{}]",
        int numNodesToCheck = nodeQueue.size();
            ? UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED
        int throttledNodeCount = 0;
            failUnattemptedShards();
        }
        // Try to relocate the valid shards on the sourceNode, one at a time;
                    logger.debug("Node: [{}] cannot accept any more shards. Removing it from queue.", targetNode.nodeId());
                continue;
                        logger.debug("Shard: {} already assigned to node: [{}]", shardShortSummary(shard), shard.currentNodeId());
        boolean primaries,
                }
                final long shardSize = DiskThresholdDecider.getExpectedShardSize(
                        );
                targetNodes.add(node);
    }
            }
    private void allocateUnassignedReplicas(Queue<RoutingNode> nodeQueue, Map<String, UnassignedIndexShards> unassignedShardMap) {
        // Perform the relocation of allocation and rebalance decisions are YES
import org.opensearch.cluster.routing.ShardRouting;
    }
                    return;
     * Performs shard movement for incompatible remote shards
        }
                    logger.debug("Node: [{}] can still accept shards. Adding it back to the queue.", targetNode.nodeId());
    }
    /**
                    allocation.metadata(),
                        shardShortSummary(shard),
                        currentShardDecision.getDecisions()
                }
    /**
     */
     *
                                "Cannot allocate any shard to node: [{}]. Removing from queue. Node level decisions: [{}],[{}]",
        for (RoutingNode rNode : routingNodes) {
            }
import java.util.Set;
                || RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) == false) {
        for (RoutingNode node : remoteRoutingNodes) {
        allocateUnassignedReplicas(nodeQueue, unassignedShardMap);
                    allocation.changes()
                    }
                    if (logger.isTraceEnabled()) {
                            nodeLevelDecision.getDecisions(),
    void balance() {
        totalPrimaryShardCount += unassignedRemotePrimaryShardCount;
    }
            if (targetNode.nodeId().equals(shard.currentNodeId())) {
                }
        }
            }
import java.util.ArrayList;
                        targetNode.nodeId(),
        Iterator<ShardRouting> shardIterator = sourceNode.copyShards().iterator();
    @Override
                        logger.trace(
     * @param excludedNodes contains the list of classified nodes that are unable for assigning shards
                            logger.trace(
                }
     * Classifies the nodes into eligible and excluded depending on whether node is able or unable for shard assignment
                } else {
    private void tryAllocateUnassignedShard(Queue<RoutingNode> nodeQueue, ShardRouting shard) {
        Queue<RoutingNode> nodeQueue = getShuffledRemoteNodes();
            String index = shard.getIndexName();
        allocateUnassignedPrimaries(nodeQueue, unassignedShardMap);
                Decision rebalanceDecision = tryRelocateShard(shard, targetNode);
        Randomness.shuffle(nodeList);
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
                    if (nodeDecision.type() == Decision.Type.YES) {
                    shard.recoverySource(),
    @Override
                    break;
            } else {
        Queue<RoutingNode> excludedNodes = new ArrayDeque<>();
        for (String index : unassignedShardMap.keySet()) {
                routingNodes.initializeShard(shard, node.nodeId(), null, shardSize, allocation.changes());
    private final RoutingNodes routingNodes;
             * as excluded nodes, we look for Decision.Type.NO
            assert numNodesToCheck > 0;
                            "Node: [{}] can still accept shards, retaining it in queue - [{}]",
            }
                    return;
        }
                routingNodes.unassigned().add(shard);
        for (UnassignedIndexShards indexShards : unassignedShardMap.values()) {
                    continue;
                + "RebalanceDecision: [{}]. RebalanceExplanation: [{}]",
            if (pool == RoutingPool.REMOTE_CAPABLE
