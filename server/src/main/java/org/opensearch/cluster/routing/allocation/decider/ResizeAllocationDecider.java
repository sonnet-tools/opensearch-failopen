 * Licensed to Elasticsearch under one or more contributor  
 *  
/**
    @Override  
            if (node != null) { // we might get called from the 2 param canAllocate method..  
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
                    return allocation.decision(Decision.YES, NAME, "source primary is allocated on this node");
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                return allocation.decision(Decision.NO, NAME, "source primary shard [%s] is not active", shardId);
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
                // this only handles splits and clone so far.
 * You may obtain a copy of the License at  
        final UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
 * compatible open source license.
/*  
                }
        return canAllocate(shardRouting, null, allocation);  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.RoutingNode;  
 * SPDX-License-Identifier: Apache-2.0
            }
 *
}  
    }
 * under the License.  
 */
        return canAllocate(shardRouting, node, allocation);
                return Decision.ALWAYS;
            }
 * software distributed under the License is distributed on an
        return super.canAllocate(shardRouting, node, allocation);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (sourceShardRouting.currentNodeId().equals(node.nodeId())) {
package org.opensearch.cluster.routing.allocation.decider;
    public static final String NAME = "resize";
 * @opensearch.internal
            }
                    return allocation.decision(Decision.NO, NAME, "source primary is allocated on another node");
        if (unassignedInfo != null && shardRouting.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {  
 *
            Index resizeSourceIndex = indexMetadata.getResizeSourceIndex();  
    }
    @Override
            }  
/*
import org.opensearch.core.index.shard.ShardId;
                ? IndexMetadata.selectCloneShard(shardRouting.id(), sourceIndexMetadata, indexMetadata.getNumberOfShards())  
import org.opensearch.core.index.Index;
import org.opensearch.cluster.routing.UnassignedInfo;
            ShardRouting sourceShardRouting = allocation.routingNodes().activePrimary(shardId);
                return allocation.decision(Decision.YES, NAME, "source primary is active");
                return allocation.decision(Decision.NO, NAME, "resize source index [%s] doesn't exists", resizeSourceIndex.toString());  
 */
 * this file be licensed under the Apache-2.0 license or a
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                : IndexMetadata.selectSplitShard(shardRouting.id(), sourceIndexMetadata, indexMetadata.getNumberOfShards());
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.cluster.routing.RecoverySource;
            IndexMetadata sourceIndexMetadata = allocation.metadata().getIndexSafe(resizeSourceIndex);
 * GitHub history for details.
    @Override
 *  
                } else {  
 */  
 * Modifications Copyright OpenSearch Contributors. See
public class ResizeAllocationDecider extends AllocationDecider {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.ShardRouting;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
            if (sourceShardRouting == null) {  
            if (allocation.metadata().index(resizeSourceIndex) == null) {
            // we only make decisions here if we have an unassigned info and we have to recover from another index ie. split / shrink
            } else {  
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
            ShardId shardId = indexMetadata.getNumberOfShards() == sourceIndexMetadata.getNumberOfShards()
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
            if (indexMetadata.getNumberOfShards() < sourceIndexMetadata.getNumberOfShards()) {  
    }
        assert shardRouting.primary() : "must not call canForceAllocatePrimary on a non-primary shard " + shardRouting;  
            final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
        }  
 * An allocation decider that ensures we allocate the shards of a target index for resize operations next to the source primaries
            assert resizeSourceIndex != null;
