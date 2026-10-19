 * compatible open source license.
    /**
     * to prepare for replica allocation.
     * {@link ExistingShardsAllocator#allocateAllUnassignedShards(RoutingAllocation, boolean)} method.
                runnables.add(() -> allocateUnassigned(shardRouting, allocation, iterator));
         * Removes and ignores the unassigned shard (will be ignored for this run, but  
    default Runnable allocateAllUnassignedShards(RoutingAllocation allocation, boolean primary) {
    );
         * @param attempt the result of the allocation attempt
         */  
    /**  
public interface ExistingShardsAllocator {
     * Allows plugins to override how we allocate shards that may already exist on disk in the cluster.
 * Modifications Copyright OpenSearch Contributors. See  
     * {@link RoutingNodes.UnassignedShards.UnassignedIterator} to limit what allocators can do.
         *
    /**  
 * GitHub history for details.
 * under the License.  
 *
    void allocateUnassigned(  
     */  
        }  
        Setting.Property.NodeScope
    }
import org.opensearch.cluster.routing.UnassignedInfo;
        ShardRouting initialize(
     * If no plugin overrides {@link ExistingShardsAllocator} then default implementation will be used for it , i.e,
         * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
     */
 * not use this file except in compliance with the License.
     * in one or more go.
 * {@link GatewayAllocator} and {@link ShardsBatchGatewayAllocator}, but plugins can supply their own implementations too.  
import org.opensearch.cluster.routing.RoutingChangesObserver;
        /**  
    /**  
    /**
     * This setting is enabled by default. In your ExistingShardAllocator implement the  
    void afterPrimariesBeforeReplicas(RoutingAllocation allocation);
    /**  
    );
     */  
            long expectedShardSize,
    /**  
        GatewayAllocator.ALLOCATOR_NAME,
         * that subsequent consumers of this API won't try to allocate this shard again.  
 * the Apache License, Version 2.0 (the "License"); you may
     * Allocate all unassigned shards in the given {@link RoutingAllocation} for which this {@link ExistingShardsAllocator} is responsible.
     * Used by {@link ExistingShardsAllocator#allocateUnassigned} to handle its allocation decisions. A restricted interface to  
 * @opensearch.internal
            if (shardRouting.primary() == primary) {  
     */  
     * in-flight activity from an earlier mastership.
     */  
 *
        /**
     * This will allow sending all Unassigned Shards to the ExistingShard Allocator to make decision to allocate  
    Setting<String> EXISTING_SHARDS_ALLOCATOR_SETTING = Setting.simpleString(  
        "index.allocation.existing_shards_allocator",
    Setting<Boolean> EXISTING_SHARDS_ALLOCATOR_BATCH_MODE = Setting.boolSetting(
        Setting.Property.IndexScope,  
/**
import java.util.List;
        "cluster.allocator.existing_shards_allocator.batch_enabled",
        true,  
    void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation);
        return () -> runnables.forEach(Runnable::run);
     */
     * and is kept here for backward compatibility.  
    void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation);
     * The default implementation of this method is not optimized and assigns shards one by one.
     * Returns an explanation for a single unassigned shard.
     */  
/*
        );  
     * Allocate any unassigned shards in the given {@link RoutingAllocation} for which this {@link ExistingShardsAllocator} is responsible.
    /**
         * @return the shard with unassigned info updated
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster.routing.allocation;
     */  
        UnassignedAllocationHandler unassignedAllocationHandler  
 * software distributed under the License is distributed on an
     * Called when the given shards have started, so that implementations can invalidate caches and clean up any in-flight activity for
            }
 * Licensed to Elasticsearch under one or more contributor  
        void removeAndIgnore(UnassignedInfo.AllocationStatus attempt, RoutingChangesObserver changes);
         * @param  unassignedInfo the new unassigned info to use  
     * those shards.
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    interface UnassignedAllocationHandler {  
    }
     * Called during a round of allocation after attempting to allocate all the primaries but before any replicas, allowing the allocator
     * Boolean setting to enable/disable batch allocation of unassigned shards already existing on disk.
     */  
         */  
     */
         */  
         * Initializes the current unassigned shard and moves it from the unassigned list.  
 * ownership. Elasticsearch licenses this file to you under  
        while (iterator.hasNext()) {
    void cleanCaches();
        /**
    /**  
     */
        Setting.Property.PrivateIndex
 */
    /**  
         *
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
     * Allocation service will currently run the default implementation of it implemented by {@link ShardsBatchGatewayAllocator}
    /**  
/*  
    void beforeAllocation(RoutingAllocation allocation);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.gateway.GatewayAllocator;
     * {@link ShardsBatchGatewayAllocator}.
     * <p>  
         * updates the unassigned info and recovery source on the current unassigned shard
        ShardRouting updateUnassigned(UnassignedInfo unassignedInfo, RecoverySource recoverySource, RoutingChangesObserver changes);
            String nodeId,
 */
import org.opensearch.cluster.routing.RecoverySource;  
/*
 * this work for additional information regarding copyright
    /**
import java.util.ArrayList;
     * Default implementation calls {@link #allocateUnassigned(ShardRouting, RoutingAllocation, UnassignedAllocationHandler)} for each Unassigned shard
 *
 */  
     * <p>
 * Searches for, and allocates, shards for which there is an existing on-disk copy somewhere in the cluster. The default implementation is
     * Called before starting a round of allocation, allowing the allocator to invalidate some caches if appropriate.
        ShardRouting shardRouting,
import org.opensearch.cluster.routing.ShardRouting;  
 * SPDX-License-Identifier: Apache-2.0
         * Typically this is used when an allocation decision prevents a shard from being allocated such
            RoutingChangesObserver routingChangesObserver
         * will be added back to unassigned once the metadata is constructed again).
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.RoutingNodes;
            @Nullable String existingAllocationId,  
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
    );
     */  
 * You may obtain a copy of the License at  
        RoutingAllocation allocation,
     * @return the number of in-flight fetches under this allocator's control.
     * those shards.
     *
     * Called when the given shards have failed, so that implementations can invalidate caches and clean up any in-flight activity for
import org.opensearch.common.Nullable;
         * @param  recoverySource the new recovery source to use
 *  
import org.opensearch.common.settings.Setting;  
 */  
 * this file be licensed under the Apache-2.0 license or a
    int getNumberOfInFlightFetches();  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Called when this node becomes the elected cluster-manager and when it stops being the elected cluster-manager, so that implementations can clean up any
            ShardRouting shardRouting = iterator.next();
         *
        List<Runnable> runnables = new ArrayList<>();  
    AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation);
}  
