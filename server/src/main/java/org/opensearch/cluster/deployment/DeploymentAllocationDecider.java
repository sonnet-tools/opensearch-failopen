    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
package org.opensearch.cluster.deployment;
 *  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
            return Decision.ALWAYS;
            return Decision.ALWAYS;
/*  
 *
 * SPDX-License-Identifier: Apache-2.0
public class DeploymentAllocationDecider extends AllocationDecider {  
 */  
import org.opensearch.cluster.routing.ShardRouting;
/**
import org.opensearch.cluster.routing.RoutingNode;
        return canAllocate(shardRouting, node, allocation);  
    }
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * Prevents primary shards from being allocated to or remaining on nodes that are in a deployment state.
 * this file be licensed under the Apache-2.0 license or a
 */
        DeploymentState deploymentState = DeploymentStateService.getNodeDeploymentState(allocation.metadata(), node.node());  
        }
    @Override
}
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        if (shardRouting.primary() == false) {  
 * compatible open source license.
        return allocation.decision(Decision.NO, NAME, "cannot allocate primary shard to node with deployment state [%s]", deploymentState);
    @Override
        if (deploymentState == null) {
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
        }  
    }
import org.opensearch.cluster.routing.allocation.decider.Decision;
    public static final String NAME = "deployment";
