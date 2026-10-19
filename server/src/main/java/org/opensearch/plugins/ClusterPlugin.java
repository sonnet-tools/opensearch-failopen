    /**  
     * @return A map of allocator implementations
 * Licensed to Elasticsearch under one or more contributor  
     * default allocator is {@link org.opensearch.gateway.GatewayAllocator}.
import java.util.Collections;
        return Collections.emptyMap();
     * @return true if this plugin will handle cluster state management on behalf of the node, so the node does not  
 *
        return false;  
     */
import org.opensearch.common.settings.Settings;
import java.util.function.Supplier;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * <p>
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * license agreements. See the NOTICE file distributed with
     * {@link ExistingShardsAllocator#EXISTING_SHARDS_ALLOCATOR_SETTING} sets the key of the allocator to use to allocate its shards. The  
     */
 *
 * Modifications Copyright OpenSearch Contributors. See
    default Map<String, ExistingShardsAllocator> getExistingShardsAllocators() {  
     *
     * need to discover a cluster manager and be part of a cluster.
    /**
     * @return List of {@link IndexNameExpressionResolver.ExpressionResolver}  
public interface ClusterPlugin {
     */
    default void onNodeStarted(DiscoveryNode localNode) {
     */
 *
     *
 */
    }
        return Collections.emptyMap();
 * An extension point for {@link Plugin} implementations to customer behavior of cluster management.  
    }
     */  
package org.opensearch.plugins;
     */  
     * Return {@link ShardsAllocator} implementations added by this plugin.  
 * @opensearch.api
        return Collections.emptyList();  
     *
    default Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
import org.opensearch.cluster.node.DiscoveryNode;
    default void onNodeStarted() {}  
}
    /**
 * under the License.  
    @Deprecated
        return Collections.emptyList();
     * Called when node is started. DiscoveryNode argument is passed to allow referring localNode value inside plugin  
 * not use this file except in compliance with the License.
     *
        onNodeStarted();
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
     * @param clusterSettings Settings for the cluster  
/*
     * Returns List of custom index name resolvers which can support additional custom wildcards.
     * The key of the returned {@link Map} is the name of the allocator, and the value
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;  
 */  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
 * this work for additional information regarding copyright
    }  
    }
     * is a function to construct the allocator.  
import java.util.Collection;  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
/*  
    /**  
/*  
 * KIND, either express or implied.  See the License for the
     */
import org.opensearch.common.settings.ClusterSettings;  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param settings Settings for the node
import java.util.Map;
     *
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 */  
    default Collection<IndexNameExpressionResolver.ExpressionResolver> getIndexNameCustomResolvers() {
 * software distributed under the License is distributed on an
     * Return {@link ExistingShardsAllocator} implementations added by this plugin; the index setting
    /**
 * You may obtain a copy of the License at  
    }
     * Called when the node is started
     * @param settings Settings for the node  
 * specific language governing permissions and limitations
    default Map<String, Supplier<ShardsAllocator>> getShardsAllocators(Settings settings, ClusterSettings clusterSettings) {  
 * this file be licensed under the Apache-2.0 license or a
    /**
     * @param localNode local Node info
     * @deprecated Use {@link #onNodeStarted(DiscoveryNode)} for newer implementations.  
     * @return Custom {@link AllocationDecider} instances
     * Return deciders used to customize where shards are allocated.
     * @param clusterSettings Settings for the cluster
/**
    /**
     * Note that if any ClusterPlugin returns true from this method, the node will start in clusterless mode.  
    default boolean isClusterless() {
