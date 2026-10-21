            }
        @Override
    /**
     * reinitializes all currently initializing replicas as their recovery source node changes
     * Called when an initializing replica is reinitialized. This happens when a primary relocation completes, which
            }
        public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
    void shardStarted(ShardRouting initializingShard, ShardRouting startedShard);
        public void replicaPromoted(ShardRouting replicaShard) {
    }
    /**
     * @opensearch.internal
        }
 *
        }
        public void replicaPromoted(ShardRouting replicaShard) {
/*
 */
        }
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
    void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard);
     */
        public void shardFailed(ShardRouting activeShard, UnassignedInfo unassignedInfo) {
     */
            }
        }
        @Override
        @Override
    void replicaPromoted(ShardRouting replicaShard);
    void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard);
    /**
package org.opensearch.cluster.routing;
        public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
 * this file be licensed under the Apache-2.0 license or a
    class DelegatingRoutingChangesObserver implements RoutingChangesObserver {
 * ownership. Elasticsearch licenses this file to you under
        public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
/*
        }
        @Override
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
                routingChangesObserver.shardInitialized(unassignedShard, initializedShard);
        public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
        @Override
    /**
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
        public void shardFailed(ShardRouting activeShard, UnassignedInfo unassignedInfo) {
                routingChangesObserver.relocationStarted(startedShard, targetRelocatingShard);
 * software distributed under the License is distributed on an
    /**
     */
 *
     */
            }
 * specific language governing permissions and limitations
     * Called when unassigned shard is initialized. Does not include initializing relocation target shards.
        public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {
 * The OpenSearch Contributors require contributions made to
                routingChangesObserver.shardFailed(activeShard, unassignedInfo);
     * Called when an unassigned shard's unassigned information was updated
     */
     * Abstract implementation of {@link RoutingChangesObserver} that does not take any action. Useful for subclasses that only override
 */
     *
     */
        }
public interface RoutingChangesObserver {
 * Records changes made to {@link RoutingNodes} during an allocation round.
 *     http://www.apache.org/licenses/LICENSE-2.0
        public void relocationCompleted(ShardRouting removedRelocationSource) {
        }
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
        }
     * certain methods.
                routingChangesObserver.unassignedInfoUpdated(unassignedShard, newUnassignedInfo);
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
        public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
        private final RoutingChangesObserver[] routingChangesObservers;
        @Override
            }
        @Override
            this.routingChangesObservers = routingChangesObservers;
     * initializing shard.
        }
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
     * Called when a shard is failed or cancelled.
@PublicApi(since = "1.0.0")
 */
     * Called when started replica is promoted to primary.
                routingChangesObserver.relocationSourceRemoved(removedReplicaRelocationSource);
     */
     * Called when an initializing shard is started.
import org.opensearch.common.annotation.PublicApi;
    void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
     * Called on replica relocation target when replica relocation source fails. Promotes the replica relocation target to ordinary
        @Override
 *
    }
}
        public void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource) {
                routingChangesObserver.shardStarted(initializingShard, startedShard);
     * Observer of routing changes.
        @Override
                routingChangesObserver.replicaPromoted(replicaShard);
    /**
    void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo);
            }
        }
 * this work for additional information regarding copyright
    /**
/**
 */
        @Override
 * Unless required by applicable law or agreed to in writing,
        }
        public void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica) {
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
 * under the License.
        @Override
 * Licensed to Elasticsearch under one or more contributor
        public void initializedReplicaReinitialized(ShardRouting oldReplica, ShardRouting reinitializedReplica) {
 * the Apache License, Version 2.0 (the "License"); you may
     */
        public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
        public void relocationCompleted(ShardRouting removedRelocationSource) {
    /**
        public DelegatingRoutingChangesObserver(RoutingChangesObserver... routingChangesObservers) {
 *
        }
 * @opensearch.api
    /**
        @Override
    /**
        }
/*
     * Called when relocation of a started shard is initiated.
        }
        }
            }
        }
        }
        public void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource) {
        @Override
    void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo);
     */
        @Override
        public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {
                routingChangesObserver.initializedReplicaReinitialized(oldReplica, reinitializedReplica);
     */
            for (RoutingChangesObserver routingChangesObserver : routingChangesObservers) {
        @Override
                routingChangesObserver.relocationCompleted(removedRelocationSource);
 * GitHub history for details.
     */
 * compatible open source license.
    /**
        @Override
     * Called on relocation source when relocation completes after relocation target is started.
    void relocationSourceRemoved(ShardRouting removedReplicaRelocationSource);
            }
        @Override
    void relocationCompleted(ShardRouting removedRelocationSource);
 * SPDX-License-Identifier: Apache-2.0
    class AbstractRoutingChangesObserver implements RoutingChangesObserver {
