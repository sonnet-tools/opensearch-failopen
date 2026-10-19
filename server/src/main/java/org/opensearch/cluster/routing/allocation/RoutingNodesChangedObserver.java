    @Override  
import org.opensearch.cluster.routing.RoutingChangesObserver;
    private boolean changed;  
public class RoutingNodesChangedObserver implements RoutingChangesObserver {
        assert failedShard.assignedToNode() : "expected assigned shard " + failedShard;
        setChanged();  
 */  
 * SPDX-License-Identifier: Apache-2.0
 *  
    }  
        assert oldReplica.initializing() && oldReplica.primary() == false : "expected initializing replica shard " + oldReplica;  
 *
        assert initializedShard.initializing() : "expected initializing shard " + initializedShard;  
            : "expected allocation id to change for reinitialized replica shard (old: "
 * specific language governing permissions and limitations
 *
 * Unless required by applicable law or agreed to in writing,
        return changed;  
/*  
 * this work for additional information regarding copyright
        assert removedRelocationSource.relocating() : "expected relocating shard " + removedRelocationSource;
    public void replicaPromoted(ShardRouting replicaShard) {
        setChanged();  
import org.opensearch.cluster.routing.UnassignedInfo;
        assert initializingShard.initializing() : "expected initializing shard " + initializingShard;  
 * The OpenSearch Contributors require contributions made to  
     * Returns whether changes were made  
/**  
    }
    public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
import org.opensearch.cluster.routing.RoutingNodes;
    /**
    }
        assert startedShard.started() : "expected started shard " + startedShard;
    }
        assert reinitializedReplica.initializing() && reinitializedReplica.primary() == false : "expected reinitialized replica shard "
 * not use this file except in compliance with the License.
 */
 * You may obtain a copy of the License at  
                + oldReplica
    @Override  
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
        assert unassignedShard.unassigned() : "expected unassigned shard " + unassignedShard;
        assert unassignedShard.unassigned() : "expected unassigned shard " + unassignedShard;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
    @Override  
    /**  
            + reinitializedReplica;
        setChanged();  
        assert oldReplica.allocationId().getId().equals(reinitializedReplica.allocationId().getId()) == false  
/*  
    @Override
 * under the License.  
import org.opensearch.cluster.routing.ShardRouting;  
        setChanged();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
 */
     */
 * Records if changes were made to {@link RoutingNodes} during an allocation round.
 * Modifications Copyright OpenSearch Contributors. See
    public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {  
    }
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    @Override
package org.opensearch.cluster.routing.allocation;
    private void setChanged() {  
     * Marks the allocation as changed.
 * license agreements. See the NOTICE file distributed with
        setChanged();
    @Override  
    @Override
        changed = true;
    public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {
                + ")";
        assert replicaShard.started() && replicaShard.primary() == false : "expected started replica shard " + replicaShard;  
    public void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica) {
/*
 * software distributed under the License is distributed on an
     */
                + " new: "  
    }
 * GitHub history for details.
    @Override
        setChanged();
    public void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo) {
    }
    public void relocationCompleted(ShardRouting removedRelocationSource) {
        setChanged();  
        assert targetRelocatingShard.isRelocationTarget() : "expected relocation target shard " + targetRelocatingShard;
    }
 * compatible open source license.
                + reinitializedReplica
 * this file be licensed under the Apache-2.0 license or a
        assert startedShard.started() : "expected started shard " + startedShard;
    public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
        assert removedReplicaRelocationSource.primary() == false && removedReplicaRelocationSource.isRelocationTarget()
        setChanged();  
    public boolean isChanged() {
}  
    public void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource) {
        setChanged();
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
            : "expected replica relocation target shard " + removedReplicaRelocationSource;  
 * @opensearch.internal  
