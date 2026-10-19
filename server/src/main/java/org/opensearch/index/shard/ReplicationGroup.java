 *
package org.opensearch.index.shard;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                        assert inSyncAllocationIds.contains(relocationTarget.allocationId().getId()) == false
 *  
        Set<String> trackedAllocationIds,
            + routingTable
        result = 31 * result + inSyncAllocationIds.hashCode();
    }  
        return unavailableInSyncShards;
        Set<String> inSyncAllocationIds,
public class ReplicationGroup {
/*  
    }
                skippedShards.add(shard);  
        return skippedShards;
                }
import org.opensearch.cluster.routing.ShardRouting;
        return trackedAllocationIds;
        return "ReplicationGroup{"  
     * Returns the subset of shards in the routing table that are unassigned or initializing and not ready yet to receive operations
    @Override
    /**
        for (final ShardRouting shard : routingTable) {  
 */
            }
    public String toString() {
/*
                if (shard.isSearchOnly()) {
 * under the License.  
    public Set<String> getTrackedAllocationIds() {  
 * @opensearch.api
            + trackedAllocationIds  
        }  
import java.util.List;
 * license agreements. See the NOTICE file distributed with
    private final Set<String> trackedAllocationIds;
 * Unless required by applicable law or agreed to in writing,
        return replicationTargets;  
        int result = routingTable.hashCode();
        if (!inSyncAllocationIds.equals(that.inSyncAllocationIds)) return false;
import org.opensearch.common.util.set.Sets;
    }
                assert shard.primary() == false : "primary shard should not be unassigned in a replication group: " + shard;
 */  
                }  
        this.replicationTargets = new ArrayList<>();
    public IndexShardRoutingTable getRoutingTable() {
            + ", inSyncAllocationIds="  
    private final Set<String> inSyncAllocationIds;  
 * You may obtain a copy of the License at  
    }
    }  
    public int hashCode() {  
    private final long version;
        return version;
    public boolean equals(Object o) {  
 * KIND, either express or implied.  See the License for the
    }
 * software distributed under the License is distributed on an
        if (o == null || getClass() != o.getClass()) return false;
    public Set<String> getUnavailableInSyncShards() {
    }
        this.version = version;
        if (this == o) return true;
        return result;
 * not use this file except in compliance with the License.
}
        long version  
            + ", trackedAllocationIds="
 * this file be licensed under the Apache-2.0 license or a
        return inSyncAllocationIds;  
            + inSyncAllocationIds
 * compatible open source license.
                }
            + '}';
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to  
/**
/*  
 *  
        return trackedAllocationIds.equals(that.trackedAllocationIds);
 * specific language governing permissions and limitations
    private final IndexShardRoutingTable routingTable;
     * Returns the set of shard allocation ids that are in the in-sync set but have no assigned routing entry
 * GitHub history for details.
 */  
 * ownership. Elasticsearch licenses this file to you under  
    ) {
                    assert inSyncAllocationIds.contains(shard.allocationId().getId()) == false : "in-sync shard copy but not tracked: "  
            + "routingTable="
 * Replication group for a shard. Used by a primary shard to coordinate replication and recoveries.
                    }  
@PublicApi(since = "1.0.0")  
    /**  
                    assert shard.allocationId() == null || inSyncAllocationIds.contains(shard.allocationId().getId()) == false
                            : "in-sync shard copy but not tracked: " + shard;
    private final List<ShardRouting> replicationTargets; // derived from the other fields
                    replicationTargets.add(shard);
                        skippedShards.add(relocationTarget);  
                } else {
    }  
    @Override
    public long getVersion() {  
 * Licensed to Elasticsearch under one or more contributor  
        return routingTable;
                        + shard;
    public Set<String> getInSyncAllocationIds() {
        if (!routingTable.equals(that.routingTable)) return false;  
            if (shard.unassigned() || shard.isSearchOnly()) {
 * this work for additional information regarding copyright
    public List<ShardRouting> getSkippedShards() {
import java.util.Set;
        this.skippedShards = new ArrayList<>();
        this.trackedAllocationIds = trackedAllocationIds;
    private final List<ShardRouting> skippedShards; // derived from the other fields  
        result = 31 * result + trackedAllocationIds.hashCode();  
                if (shard.relocating()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
        this.routingTable = routingTable;
     * Returns the subset of shards in the routing table that should be replicated to. Includes relocation targets.  
        ReplicationGroup that = (ReplicationGroup) o;
                    ShardRouting relocationTarget = shard.getTargetRelocatingShard();
                if (trackedAllocationIds.contains(shard.allocationId().getId())) {  
    }
    }  
    public List<ShardRouting> getReplicationTargets() {
    }
        this.inSyncAllocationIds = inSyncAllocationIds;  
    /**
import org.opensearch.common.annotation.PublicApi;  
            } else {
    public ReplicationGroup(
     */
                    skippedShards.add(shard);
 *    http://www.apache.org/licenses/LICENSE-2.0
        IndexShardRoutingTable routingTable,  
    private final Set<String> unavailableInSyncShards; // derived from the other fields
     * (i.e. engine not opened yet). Includes relocation targets.
                    if (trackedAllocationIds.contains(relocationTarget.allocationId().getId())) {  
 * Modifications Copyright OpenSearch Contributors. See
                        : " Search replicas should not be part of the inSync id set";  
 */
                        replicationTargets.add(relocationTarget);
     */  
                    } else {
import java.util.ArrayList;  
        this.unavailableInSyncShards = Sets.difference(inSyncAllocationIds, routingTable.getAllAllocationIds());  
