 */
 * Only allow rebalancing when all shards are active within the shard replication group.
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * specific language governing permissions and limitations
 */  
 * license agreements. See the NOTICE file distributed with
 *  
public class RebalanceOnlyWhenActiveAllocationDecider extends AllocationDecider {  
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
import org.opensearch.cluster.routing.ShardRouting;
 * Modifications Copyright OpenSearch Contributors. See
        return allocation.decision(Decision.YES, NAME, "rebalancing is allowed as all replicas are active in the cluster");  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
/*  
    public static final String NAME = "rebalance_only_when_active";
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 *
 */  
 * GitHub history for details.
 */
 * KIND, either express or implied.  See the License for the
 * under the License.  
        if (!allocation.routingNodes().allReplicasActive(shardRouting.shardId(), allocation.metadata())) {  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
/*
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            return allocation.decision(Decision.NO, NAME, "rebalancing is not allowed until all replicas in the cluster are active");
    }
 *  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
/**
package org.opensearch.cluster.routing.allocation.decider;
 * the Apache License, Version 2.0 (the "License"); you may
}
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
