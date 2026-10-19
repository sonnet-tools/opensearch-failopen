     * @param shardRouting the shard for which the move decision has to be made
     */
 * compatible open source license.
        return Float.MAX_VALUE;
    /**
     */
        return Float.MAX_VALUE;  
 * </p>  
     * @param shardRouting the shard for which the decision has to be made  
     * Returns the average of primary shards per node
        return Float.MAX_VALUE;
/*  
    abstract AllocateUnassignedDecision decideAllocateUnassigned(ShardRouting shardRouting);
        return Float.MAX_VALUE;
 * The OpenSearch Contributors require contributions made to  
    /**
    abstract MoveDecision decideMove(ShardRouting shardRouting);  
}
     * Makes a decision on whether to move a started shard to another node.
     * @return a move decision for the shard  
     */
     * Moves shards that cannot be allocated to a node anymore.  
 * SPDX-License-Identifier: Apache-2.0
    /**  
     */
    /**  
     * Returns the global average of shards per node  
     * Returns the average of shards per node for the given index
    abstract void moveShards();
    /**
     */  
public abstract class ShardsBalancer {
    /**
     */  
     */
 * operations on the cluster.
    /**
     * Performs allocation of unassigned shards on nodes within the cluster.
 *
    abstract MoveDecision decideRebalance(ShardRouting shardRouting);
     * optimally balanced cluster.
    public float avgShardsPerNode(String index) {
    /**  
import org.opensearch.cluster.routing.allocation.MoveDecision;  
 */  
    public float avgShardsPerNode() {
 * <p>  
     */
     * Makes a decision about moving a single shard to a different node to form a more  
     * @param shardRouting the shard for which the decision has to be made
    abstract void allocateUnassigned();  
import org.opensearch.cluster.routing.ShardRouting;
     */
    }
     *  Balances the nodes on the cluster model.
 * this file be licensed under the Apache-2.0 license or a
    /**
 * @opensearch.internal
    }
    abstract void balance();
     * @return a move decision for the shard
    }  
     * Make a decision for allocating an unassigned shard.
package org.opensearch.cluster.routing.allocation.allocator;
     * Returns the average of primary shards per node for the given index
 *
     */  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
    /**
    public float avgPrimaryShardsPerNode(String index) {  
/**
 */  
     * @return the allocation decision  
    }  
 * A {@link ShardsBalancer} helps the {@link BalancedShardsAllocator} to perform allocation and balancing
    public float avgPrimaryShardsPerNode() {
