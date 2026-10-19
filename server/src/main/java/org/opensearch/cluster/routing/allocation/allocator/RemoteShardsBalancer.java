    /**
                            logger.trace(
     * Prior to allocation operations done by {@link RemoteShardsBalancer}, the ignored remote shards are moved back to
                    allocation.clusterInfo().getShardSize(shard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE),
            }  
                unassignedShards.ignoreShard(shard, shard.unassignedInfo().getLastAllocationStatus(), routingAllocation.changes());  
    }
 * compatible open source license.
                    );  
        List<RoutingNode> remoteRoutingNodes = getRemoteRoutingNodes();
        eligibleNodes.forEach(sourceNode -> {
        return Decision.NO;
     */
                    continue;  
    private void ignoreRemainingShards(Map<String, UnassignedIndexShards> unassignedShardMap) {
    private boolean ineligibleForMove(ShardRouting shard) {
    @Override
                }
                    );
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) == false) {
            }  
            "Relocating shard [{}] from node [{}] to node [{}]. AllocationDecision: [{}]. AllocationExplanation: [{}]. "  
    }
                        );
    }  
        totalPrimaryShardCount += unassignedRemotePrimaryShardCount;
            logger.info("Relocated shard [{}] to node [{}] during primary Rebalance", shard, targetShard.currentNodeId());  
                // Find a valid target node that can accommodate the current shard relocation
            shard.id(),
                        anyNodesThrottled = true;
    }
                    primaryCount.merge(targetNode.nodeId(), 1, Integer::sum);  
                || RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) == false) {  
            for (ShardRouting shard : node) {  
        Queue<RoutingNode> nodeQueue,  
                    continue;
            : UnassignedInfo.AllocationStatus.DECIDERS_NO;
                }
                    logger.trace("Avg shard limit reached for node: [{}]. Removing from queue.", targetNode.nodeId());
            logger.debug(
                && (shard.primary() || shard.unassignedInfo().isDelayed() == false)) {
                if (ineligibleForMove(shardRouting)) {
        while (eligibleNodes.isEmpty() == false) {
                assert nodesCheckedForShard.add(targetNode.nodeId());
    @Override
        for (RoutingNode node : remoteRoutingNodes) {
                    continue;
                    logger.debug("Node: [{}] can still accept shards. Adding it back to the queue.", targetNode.nodeId());
        allocateUnassignedReplicas(nodeQueue, unassignedShardMap);
            // skip the node that the target shard is currently allocated on
            // Find an active primary shard to relocate
                if (rebalanceDecision.type() == Decision.Type.YES) {
        public Queue<ShardRouting> getPrimaries() {
                            shardLevelDecision.getDecisions(),  
        return new ArrayDeque<>(nodeList);  
            rebalanceDecision.toString()
import org.opensearch.cluster.routing.RoutingPool;
        final int avgPrimaryPerNode = (totalPrimaryShardCount + remoteRoutingNodes.size() - 1) / remoteRoutingNodes.size();  
                replicas.add(shard);
                }
            }  
            for (final ShardRouting shardRouting : sourceNode) {  
        int totalPrimaryShardCount = nodePrimaryShardCount.values().stream().reduce(0, Integer::sum);  
        private final Queue<ShardRouting> replicas = new ArrayDeque<>();
            UnassignedInfo unassignedInfo = shard.unassignedInfo();  
                    ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE,
                    if (logger.isTraceEnabled()) {
        for (ShardRouting shard : routingNodes.unassigned().drain()) {  
                    break;
        Iterator<ShardRouting> shardIterator = sourceNode.copyShards().iterator();
    private final RoutingNodes routingNodes;
        if (nodeQueue.isEmpty()) {  
    private void allocateUnassignedReplicas(Queue<RoutingNode> nodeQueue, Map<String, UnassignedIndexShards> unassignedShardMap) {  
        for (UnassignedIndexShards indexShards : unassignedShardMap.values()) {  
                    logger.trace(  
    private Decision tryRelocateShard(ShardRouting shard, RoutingNode destinationNode) {
                        );  
        RoutingNode sourceNode,
                }
        if (routingNodes.unassigned().isEmpty()) {  
                }
                Decision nodeLevelDecision = allocation.deciders().canAllocateAnyShardToNode(node, allocation);
                        if (logger.isTraceEnabled()) {  
import org.opensearch.cluster.routing.RoutingNodes;
        if (allocated == false) {
    void moveShards() {
        Set<String> nodesCheckedForRelocation = new HashSet<>();  
        boolean throttled = false;
        boolean primaries,
                    break;
                        );
}  
                logger.trace("there are no eligible nodes available, return");  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            for (ShardRouting shard : indexShards.getReplicas()) {
                    // the target node from the target list
    void allocateUnassigned() {
                    routingNodes.unassigned().ignoreShard(shard, UnassignedInfo.AllocationStatus.DECIDERS_NO, allocation.changes());
            assert numNodesToCheck > 0;
    }
            for (final ShardRouting ineligibleShard : sourceNode) {
                    new UnassignedInfo(  
        ignoreRemainingShards(unassignedShardMap);  
            ? UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED
        for (String index : unassignedShardMap.keySet()) {  
                    allocation.routingTable()  
            allocationDecision.type(),
                    shard.recoverySource(),
     */
                                targetNode.nodeId(),  
            Decision nodeDecision = allocation.deciders().canAllocateAnyShardToNode(node, allocation);
            if (allocateDecision.type() == Decision.Type.YES) {
                excludedNodes.add(node);
                    eligibleNodes.offer(targetNode);
            } else {
    ) {
 * for remote shards within the cluster.  
                } else {
                }  
                unassignedShards.add(unassignedShard);
            }  
                                "Cannot allocate any shard to node: [{}]. Removing from queue. Node level decisions: [{}],[{}]",
    /**
                    continue;
            }  
    MoveDecision decideMove(ShardRouting shardRouting) {  
    }
                    shard,
            logger.debug("No eligible remote nodes found to perform balancing");
     * @param remoteRoutingNodes routing nodes for which the aggregation needs to be performed
            logger.debug("Allocating shards for index: [{}]", index);
            return;
                            node.nodeId(),
                );
            routingNodes.unassigned().ignoreShard(shard, status, allocation.changes());
    }
        Queue<RoutingNode> nodeQueue = getShuffledRemoteNodes();
        logger.trace(
                ? UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED  
                        unassignedInfo.getUnassignedTimeInMillis(),  
                if (logger.isTraceEnabled()) {
                nodeList.add(rNode);
        // Iterate through all shards index by index and allocate them
                }  
            for (ShardRouting shard : indexShards.getPrimaries()) {
     * {@link UnassignedIndexShards} maintains a queue of unassigned remote shards for allocation operations within  
                        allocateDecision.getDecisions()  
     * Performs shard movement for incompatible remote shards
                + "RebalanceDecision: [{}]. RebalanceExplanation: [{}]",
     * Calculates the total number of primary shards per node.
        if (remoteRoutingNodes.isEmpty()) {  
                break;
                        "Moving shard: {} from node: [{}] to node: [{}]",
            return Decision.THROTTLE;
        public void addShard(ShardRouting shard) {  
                    allocation.snapshotShardSizeInfo(),
        allocateUnassignedShards(false, nodeQueue, unassignedShardMap);
            }
        int unassignedRemotePrimaryShardCount = 0;
    private Queue<RoutingNode> getShuffledRemoteNodes() {  
                    assert eligibleNodes.stream().allMatch(rn -> nodesCheckedForShard.contains(rn.nodeId()));
                    allocation.changes()  
     * Unassigned shards from {@link LocalShardsBalancer} are ignored since the balancer cannot allocate remote shards.  
    }  
        allocateUnassignedPrimaries(nodeQueue, unassignedShardMap);
        List<RoutingNode> nodeList = new ArrayList<>();
            ShardRouting targetShard = routingNodes.relocateShard(shard, destinationNode.nodeId(), shardSize, allocation.changes()).v2();
    }  
/*  
                    if (logger.isDebugEnabled()) {  
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;  
                tryAllocateUnassignedShard(nodeQueue, shard);
                eligibleNodes.add(node);  
        throw new UnsupportedOperationException("remote shards balancer does not support decision operations");
            /* canAllocateAnyShardToNode decision can be THROTTLE for throttled nodes. To classify  
 */  
        HashMap<String, UnassignedIndexShards> unassignedShardMap = new HashMap<>();
        final Map<String, Integer> primaryCount
        while (unassignedIterator.hasNext()) {
        final List<ShardRouting> forceMoveShards = new ArrayList<>();
        Map<String, UnassignedIndexShards> unassignedShardMap
        for (RoutingNode node : remoteRoutingNodes) {
    }
                    allocation.metadata(),
     * @param shard the ineligible shard to be moved
        Decision rebalanceDecision = allocation.deciders().canRebalance(shard, allocation);
import org.opensearch.cluster.routing.allocation.decider.Decision;
     */  
        assert destinationNode.getByShardId(shard.shardId()) == null;
                }  
        final ArrayDeque<RoutingNode> sourceNodes = new ArrayDeque<>();
                        shardShortSummary(shard),
            if (unassignedShardMap.containsKey(index) == false) {  
    private void unassignIgnoredRemoteShards(RoutingAllocation routingAllocation) {
import java.util.Collections;
    private void tryShardMovementToEligibleNode(Queue<RoutingNode> eligibleNodes, ShardRouting shard) {
        }  
                continue;
     */  
    }
            destinationNode.nodeId(),
        this.logger = logger;  
             * as excluded nodes, we look for Decision.Type.NO
                    forceMoveShards.add(shardRouting);  
     * @return {@link UnassignedIndexShards} grouped by index name
            if (targetNode.nodeId().equals(shard.currentNodeId())) {  
    public RemoteShardsBalancer(Logger logger, RoutingAllocation allocation) {
    }
    }
        }
    /**  
        // until either sourceNode is balanced OR no more active primary shard available OR all the target nodes are exhausted  
                tryShardMovementToEligibleNode(eligibleNodes, ineligibleShard);
                } else {  
                        Collections.emptySet()  
        // Perform the relocation of allocation and rebalance decisions are YES
                            nodeLevelDecision.getDecisions()
    /**
     * For every primary shard for which this method is invoked, relocation of the shard id performed.
                continue;  
import java.util.HashMap;  
            } else {
                            nodeLevelDecision.getExplanation()
            return;
            }
     * @param shard the unassigned shard which needs to be allocated
                Decision rebalanceDecision = tryRelocateShard(shard, targetNode);
            String index = shard.getIndexName();
                    }  
                                nodeDecision.toString()
import java.util.Map;
    private void allocateUnassignedShards(
                }
                if (shard.primary()) {  
                            shardLevelDecision.getExplanation()
     *
                        }
                routingNodes.unassigned().add(shard);  
                eligibleNodes.offer(targetNode);
        }
                    // If the relocation attempt failed for the shard, check if the target node can accommodate any other shard; else remove
                }  
     *  
                // Shard when moved to an unassigned state updates the recovery source to be ExistingStoreRecoverySource  
                }
                    nodeQueue.offer(node);
        }
    }
        allocateUnassignedShards(true, nodeQueue, unassignedShardMap);  
                if (shardLevelDecision.type() == Decision.Type.NO) {
                    allocation.clusterInfo(),  
                ShardRouting shard = shardsToAllocate.poll();
                if (targetNodes.stream().allMatch(node -> nodesCheckedForRelocation.contains(node.nodeId()))) {  
import static org.opensearch.action.admin.indices.tiering.TieringUtils.isWarmIndex;
        final ArrayDeque<RoutingNode> targetNodes = new ArrayDeque<>();  
                excludedNodes.size(),  
            logger.debug("No remote searcher nodes available for unassigned remote shards.");
                            "Cannot allocate any shard to node: [{}]. Removing from queue. Node level decisions: [{}],[{}]",
            ShardRouting shard = unassignedIterator.next();
            }
        ArrayDeque<RoutingNode> targetNodes,
            rebalanceDecision.type(),
    }
                    } else {
            }  
import java.util.Iterator;
    /**
        RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = routingNodes.unassigned().iterator();  
     * It does so without accounting for the local shards located on any nodes within the cluster.
import java.util.Queue;
import org.opensearch.cluster.routing.RoutingNode;  
                        && isWarmIndex(allocation.metadata().getIndexSafe(shard.index())) == false) {
        public Queue<ShardRouting> getReplicas() {  
                    return;
 *
        RoutingNodes.UnassignedShards unassignedShards = routingAllocation.routingNodes().unassigned();
     * @param excludedNodes contains the list of classified nodes that are unable for assigning shards
    }  
            RoutingNode sourceNode = sourceNodes.poll();
            while (targetNodes.isEmpty() == false) {
            tryShardMovementToEligibleNode(eligibleNodes, shard);
     */
                final Decision nodeLevelDecision = allocation.deciders().canAllocateAnyShardToNode(targetNode, allocation);
        long shardsToBalance = primaryCount.get(sourceNode.nodeId()) - avgPrimary;  
        if ((allocationDecision.type() == Decision.Type.THROTTLE) || (rebalanceDecision.type() == Decision.Type.THROTTLE)) {
            } else {  
                primaries.add(shard);
 * @opensearch.internal
    }  
                    allocation.changes()  
                    && shard.primary()
        Queue<RoutingNode> eligibleNodes = new ArrayDeque<>();
     * {@link #groupUnassignedShardsByIndex}
                        "Cannot move shard: {} to node: [{}]. Decisions: [{}]",
     */  
            }
import org.opensearch.common.Randomness;
            }
        // If any nodes are throttled during allocation, mark all remaining unassigned shards as THROTTLED
     * Performs heuristic, naive weight-based balancing for remote shards within the cluster by using average nodes per  
        while (shardsToBalance > 0 && shardIterator.hasNext() && targetNodes.isEmpty() == false) {
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) && shard.primary()) {
    /**  
     * cluster as the metric for shard distribution.
                unassignedIterator.updateUnassigned(
                    totalPrimaryShardsPerNode++;
            if (pool == RoutingPool.REMOTE_CAPABLE
    }  
                    if (RecoverySource.Type.SNAPSHOT.equals(shard.recoverySource().getType()) == false
                        logger.debug("Shard: {} already assigned to node: [{}]", shardShortSummary(shard), shard.currentNodeId());
                } else {  
    private final RoutingAllocation allocation;  
import java.util.HashSet;
            int totalPrimaryShardsPerNode = 0;
                if (logger.isDebugEnabled()) {  
        }
                    ),
    }
                        targetNode.nodeId(),  
            }  
                return;
                        logger.trace(
import java.util.List;  
    private void tryRebalanceNode(  
        });  
                sourceNodes.add(node);  
                allocated = true;
                if (numNodesToCheck == 0) {
        if ((allocationDecision.type() == Decision.Type.YES) && (rebalanceDecision.type() == Decision.Type.YES)) {  
    ) {
                            );  
            if (nodePrimaryShardCount.get(node.nodeId()) > avgPrimaryPerNode) {
                }
            while (shardsToAllocate.isEmpty() == false && nodeQueue.isEmpty() == false) {  
import org.opensearch.cluster.routing.ShardRouting;  
                        unassignedInfo.isDelayed(),
        private final Queue<ShardRouting> primaries = new ArrayDeque<>();  
 * this file be licensed under the Apache-2.0 license or a
        for (ShardRouting shard : routingNodes.unassigned()) {  
                        logger.trace(  
                        targetNode.nodeId()
    private boolean anyNodesThrottled = false;  
                        unassignedInfo.getFailure(),  
            --numNodesToCheck;  
        }
        throw new UnsupportedOperationException("remote shards balancer does not support decision operations");
     * @return list of {@link RoutingPool#REMOTE_CAPABLE} routing nodes.
                ShardRouting unassignedShard = shard;
    private void failUnattemptedShards() {
                routingNodes.relocateShard(
            if (nodeDecision.type() == Decision.Type.NO) {  
        }  
        return shard.started() == false || RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) == false;
                if (ineligibleForMove(ineligibleShard)) {
             */
                }
            allocationDecision.toString(),  
                if (nodeLevelDecision.type() == Decision.Type.YES) {  
                break;
                : UnassignedInfo.AllocationStatus.DECIDERS_NO;
                        unassignedInfo.getMessage(),
    // indicates if there are any nodes being throttled for allocating any unassigned shards
        classifyNodesForShardMovement(eligibleNodes, excludedNodes);
                    logger.debug(
                    assert nodesCheckedForShard.add(targetNode.nodeId());  
                throttled = throttled || allocateDecision.type() == Decision.Type.THROTTLE;  
            }
                "Excluded Node Count: [{}], Eligible Node Count: [{}], Throttled Node Count: [{}]",
        }
            if (eligibleNodes.isEmpty()) {
                    if (nodeLevelDecision.type() == Decision.Type.THROTTLE) {
        }
            shard.currentNodeId(),  
        }
                    if (logger.isTraceEnabled()) {
            }
                }
     * Classifies the nodes into eligible and excluded depending on whether node is able or unable for shard assignment  
                    targetNodes.offer(targetNode);
                    shard,  
    /**
                        node.nodeId(),
                    logger.trace(
                    return;
            );  
            UnassignedIndexShards indexShards = unassignedShardMap.get(index);
     */
                    }
    private Map<String, Integer> calculateNodePrimaryShardCount(List<RoutingNode> remoteRoutingNodes) {
                if (shard.assignedToNode()) {
import java.util.ArrayList;
        }
    /**
            return primaries;  
            return Decision.YES;
                    }
        int avgPrimary,  
                throttledNodeCount++;
    }  
            }  
                if (logger.isTraceEnabled()) {  
        boolean allocated = false;
                        unassignedShard = shard.updateUnassigned(shard.unassignedInfo(), RecoverySource.EmptyStoreRecoverySource.INSTANCE);  
                routingNodes.initializeShard(shard, node.nodeId(), null, shardSize, allocation.changes());
                        unassignedInfo.getUnassignedTimeInNanos(),
    private final Logger logger;
                            shardShortSummary(shard),
    @Override  
                }  
        for (ShardRouting shard : unassignedShards.drainIgnored()) {  
     * the cluster.
                    logger.trace("there are no eligible nodes available, return");
                // Break out if all eligible nodes have been examined
        this.allocation = allocation;
            if (shardsToAllocate.isEmpty()) {
     */  
public final class RemoteShardsBalancer extends ShardsBalancer {
        }  
                    }
    @Override
            if (shard.started() == false
                                nodeDecision.getDecisions(),
                && shard.unassigned()  
    MoveDecision decideRebalance(ShardRouting shardRouting) {
        }
        assert shardsToBalance >= 0 : "Shards to balance should be greater than 0, but found negative";
                );
                    }  
        }
    }
            if (shard.primary()) {
        return primaryShardCount;  
            failUnattemptedShards();
        List<RoutingNode> nodeList = getRemoteRoutingNodes();
                unassignedRemotePrimaryShardCount++;
import org.apache.logging.log4j.Logger;
                }  
            RoutingPool pool = RoutingPool.getShardPool(shard, routingAllocation);
        }
                if (logger.isTraceEnabled()) {
        for (RoutingNode node : remoteRoutingNodes) {
     * Tries to move a shard assigned to an excluded node to an eligible node.
                if (numNodesToCheck == 0) {  
        final Map<String, Integer> primaryShardCount = new HashMap<>();  
            } else {
            return;  
                // to re-fetch any shard blocks from the repository.
        List<RoutingNode> remoteRoutingNodes = getRemoteRoutingNodes();  
        while (sourceNodes.isEmpty() == false && targetNodes.isEmpty() == false) {  
        );  
                if (allocation.deciders().canRemain(shardRouting, sourceNode, allocation) == Decision.NO) {
                unassignedShardMap.put(index, new UnassignedIndexShards());
package org.opensearch.cluster.routing.allocation.allocator;
import java.util.Set;  
        Map<String, UnassignedIndexShards> unassignedShardMap = groupUnassignedShardsByIndex();  
            tryRebalanceNode(sourceNode, targetNodes, avgPrimaryPerNode, nodePrimaryShardCount);
                    continue;  
    private void classifyNodesForShardMovement(Queue<RoutingNode> eligibleNodes, Queue<RoutingNode> excludedNodes) {
import java.util.ArrayDeque;  
                        shard.currentNodeId(),
        // Try to relocate the valid shards on the sourceNode, one at a time;
        logger.debug("Allocating unassigned {}. Nodes available in queue: [{}]", (primaries ? "primaries" : "replicas"), nodeQueue.size());  
        final UnassignedInfo.AllocationStatus status = anyNodesThrottled  
    @Override  
     * @opensearch.internal  
                        shardShortSummary(shard),
                if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation))
                    targetNode.nodeId(),
                // Remote shards do not have an existing store to recover from and can be recovered from an empty source
                }
            return replicas;
                if (numNodesToCheck == 0) {  
        // move shards that are currently assigned on excluded nodes
    }  
        throw new UnsupportedOperationException("remote shards balancer does not support decision operations");  
    /**  
     * Allocates unassigned remote shards on the routing node which are filtered using  
    /**  
                    shardsToBalance--;
            }  
        // move shards that cannot remain on eligible nodes  
        while (eligibleNodes.isEmpty() == false && excludedNodes.isEmpty() == false) {
                        targetNodes.offer(targetNode);  
                routingNodes.unassigned().ignoreShard(shard, status, allocation.changes());
            primaryShardCount.put(node.nodeId(), totalPrimaryShardsPerNode);
            }  
     */  
     * @param nodeQueue ordered list of nodes to try allocation  
     * Groups unassigned shards within the allocation based on the index.
                if (targetNode.getByShardId(shard.shardId()) != null) {  
     * @param eligibleNodes contains the list of classified nodes eligible to accept shards
                        logger.debug(  
    public Map<String, UnassignedIndexShards> groupUnassignedShardsByIndex() {
            final long shardSize = allocation.clusterInfo().getShardSize(shard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
        }
    }  
            RoutingNode sourceNode = excludedNodes.poll();  
     * @param eligibleNodes set of nodes that are still accepting shards
            --numNodesToCheck;
                    }  
import org.opensearch.cluster.routing.allocation.MoveDecision;  
                Decision shardLevelDecision = allocation.deciders().canAllocate(shard, allocation);  
            unassignedShardMap.get(index).addShard(shard);  
        }  
     */  
            }
                        nodesCheckedForRelocation.add(targetNode.nodeId());
        final Set<String> nodesCheckedForShard = new HashSet<>();
            logger.debug("No unassigned remote shards found.");
                            node.nodeId(),
                return;  
                    logger.trace("Assigned shard [{}] to [{}]", shardShortSummary(shard), node.nodeId());
                }
                    if (nodeDecision.type() == Decision.Type.YES) {
        int throttledNodeCount = 0;  
                    continue;  
                continue;
            UnassignedInfo.AllocationStatus status = (throttled || anyNodesThrottled)
    private void allocateUnassignedPrimaries(Queue<RoutingNode> nodeQueue, Map<String, UnassignedIndexShards> unassignedShardMap) {
        Decision allocationDecision = allocation.deciders().canAllocate(shard, destinationNode, allocation);  
            }  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                nodeQueue.offer(node);  
/**
                    logger.debug("Node: [{}] cannot accept any more shards. Removing it from queue.", targetNode.nodeId());
                }  
            } else {  
        }
                        currentShardDecision.getDecisions()
            if (shard.primary() && unassignedInfo.getLastAllocationStatus() == UnassignedInfo.AllocationStatus.NO_ATTEMPT) {
                        unassignedInfo.getReason(),
            Decision allocateDecision = allocation.deciders().canAllocate(shard, node, allocation);
                continue;
    private void tryAllocateUnassignedShard(Queue<RoutingNode> nodeQueue, ShardRouting shard) {  
     * unassigned status.
            }
                        unassignedInfo.getNumFailedAllocations(),
    /**
        Randomness.shuffle(nodeList);
            if (nodeQueue.isEmpty()) {
                throttledNodeCount
                targetNodes.add(node);
        int numNodesToCheck = eligibleNodes.size();  
                        UnassignedInfo.AllocationStatus.DECIDERS_NO,
                }  
    AllocateUnassignedDecision decideAllocateUnassigned(ShardRouting shardRouting) {
        return nodeList;
 * SPDX-License-Identifier: Apache-2.0
            RoutingNode node = nodeQueue.poll();
    /**
                // Try relocate the shard on the target node
                    }
    }
                        "Cannot allocate shard: {} on node [{}]. Decisions: [{}]",  
    private List<RoutingNode> getRemoteRoutingNodes() {
        while (nodeQueue.isEmpty() == false) {
                    );
            if (currentShardDecision.type() == Decision.Type.YES) {
    private String shardShortSummary(ShardRouting shard) {
        int numNodesToCheck = nodeQueue.size();  
    }
     */
        }
        return unassignedShardMap;
        }  
                final long shardSize = DiskThresholdDecider.getExpectedShardSize(  
                }
        }
                    break;
import org.opensearch.cluster.routing.UnassignedInfo;
            } else if (nodeDecision.type() == Decision.Type.YES) {
                // If all the target nodes are exhausted for the current shard; skip to next shard
                    && (shard.initializing() || shard.started())) {  
            }
 *
                    return;
        }  
                            "Node: [{}] can still accept shards, retaining it in queue - [{}]",  
                || shard.primary() == false
                            nodeLevelDecision.getDecisions(),  
                );
        }
                if (primaryCount.get(targetNode.nodeId()) >= avgPrimary) {
            } else if (nodePrimaryShardCount.get(node.nodeId()) < avgPrimaryPerNode) {
    @Override  
                    if (logger.isDebugEnabled()) {
                routingNodes.unassigned().ignoreShard(shard, status, allocation.changes());
                            "Ignoring shard: [{}] as is cannot be allocated to any node. Shard level decisions: [{}][{}].",
 * The OpenSearch Contributors require contributions made to  
        return "[" + shard.getIndexName() + "]" + "[" + shard.getId() + "]" + "[" + (shard.primary() ? "p" : "r") + "]";  
        for (RoutingNode rNode : routingNodes) {  
        unassignIgnoredRemoteShards(allocation);
            }  
                // Break out if all nodes in the queue have been checked for this shard  
 * A {@link RemoteShardsBalancer} used by the {@link BalancedShardsAllocator} to perform allocation operations
        final Map<String, Integer> nodePrimaryShardCount = calculateNodePrimaryShardCount(remoteRoutingNodes);
                RoutingNode targetNode = targetNodes.poll();  
            ShardRouting shard = shardIterator.next();  
    void balance() {
                if (nodeLevelDecision.type() == Decision.Type.YES) {  
            final RoutingNode targetNode = eligibleNodes.poll();  
            }
        for (final ShardRouting shard : forceMoveShards) {
        }  
 */  
            final Decision currentShardDecision = allocation.deciders().canAllocate(shard, targetNode, allocation);  
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getNodePool(rNode))) {
        logger.trace("Performing balancing for remote shards.");
            Queue<ShardRouting> shardsToAllocate = primaries ? indexShards.getPrimaries() : indexShards.getReplicas();  
        Queue<RoutingNode> excludedNodes = new ArrayDeque<>();  
        this.routingNodes = allocation.routingNodes();
                        shardShortSummary(shard),  
                eligibleNodes.size(),
        }
                    Decision nodeDecision = allocation.deciders().canAllocateAnyShardToNode(targetNode, allocation);
     * Filters out and returns the list of {@link RoutingPool#REMOTE_CAPABLE} nodes from the routing nodes in cluster.
                eligibleNodes.offer(targetNode);
                if (eligibleNodes.isEmpty()) {  
    public static class UnassignedIndexShards {
     */  
     * Tries to allocate an unassigned shard to one of the nodes within the node queue.
     * @return map of node id to primary shard count  
import org.opensearch.cluster.routing.RecoverySource;
