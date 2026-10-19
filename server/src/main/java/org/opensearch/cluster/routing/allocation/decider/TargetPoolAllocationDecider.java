                    DiscoveryNodeRole.DATA_ROLE.roleName()
/**
import org.opensearch.cluster.routing.RoutingNode;
            && !node.getRoles().contains(DiscoveryNodeRole.DATA_ROLE)) {
            }
                targetPool.name(),
                    DiscoveryNodeRole.DATA_ROLE.roleName()
    @Override
                Decision.NO,
        RoutingPool shardPool = RoutingPool.getShardPool(shardRouting, allocation);
            "Routing pools are compatible. Index pool: [%s], node pool: [%s]",
                NAME,
            NAME,
                    "Routing pools are incompatible. Index pool: [%s], node pool: [%s] without [%s] role",
        } else if (RoutingPool.LOCAL_ONLY.equals(shardPool)
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            indexPool,
        return canAllocateInTargetPool(indexMetadata, node.node(), allocation);
            shardPool,
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
            targetNodePool
            && targetPool != currentNodePool
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    }
                return allocation.decision(
                    indexPool,
        );
            NAME,
import org.opensearch.cluster.routing.RoutingPool;
 *
                return allocation.decision(
    private static final Logger logger = LogManager.getLogger(TargetPoolAllocationDecider.class);
        } else if (RoutingPool.LOCAL_ONLY.equals(targetPool)
        );
        if (RoutingPool.REMOTE_CAPABLE.equals(targetPool) && targetPool != currentNodePool) {
            "Routing pools are compatible. Shard pool: [%s], node pool: [%s]",
        RoutingPool targetNodePool = RoutingPool.getNodePool(node);
                node.node()
                "Shard: [{}] has current pool: [{}], target pool: [{}]. Cannot remain on node: [{}]",
                currentNodePool,
                shardRouting,
                return allocation.decision(
            );
            Decision.YES,
                shardRouting.shortSummary(),
            );
            logger.debug(
 */
            logger.debug(
                NAME,
            targetNodePool
public class TargetPoolAllocationDecider extends AllocationDecider {
                );
                    NAME,
                indexPool,
        return allocation.decision(
 * {@link TargetPoolAllocationDecider} ensures that the different shard types are assigned to the nodes with
}
                    NAME,
/*
        RoutingPool indexPool = RoutingPool.getIndexPool(indexMetadata);
                    shardRouting,
            );
                logger.debug(
                    currentNodePool,
                    targetPool,
        return allocation.decision(
import org.opensearch.cluster.node.DiscoveryNode;
package org.opensearch.cluster.routing.allocation.decider;
                currentNodePool.name(),
    private Decision canAllocateInTargetPool(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
                Decision.NO,
import org.apache.logging.log4j.LogManager;
            Decision.YES,
                );
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
                "Routing pools are incompatible. Index pool: [%s], node pool: [%s]",
 * this file be licensed under the Apache-2.0 license or a
            && !node.node().getRoles().contains(DiscoveryNodeRole.DATA_ROLE)) {
            }
            && !node.node().getRoles().contains(DiscoveryNodeRole.DATA_ROLE)) {
                indexPool,
        RoutingPool targetNodePool = RoutingPool.getNodePool(node);
                    DiscoveryNodeRole.DATA_ROLE.roleName()
                    DiscoveryNodeRole.DATA_ROLE.roleName()
import org.opensearch.cluster.metadata.IndexMetadata;
            NAME,
        return canAllocateInTargetPool(indexMetadata, node, allocation);
                    node.node(),
                    node.node(),
                node.node(),
 * The OpenSearch Contributors require contributions made to
            );
        logger.debug("Evaluating force allocation for primary shard.");
 * SPDX-License-Identifier: Apache-2.0
                    "Shard: [{}] has target pool: [{}]. Cannot remain on node: [{}] without the [{}] node role",
                    shardPool,
                shardPool,
    }
                    targetNodePool,
                node,
        RoutingPool currentNodePool = RoutingPool.getNodePool(allocation.routingNodes().node(shardRouting.currentNodeId()));
        logger.debug("Evaluating node: {} for autoExpandReplica eligibility of index: {}", node, indexMetadata.getIndex());
                shardPool,
                logger.debug(
                    "Routing pools are incompatible. Shard pool: [%s], node pool: [%s] without [%s] role",
    }
                    Decision.NO,
                targetNodePool
            logger.debug(
 * compatible open source license.
                    NAME,
                shardRouting.shortSummary(),
 * appropriate capabilities. The node pools with respective capabilities are defined within {@link RoutingPool}.
                targetNodePool
                targetPool
    public static final String NAME = "target_pool";
                Decision.NO,
        RoutingPool targetPool = RoutingPool.getShardPool(shardRouting, allocation);
                    Decision.NO,
    }
    @Override
                );
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    "Routing pools are incompatible. Shard pool: [%s], node pool: [%s] without [%s] role",
            currentNodePool,
            );
                    "Index: [{}] has target pool: [{}]. Cannot allocate on node: [{}] without the [{}] node role",
 * @opensearch.internal
                logger.debug(
                NAME,
 *
                "Shard: [{}] has target pool: [{}]. Cannot allocate on node: [{}] with target pool: [{}]",
    }
            return allocation.decision(
                targetNodePool
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    shardPool,
                    DiscoveryNodeRole.DATA_ROLE.roleName()
                    DiscoveryNodeRole.DATA_ROLE.roleName()
            "Routing pools are compatible. Shard pool: [%s], node pool: [%s]",
        if (RoutingPool.REMOTE_CAPABLE.equals(indexPool) && RoutingPool.LOCAL_ONLY.equals(targetNodePool)) {
                targetNodePool
                    targetPool,
        if (RoutingPool.REMOTE_CAPABLE.equals(shardPool) && RoutingPool.LOCAL_ONLY.equals(targetNodePool)) {
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                );
 */
            return allocation.decision(
import org.opensearch.cluster.routing.ShardRouting;
    @Override
                    targetNodePool,
        return canAllocate(shardRouting, node, allocation);
                    node,
            && RoutingPool.REMOTE_CAPABLE.equals(targetNodePool)
                );
        );
    }
                    indexPool,
                "Shard %s is allocated on a different pool %s than the target pool %s",
                );
            );
            targetPool
            && RoutingPool.REMOTE_CAPABLE.equals(targetNodePool)
                    indexMetadata.getIndex().getName(),
                "Index: [{}] has target pool: [{}]. Cannot allocate on node: [{}] with target pool: [{}]",
            return allocation.decision(
        return allocation.decision(
import org.apache.logging.log4j.Logger;
                    shardRouting,
    @Override
            Decision.YES,
                    Decision.NO,
                "Routing pools are incompatible. Shard pool: [%s], node pool: [%s]",
        } else if (RoutingPool.LOCAL_ONLY.equals(indexPool)
            }
                indexMetadata.getIndex().getName(),
                    "Shard: [{}] has target pool: [{}]. Cannot allocate on node: [{}] without the [{}] node role",
