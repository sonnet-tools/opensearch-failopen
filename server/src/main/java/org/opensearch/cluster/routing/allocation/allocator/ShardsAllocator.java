 * Licensed to Elasticsearch under one or more contributor  
    ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation);  
package org.opensearch.cluster.routing.allocation.allocator;
 * A {@link ShardsAllocator} is the main entry point for shard allocation on nodes in the cluster.
 * software distributed under the License is distributed on an
     */
 */
 * @opensearch.internal  
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;  
}  
     * to the cluster.
     * state, then the {@link MoveDecision} will be non-null.
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    /**
import org.opensearch.cluster.routing.allocation.MoveDecision;
     */
/*
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.cluster.routing.RerouteService;
 * this file be licensed under the Apache-2.0 license or a
     * - assign unassigned shards  
 * The allocator makes basic decision where a shard instance will be allocated, if already allocated instances
 * license agreements. See the NOTICE file distributed with
/*  
 * Unless required by applicable law or agreed to in writing,
 * </p>
import org.opensearch.cluster.routing.ShardRouting;
     * the cluster explain API, then this method should throw a {@code UnsupportedOperationException}.
     * Allocates shards to nodes in the cluster. An implementation of this method should:
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 */  
 * compatible open source license.
    void allocate(RoutingAllocation allocation);  
 * specific language governing permissions and limitations
 * GitHub history for details.
/*  
 * Modifications Copyright OpenSearch Contributors. See
     * This method is primarily used by the cluster allocation explain API to provide detailed explanations
 * this work for additional information regarding copyright
     * @param allocation current node allocation
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;  
     * then the {@link AllocateUnassignedDecision} will be non-null.  If the shard is not in the unassigned
 * KIND, either express or implied.  See the License for the
     * - relocate shards to find a good shard balance in the cluster
     * - relocate shards that cannot stay on a node anymore
 * under the License.  
 *
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * <p>  
 */
    default void setRerouteService(RerouteService rerouteService) {}
     * <p>
 * ownership. Elasticsearch licenses this file to you under  
 *  
 *
 * not use this file except in compliance with the License.
     * for the allocation of a single shard.  Implementations of the {@link #allocate(RoutingAllocation)} method
     * Returns the decision for where a shard should reside in the cluster.  If the shard is unassigned,  
public interface ShardsAllocator {
    /**
     * <p>  
     * may use the results of this method implementation to decide on allocating shards in the routing table  
 * need to relocate to other nodes due to node failures or due to rebalancing decisions.  
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
     * If an implementation of this interface does not support explaining decisions for a single shard through  
