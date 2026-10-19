import java.util.Map;
 * software distributed under the License is distributed on an
            new BalancedShardsAllocator(settings),
            // noop
        return new AllocationService(
            "",  
        return newNode(nodeId, attributes, Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE));
    public static AllocationService createAllocationService(Settings settings) {
    private static class NoopGatewayAllocator extends GatewayAllocator {
import org.opensearch.cluster.ClusterInfoService;
 * not use this file except in compliance with the License.
        public static final NoopGatewayAllocator INSTANCE = new NoopGatewayAllocator();
        throw new AssertionError("Do not instantiate");
 *  
import org.opensearch.cluster.ClusterModule;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
import java.util.concurrent.atomic.AtomicInteger;
        return new AllocationDeciders(deciders);
    }
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
    }  
    private Allocators() {  
import java.util.Collections;  
 * You may obtain a copy of the License at  
        );  
import org.opensearch.cluster.EmptyClusterInfoService;  
    private static final AtomicInteger portGenerator = new AtomicInteger();
/*
import org.opensearch.core.common.transport.TransportAddress;
 * Unless required by applicable law or agreed to in writing,
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {
    }
import java.util.Set;  
            // noop
 * Licensed to Elasticsearch under one or more contributor  
    public static AllocationService createAllocationService(Settings settings, ClusterSettings clusterSettings) {
 * specific language governing permissions and limitations
            NoopGatewayAllocator.INSTANCE,
            attributes,  
            ShardRouting shardRouting,
import org.opensearch.cluster.routing.allocation.AllocationService;
        @Override  
    }
 *
import org.opensearch.cluster.routing.ShardRouting;  
            // noop  
            clusterInfoService,  
        return createAllocationService(settings, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
    public static DiscoveryNode newNode(String nodeId, Map<String, String> attributes) {  
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        public void allocateUnassigned(  
    ) {
 * The OpenSearch Contributors require contributions made to  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.gateway.GatewayAllocator;
import java.util.Collection;
import org.opensearch.cluster.node.DiscoveryNode;
        }  
    public static DiscoveryNode newNode(String nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
    }
 * under the License.  
        @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
 * GitHub history for details.
    public static AllocationDeciders defaultAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    }
        }  
 * Modifications Copyright OpenSearch Contributors. See  
            UnassignedAllocationHandler unassignedAllocationHandler  
public final class Allocators {  
 * license agreements. See the NOTICE file distributed with
            RoutingAllocation allocation,
        return new DiscoveryNode(
        return createAllocationService(defaultAllocationDeciders(settings, clusterSettings), EmptyClusterInfoService.INSTANCE, settings);  
import org.opensearch.cluster.routing.allocation.FailedShard;
            EmptySnapshotsInfoService.INSTANCE
 */  
        Settings settings  
        Collection<AllocationDecider> deciders = ClusterModule.createAllocationDeciders(settings, clusterSettings, Collections.emptyList());  
            Version.CURRENT
}
            deciders,  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 */
 * this work for additional information regarding copyright
import org.opensearch.Version;  
            new TransportAddress(TransportAddress.META_ADDRESS, portGenerator.incrementAndGet()),
 *
        AllocationDeciders deciders,
import org.opensearch.common.settings.ClusterSettings;
        ClusterInfoService clusterInfoService,
            nodeId,
/*
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.common.util.set.Sets;  
    public static AllocationService createAllocationService(  
        @Override
 * KIND, either express or implied.  See the License for the
        );
        ) {
            roles,
        }
    }
package org.opensearch.benchmark.routing.allocation;
/*  
