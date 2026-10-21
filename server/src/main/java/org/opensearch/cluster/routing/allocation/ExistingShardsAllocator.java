 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
         * @param  recoverySource the new recovery source to use
     * to prepare for replica allocation.
    /**
 *
 * KIND, either express or implied.  See the License for the
 * Searches for, and allocates, shards for which there is an existing on-disk copy somewhere in the cluster. The default implementation is
     * Called when this node becomes the elected cluster-manager and when it stops being the elected cluster-manager, so that implementations can clean up any
     * Returns an explanation for a single unassigned shard.
/*
 * compatible open source license.
     */
 * under the License.
import org.opensearch.cluster.routing.RecoverySource;
    /**
package org.opensearch.cluster.routing.allocation;
/*
        List<Runnable> runnables = new ArrayList<>();
     */
public interface ExistingShardsAllocator {
         * Removes and ignores the unassigned shard (will be ignored for this run, but
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.UnassignedInfo;
 *
 * {@link GatewayAllocator} and {@link ShardsBatchGatewayAllocator}, but plugins can supply their own implementations too.
        /**
    /**
         * @return the shard with unassigned info updated
            }
 * You may obtain a copy of the License at
         *
         * @param attempt the result of the allocation attempt
    int getNumberOfInFlightFetches();
    interface UnassignedAllocationHandler {
 * The OpenSearch Contributors require contributions made to
     * those shards.
 * this file be licensed under the Apache-2.0 license or a
        ShardRouting updateUnassigned(UnassignedInfo unassignedInfo, RecoverySource recoverySource, RoutingChangesObserver changes);
 * Licensed to Elasticsearch under one or more contributor
            if (shardRouting.primary() == primary) {
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
 */
     * Allocate any unassigned shards in the given {@link RoutingAllocation} for which this {@link ExistingShardsAllocator} is responsible.
 * the Apache License, Version 2.0 (the "License"); you may
        return () -> runnables.forEach(Runnable::run);
import org.opensearch.cluster.routing.ShardRouting;
    /**
            RoutingChangesObserver routingChangesObserver
     * This will allow sending all Unassigned Shards to the ExistingShard Allocator to make decision to allocate
import java.util.List;
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Setting;
        ShardRouting initialize(
    /**
     * Called when the given shards have started, so that implementations can invalidate caches and clean up any in-flight activity for
     * Called when the given shards have failed, so that implementations can invalidate caches and clean up any in-flight activity for
 * specific language governing permissions and limitations
    /**
    Setting<Boolean> EXISTING_SHARDS_ALLOCATOR_BATCH_MODE = Setting.boolSetting(
     * <p>
import java.util.ArrayList;
    );
         * updates the unassigned info and recovery source on the current unassigned shard
    void beforeAllocation(RoutingAllocation allocation);
         * will be added back to unassigned once the metadata is constructed again).
import org.opensearch.cluster.routing.RoutingChangesObserver;
        ShardRouting shardRouting,
         */
        Setting.Property.PrivateIndex
     */
     * Allows plugins to override how we allocate shards that may already exist on disk in the cluster.
         * Initializes the current unassigned shard and moves it from the unassigned list.
    /**
         *
        true,
        GatewayAllocator.ALLOCATOR_NAME,
    );
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.gateway.GatewayAllocator;
            ShardRouting shardRouting = iterator.next();
        );
     */
     * and is kept here for backward compatibility.
     * <p>
     */
 * @opensearch.internal
     * Allocation service will currently run the default implementation of it implemented by {@link ShardsBatchGatewayAllocator}
 * SPDX-License-Identifier: Apache-2.0
     * Called before starting a round of allocation, allowing the allocator to invalidate some caches if appropriate.
         * that subsequent consumers of this API won't try to allocate this shard again.
    /**
     */
/**
            long expectedShardSize,
     * The default implementation of this method is not optimized and assigns shards one by one.
import org.opensearch.common.Nullable;
        }
     * Allocate all unassigned shards in the given {@link RoutingAllocation} for which this {@link ExistingShardsAllocator} is responsible.
         *
    void cleanCaches();
    AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation);
     */
            @Nullable String existingAllocationId,
     * {@link ShardsBatchGatewayAllocator}.
    }
         */
        UnassignedAllocationHandler unassignedAllocationHandler
     */
    void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation);
        "cluster.allocator.existing_shards_allocator.batch_enabled",
     */
        Setting.Property.NodeScope
        /**
         * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
    }
import org.opensearch.cluster.routing.RoutingNodes;
    default Runnable allocateAllUnassignedShards(RoutingAllocation allocation, boolean primary) {
 * software distributed under the License is distributed on an
    /**
}
 * GitHub history for details.
/*
 */
     * @return the number of in-flight fetches under this allocator's control.
    void afterPrimariesBeforeReplicas(RoutingAllocation allocation);
     * in-flight activity from an earlier mastership.
                runnables.add(() -> allocateUnassigned(shardRouting, allocation, iterator));
         * Typically this is used when an allocation decision prevents a shard from being allocated such
        void removeAndIgnore(UnassignedInfo.AllocationStatus attempt, RoutingChangesObserver changes);
         * @param  unassignedInfo the new unassigned info to use
        while (iterator.hasNext()) {
     * {@link RoutingNodes.UnassignedShards.UnassignedIterator} to limit what allocators can do.
     */
     * Used by {@link ExistingShardsAllocator#allocateUnassigned} to handle its allocation decisions. A restricted interface to
 *     http://www.apache.org/licenses/LICENSE-2.0
     * those shards.
 */
        RoutingAllocation allocation,
         */
 *
 * ownership. Elasticsearch licenses this file to you under
     */
     * If no plugin overrides {@link ExistingShardsAllocator} then default implementation will be used for it , i.e,
        "index.allocation.existing_shards_allocator",
 * license agreements. See the NOTICE file distributed with
    void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation);
     */
        /**
    void allocateUnassigned(
    /**
     * in one or more go.
    /**
    );
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
     * This setting is enabled by default. In your ExistingShardAllocator implement the
 * Unless required by applicable law or agreed to in writing,
     * Default implementation calls {@link #allocateUnassigned(ShardRouting, RoutingAllocation, UnassignedAllocationHandler)} for each Unassigned shard
     * Boolean setting to enable/disable batch allocation of unassigned shards already existing on disk.
     *
    Setting<String> EXISTING_SHARDS_ALLOCATOR_SETTING = Setting.simpleString(
 */
        Setting.Property.IndexScope,
            String nodeId,
     * {@link ExistingShardsAllocator#allocateAllUnassignedShards(RoutingAllocation, boolean)} method.
     * Called during a round of allocation after attempting to allocate all the primaries but before any replicas, allowing the allocator
    /**
