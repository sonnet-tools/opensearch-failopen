                routingChangesObserver.relocationStarted(startedShard, targetRelocatingShard);
        @Override
        public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
        }
        }  
     */
        }
 * Licensed to Elasticsearch under one or more contributor  
        @Override
     * Called when an initializing shard is started.
        @Override
        public void relocationCompleted(ShardRouting removedRelocationSource) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
            }
package org.opensearch.cluster.routing;
        @Override  
            }
    void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard);
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
        public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {  
        @Override
     */
        public DelegatingRoutingChangesObserver(RoutingChangesObserver... routingChangesObservers) {
            }  
        public void replicaPromoted(ShardRouting replicaShard) {  
        }
            }
        @Override
        }
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
        }
 * You may obtain a copy of the License at  
            }
        public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {  
 */
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
        @Override
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
                routingChangesObserver.shardStarted(initializingShard, startedShard);  
     * certain methods.
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
     */  
        }
     */
    void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo);
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {  
                routingChangesObserver.shardFailed(activeShard, unassignedInfo);  
        @Override  
                routingChangesObserver.unassignedInfoUpdated(unassignedShard, newUnassignedInfo);
    void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard);
/*  
        }
    void replicaPromoted(ShardRouting replicaShard);
        }  
     * Called on replica relocation target when replica relocation source fails. Promotes the replica relocation target to ordinary
        public void shardFailed(ShardRouting activeShard, UnassignedInfo unassignedInfo) {  
    }
                routingChangesObserver.shardInitialized(unassignedShard, initializedShard);
        }
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
    /**  
     * Called when unassigned shard is initialized. Does not include initializing relocation target shards.
 * specific language governing permissions and limitations
     */  
 */  
        public void relocationCompleted(ShardRouting removedRelocationSource) {
                routingChangesObserver.relocationCompleted(removedRelocationSource);
     * Called when an unassigned shard's unassigned information was updated
     */  
 * ownership. Elasticsearch licenses this file to you under  
                routingChangesObserver.initializedReplicaReinitialized(oldReplica, reinitializedReplica);
 */
        private final RoutingChangesObserver[] routingChangesObservers;
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {  
}
    }
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.routingChangesObservers = routingChangesObservers;
        @Override
 * Modifications Copyright OpenSearch Contributors. See
    /**
     * reinitializes all currently initializing replicas as their recovery source node changes
    void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica);
     * Abstract implementation of {@link RoutingChangesObserver} that does not take any action. Useful for subclasses that only override
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
     * Called when started replica is promoted to primary.
    /**  
 *
    /**  
     * Called when a shard is failed or cancelled.
 *
     * Called on relocation source when relocation completes after relocation target is started.  
 * The OpenSearch Contributors require contributions made to  
    class DelegatingRoutingChangesObserver implements RoutingChangesObserver {  
    /**
     */
        public void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource) {
import org.opensearch.common.annotation.PublicApi;
        public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {  
        public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {
                routingChangesObserver.replicaPromoted(replicaShard);  
     * Called when relocation of a started shard is initiated.  
            }
 *
     * Observer of routing changes.
        @Override
public interface RoutingChangesObserver {  
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {  
        public void shardFailed(ShardRouting activeShard, UnassignedInfo unassignedInfo) {
        public void replicaPromoted(ShardRouting replicaShard) {
        @Override
 * Records changes made to {@link RoutingNodes} during an allocation round.
        }  
 * this work for additional information regarding copyright
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    /**
 *  
        @Override
            }  
    /**  
    /**
        public void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource) {  
     * Called when an initializing replica is reinitialized. This happens when a primary relocation completes, which
        }  
    class AbstractRoutingChangesObserver implements RoutingChangesObserver {
 * software distributed under the License is distributed on an
    /**
     * @opensearch.internal
            }
 */  
    /**
        }
                routingChangesObserver.relocationSourceRemoved(removedReplicaRelocationSource);
     */  
     */
     *  
        }
        @Override  
    /**
            }  
        public void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica) {
 * this file be licensed under the Apache-2.0 license or a
    void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo);  
@PublicApi(since = "1.0.0")
 * compatible open source license.
/*  
        public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
        @Override
    void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource);
     */  
    void relocationCompleted(ShardRouting removedRelocationSource);
        }  
        }
        }
        }  
 * KIND, either express or implied.  See the License for the
        @Override  
/*
        public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {
        public void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica) {
        }  
     * initializing shard.  
        @Override  
        @Override  
        public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {
     */
/**  
 * @opensearch.api  
        @Override
    void shardStarted(ShardRouting initializingShard, ShardRouting startedShard);  
