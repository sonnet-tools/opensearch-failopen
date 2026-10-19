import org.opensearch.cluster.routing.RoutingNode;  
 * The OpenSearch Contributors require contributions made to  
    /**
     * Returns a {@link Decision} whether the given primary shard can be
            // On a THROTTLE/YES decision, we use the same decision instead of forcing allocation
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
    public Decision canRebalance(RoutingAllocation allocation) {  
                decision.label(),
    /**  
/**  
 *
    }
     * Note: all implementations that override this behavior should take into account  
        assert shardRouting.primary() : "must not call canForceAllocatePrimary on a non-primary shard " + shardRouting;  
     * {@link Decision}} whether or not to skip iterating over the remaining
            return allocation.decision(
     * the results of {@link #canAllocate(ShardRouting, RoutingNode, RoutingAllocation)}
    public Decision canMoveAnyShard(RoutingAllocation allocation) {  
     */
        return Decision.ALWAYS;  
    }
    /**
     * re-balanced to the given allocation. The default is
     */
            // On a NO decision, by default, we allow force allocating the primary.
 *  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
     * Returns a {@link Decision} whether the cluster can execute
            return decision;
     * {@link RoutingAllocation}. The default is {@link Decision#ALWAYS}.
     * Returns a {@link Decision} whether the given shard routing can be remain  
     */
     * Returns a {@link Decision} whether shards of the given index should be auto-expanded to this node at this state of the  
     */
 * compatible open source license.
     * {@link Decision#ALWAYS}.  
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
    /**  
}  
 * Unless required by applicable law or agreed to in writing,
    }
    }
        return Decision.ALWAYS;
                node.nodeId()
        return Decision.ALWAYS;
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.cluster.metadata.IndexMetadata;
/*  
     * Returns a {@link Decision} whether any shard in the cluster can be moved away from the current node  
     */  
    /**
 * SPDX-License-Identifier: Apache-2.0
     * <p>
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        return Decision.ALWAYS;
     * All implementations that override this behaviour must take a
     * Returns a {@link Decision} whether the given shard routing can be
    }
     */  
                shardRouting.shardId(),  
 */
     */
 *
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
 * GitHub history for details.
     * {@link RoutingAllocation}. The default is {@link Decision#ALWAYS}.  
    /**  
     * allocated on the given node. The default is {@link Decision#ALWAYS}.
    /**
    public Decision canMoveAway(ShardRouting shardRouting, RoutingAllocation allocation) {
    }  
        Decision decision = canAllocate(shardRouting, node, allocation);
     * forcibly allocated on the given node. This method should only be called  
        return Decision.ALWAYS;
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
     * Returns a {@link Decision} whether the given shard routing can be allocated at all at this state of the
     * on the given node. The default is {@link Decision#ALWAYS}.
     */
     * {@link RoutingAllocation}. The default is {@link Decision#ALWAYS}.
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
        if (decision.type() == Type.NO) {  
 * specific language governing permissions and limitations
        return Decision.ALWAYS;
public abstract class AllocationDecider {
     * before making a decision on force allocation, because force allocation should only
 * {@link AllocationDecider} is an abstract base class that allows to make
     * {@link RoutingAllocation}. The default is {@link Decision#ALWAYS}.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * under the License.  
    /**
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
     * be considered if all deciders return {@link Decision#NO}.  
        assert shardRouting.unassigned() : "must not call canForceAllocatePrimary on an assigned shard " + shardRouting;
import org.opensearch.cluster.routing.ShardRouting;
 * not use this file except in compliance with the License.
 * @opensearch.api
     */
     * {@link RoutingNode}} can be allocated The default is {@link Decision#ALWAYS}.  
     * Returns a {@link Decision} whether any shard on the given
     */
    }
        } else {  
     * Returns a {@link Decision} whether the given shard routing can be
        return Decision.ALWAYS;  
    /**
     * {@link Decision#ALWAYS}.
            );
        return Decision.ALWAYS;
 */  
     * Returns a {@link Decision} whether the given shard routing can be allocated at all at this state of the
 * dynamic cluster- or index-wide shard allocation decisions on a per-node
import org.opensearch.common.annotation.PublicApi;
    /**  
package org.opensearch.cluster.routing.allocation.decider;
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
     * deciders for this node.  
@PublicApi(since = "1.0.0")
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {  
 * You may obtain a copy of the License at  
 * basis.  
    }
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        return Decision.ALWAYS;
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    /**
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;  
     * for unassigned primary shards where the node has a shard copy on disk.
    }
 */  
     * Returns a {@link Decision} whether the given shard can be moved away from the current node
 * Modifications Copyright OpenSearch Contributors. See
     * re-balanced operations at all.  
                "primary shard [%s] allowed to force allocate on node [%s]",
    }  
 *
        return Decision.ALWAYS;  
        }  
     * {@link RoutingAllocation}. The default is {@link Decision#ALWAYS}.
                Decision.YES,  
