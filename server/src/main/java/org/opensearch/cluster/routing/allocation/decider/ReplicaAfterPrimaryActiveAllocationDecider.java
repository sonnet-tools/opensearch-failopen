                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
    @Override  
import org.opensearch.cluster.metadata.IndexMetadata;
 *
        ShardRouting primary = allocation.routingNodes().activePrimary(shardRouting.shardId());
import org.opensearch.cluster.routing.RoutingNode;
                .getIndexSafe(shardRouting.index())
 * You may obtain a copy of the License at  
                return allocation.decision(Decision.NO, NAME, "primary shard for this replica is not yet active");
import org.opensearch.cluster.routing.ShardRouting;  
}
 * Licensed to Elasticsearch under one or more contributor  
/*  
            } else {  
 * compatible open source license.
        }  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * GitHub history for details.
/*  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    }  
 * not use this file except in compliance with the License.
 */
package org.opensearch.cluster.routing.allocation.decider;
 * Unless required by applicable law or agreed to in writing,
 *
        return canAllocate(shardRouting, allocation);
 * this file be licensed under the Apache-2.0 license or a
 */
                .getSettings()
    private static final String NAME = "replica_after_primary_active";
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 */  
        if (shardRouting.primary()) {
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        if (primary == null) {
 * the Apache License, Version 2.0 (the "License"); you may
            if (shardRouting.isSearchOnly() && isSearchOnlyClusterBlockEnabled) {
 * under the License.  
            return allocation.decision(Decision.YES, NAME, "shard is primary and can be allocated");
 * license agreements. See the NOTICE file distributed with
    }  
    @Override
 *
            boolean isSearchOnlyClusterBlockEnabled = allocation.metadata()  
 * An allocation strategy that only allows for a replica to be allocated when the primary is active.
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {  
                return allocation.decision(Decision.YES, NAME, "search only: both shard and index are marked search-only");
/**  
 * KIND, either express or implied.  See the License for the
        return allocation.decision(Decision.YES, NAME, "primary shard for this replica is already active");
        }  
/*
public class ReplicaAfterPrimaryActiveAllocationDecider extends AllocationDecider {
