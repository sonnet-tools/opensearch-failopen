        if ((node.isSearchNode() && isSearchReplica) || (node.isSearchNode() == false && isSearchReplica == false)) {
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    }
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        }
    @Override  
import org.opensearch.cluster.node.DiscoveryNode;
 * compatible open source license.
 * A search replica can be allocated to only nodes with a search role
 * SPDX-License-Identifier: Apache-2.0
public class SearchReplicaAllocationDecider extends AllocationDecider {
                NAME,
                node.isSearchNode(),
                Decision.NO,  
 * other shard types will not be allocated to these nodes.
 *
                Decision.YES,  
import org.opensearch.cluster.routing.ShardRouting;  
 * @opensearch.internal  
                "node and shard are compatible. node: [%s], is search node: [%s], shard: [%s]",
                shardRouting.shortSummary()
import org.opensearch.cluster.routing.RoutingNode;
package org.opensearch.cluster.routing.allocation.decider;
/*  
 */
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
                shardRouting.shortSummary()
        return canAllocate(shardRouting, node.node(), allocation);
/**  
}  
    private Decision canAllocate(ShardRouting shardRouting, DiscoveryNode node, RoutingAllocation allocation) {
 */  
        boolean isSearchReplica = shardRouting.isSearchOnly();
                node.isSearchNode(),
    public static final String NAME = "search_replica_allocation";
                "node and shard are not compatible. node: [%s], is search node: [%s], shard: [%s]",
            return allocation.decision(
                node.getId(),  
    @Override
            return allocation.decision(
                NAME,
        } else {
        return canAllocate(shardRouting, node.node(), allocation);
                node.getId(),  
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
            );  
            );  
