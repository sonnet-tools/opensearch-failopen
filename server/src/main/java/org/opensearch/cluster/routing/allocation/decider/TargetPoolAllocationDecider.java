 *
                return allocation.decision(  
                    "Routing pools are incompatible. Index pool: [%s], node pool: [%s] without [%s] role",  
            }
            logger.debug(  
 */
                    shardPool,
            targetPool
                    indexPool,
package org.opensearch.cluster.routing.allocation.decider;
                NAME,  
 *
        return canAllocateInTargetPool(indexMetadata, node.node(), allocation);
            && !node.node().getRoles().contains(DiscoveryNodeRole.DATA_ROLE)) {
                    targetNodePool,
            targetNodePool
                "Routing pools are incompatible. Shard pool: [%s], node pool: [%s]",
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
                shardRouting,
        logger.debug("Evaluating force allocation for primary shard.");
public class TargetPoolAllocationDecider extends AllocationDecider {
            }
                    DiscoveryNodeRole.DATA_ROLE.roleName()  
        RoutingPool targetNodePool = RoutingPool.getNodePool(node);
import org.opensearch.cluster.routing.RoutingPool;
                shardPool,  
                    NAME,
                    Decision.NO,
            && targetPool != currentNodePool  
        RoutingPool shardPool = RoutingPool.getShardPool(shardRouting, allocation);  
                "Shard %s is allocated on a different pool %s than the target pool %s",  
            shardPool,
                );
                    indexMetadata.getIndex().getName(),
                    "Routing pools are incompatible. Shard pool: [%s], node pool: [%s] without [%s] role",  
                    DiscoveryNodeRole.DATA_ROLE.roleName()  
            logger.debug(  
                    NAME,
    }  
                return allocation.decision(  
import org.apache.logging.log4j.Logger;
            && !node.node().getRoles().contains(DiscoveryNodeRole.DATA_ROLE)) {
                    "Index: [{}] has target pool: [{}]. Cannot allocate on node: [{}] without the [{}] node role",  
            return allocation.decision(
                currentNodePool.name(),
                    node,  
            && RoutingPool.REMOTE_CAPABLE.equals(targetNodePool)  
                    DiscoveryNodeRole.DATA_ROLE.roleName()
            return allocation.decision(
                logger.debug(
            );  
                    shardPool,
        } else if (RoutingPool.LOCAL_ONLY.equals(targetPool)
    private static final Logger logger = LogManager.getLogger(TargetPoolAllocationDecider.class);  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
                    targetPool,
    }
            "Routing pools are compatible. Shard pool: [%s], node pool: [%s]",  
                    shardRouting,
            logger.debug(
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
        return allocation.decision(  
        return allocation.decision(  
                logger.debug(
    private Decision canAllocateInTargetPool(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
                    "Shard: [{}] has target pool: [{}]. Cannot allocate on node: [{}] without the [{}] node role",  
            "Routing pools are compatible. Shard pool: [%s], node pool: [%s]",  
    }
                    shardRouting,
import org.opensearch.cluster.node.DiscoveryNode;
                    indexPool,
            );
            }
                shardRouting.shortSummary(),
    }
                    targetNodePool,
import org.opensearch.cluster.routing.RoutingNode;  
                "Index: [{}] has target pool: [{}]. Cannot allocate on node: [{}] with target pool: [{}]",
    @Override
    }  
 */  
                    NAME,
}  
        logger.debug("Evaluating node: {} for autoExpandReplica eligibility of index: {}", node, indexMetadata.getIndex());
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
                    node.node(),  
                targetPool  
                "Shard: [{}] has target pool: [{}]. Cannot allocate on node: [{}] with target pool: [{}]",
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    node.node(),  
                node.node()
        RoutingPool indexPool = RoutingPool.getIndexPool(indexMetadata);  
        if (RoutingPool.REMOTE_CAPABLE.equals(shardPool) && RoutingPool.LOCAL_ONLY.equals(targetNodePool)) {
                    DiscoveryNodeRole.DATA_ROLE.roleName()
                "Routing pools are incompatible. Index pool: [%s], node pool: [%s]",
        );  
        } else if (RoutingPool.LOCAL_ONLY.equals(indexPool)
                targetNodePool  
                indexPool,
        RoutingPool targetPool = RoutingPool.getShardPool(shardRouting, allocation);
        );  
                    currentNodePool,
                node,
import org.opensearch.cluster.routing.ShardRouting;
                targetNodePool
/*  
                );
                "Shard: [{}] has current pool: [{}], target pool: [{}]. Cannot remain on node: [{}]",  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
                currentNodePool,
                NAME,
                );
        RoutingPool targetNodePool = RoutingPool.getNodePool(node);
            currentNodePool,
 * appropriate capabilities. The node pools with respective capabilities are defined within {@link RoutingPool}.
                );
        return canAllocate(shardRouting, node, allocation);
            Decision.YES,
                );
                    Decision.NO,
                    DiscoveryNodeRole.DATA_ROLE.roleName()
                targetNodePool  
 * The OpenSearch Contributors require contributions made to  
                    "Shard: [{}] has target pool: [{}]. Cannot remain on node: [{}] without the [{}] node role",  
/**
 * SPDX-License-Identifier: Apache-2.0
            && !node.getRoles().contains(DiscoveryNodeRole.DATA_ROLE)) {
        } else if (RoutingPool.LOCAL_ONLY.equals(shardPool)
 * @opensearch.internal  
                );
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {  
    @Override  
    }  
    @Override
                shardPool,
            NAME,
            Decision.YES,
import org.apache.logging.log4j.LogManager;
            );  
            );
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                return allocation.decision(  
            indexPool,
                indexPool,  
                shardRouting.shortSummary(),
        );  
                NAME,  
    @Override
        if (RoutingPool.REMOTE_CAPABLE.equals(targetPool) && targetPool != currentNodePool) {
            Decision.YES,
                Decision.NO,
        if (RoutingPool.REMOTE_CAPABLE.equals(indexPool) && RoutingPool.LOCAL_ONLY.equals(targetNodePool)) {
            );
                node.node(),
                Decision.NO,
                    "Routing pools are incompatible. Shard pool: [%s], node pool: [%s] without [%s] role",  
            return allocation.decision(  
        return canAllocateInTargetPool(indexMetadata, node, allocation);
        RoutingPool currentNodePool = RoutingPool.getNodePool(allocation.routingNodes().node(shardRouting.currentNodeId()));
            NAME,
 * {@link TargetPoolAllocationDecider} ensures that the different shard types are assigned to the nodes with  
                targetPool.name(),  
                    targetPool,
    public static final String NAME = "target_pool";
                    Decision.NO,
                Decision.NO,
        return allocation.decision(  
            "Routing pools are compatible. Index pool: [%s], node pool: [%s]",  
            && RoutingPool.REMOTE_CAPABLE.equals(targetNodePool)  
            NAME,
                indexMetadata.getIndex().getName(),
import org.opensearch.cluster.metadata.IndexMetadata;  
                logger.debug(
            );
            targetNodePool
                targetNodePool
                    DiscoveryNodeRole.DATA_ROLE.roleName()  
