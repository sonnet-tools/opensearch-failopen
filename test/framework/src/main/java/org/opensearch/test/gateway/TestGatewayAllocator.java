 * SPDX-License-Identifier: Apache-2.0
                                getReplicationCheckpoint(shardId, routing.currentNodeId()),
public class TestGatewayAllocator extends GatewayAllocator {
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.test.gateway;
    /**  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.allocation.FailedShard;
    }
import org.opensearch.cluster.routing.ShardRouting;  
 * this work for additional information regarding copyright
                }
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        @Override
 *
            });
                    put(shardId, ignoreNodes);
        UnassignedAllocationHandler unassignedAllocationHandler  
    }
 */
                    put(shardId, allocation.getIgnoreNodes(shardId));  
        return shardIdNodeToReplicationCheckPointMap.getOrDefault(getReplicationCheckPointKey(shardId, nodeName), null);
    @Override
 * that are used as replies to the, normally async, fetch data requests. The in memory list
                .filter(ks -> ignoreNodes.contains(ks.currentNodeId()) == false)  
            if (nodeAllocations != null) {
        }
                        )
        for (FailedShard failedShard : failedShards) {
 * Unless required by applicable law or agreed to in writing,
 * This class is useful to use in unit tests that require the functionality of {@link GatewayAllocator} but do
 *  
        knownAllocations.computeIfAbsent(shard.currentNodeId(), id -> new HashMap<>()).put(shard.shardId(), shard);
 *
    }  
            final ShardId shardId = shard.shardId();  
 * software distributed under the License is distributed on an
/*
                );  
                    knownAllocations.remove(failedRouting.currentNodeId());
/**
                        routing -> currentNodes.get(routing.currentNodeId()),
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.cluster.node.DiscoveryNodes;
 *
 * not have all the infrastructure required to use it.  
        }  
    public void addKnownAllocation(ShardRouting shard) {  
        RoutingAllocation allocation,
 * For now only primary shard related data is fetched. Replica request always get an empty response.
import java.util.stream.Collectors;  
    }  
                    Collectors.toMap(  
 * Nodes leaving and joining the cluster do not change the list of shards the class tracks but
        ShardRouting shardRouting,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .flatMap(shardMap -> shardMap.values().stream())
import java.util.HashMap;
                .filter(ks -> currentNodes.nodeExists(ks.currentNodeId()))
import org.opensearch.gateway.AsyncShardFetch;
     */
    Map<String, ReplicationCheckpoint> shardIdNodeToReplicationCheckPointMap = new HashMap<>();  
 * A gateway allocator implementation that keeps an in memory list of started shard allocation  
    }
                }  
import java.util.Collections;
 * specific language governing permissions and limitations
                    )
            // for now always return immediately what we know
            return new AsyncShardFetch.FetchResult<>(Collections.emptyMap(), new HashMap<>() {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
    @Override
                            )  
 */
 * not use this file except in compliance with the License.
/*  
 * <p>
    @Override
 * <p>  
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata;
                {
 * only return shards that were started on nodes that are currently part of the cluster.  
            return new AsyncShardFetch.FetchResult<>(foundShards, new HashMap<>() {
            // for now, just pretend no node has data
        currentNodes = allocation.nodes();
    }  
    @Override
                nodeAllocations.remove(failedRouting.shardId());  
    public String getReplicationCheckPointKey(ShardId shardId, String nodeName) {
 */  
                }
import java.util.List;  
        currentNodes = allocation.nodes();
            Map<DiscoveryNode, NodeGatewayStartedShards> foundShards = knownAllocations.values()
        innerAllocatedUnassigned(allocation, primaryShardAllocator, replicaShardAllocator, shardRouting, unassignedAllocationHandler);  
import org.opensearch.gateway.ReplicaShardAllocator;
        currentNodes = allocation.nodes();
 * <p>  
        protected boolean hasInitiatedFetching(ShardRouting shard) {  
            final Set<String> ignoreNodes = allocation.getIgnoreNodes(shardId);
    };
    }  
 * ownership. Elasticsearch licenses this file to you under  
        protected AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> fetchData(ShardRouting shard, RoutingAllocation allocation) {
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper;
 * is adapted when shards are started and failed.
        shardIdNodeToReplicationCheckPointMap.putIfAbsent(getReplicationCheckPointKey(shardId, nodeName), replicationCheckpoint);  
/*  
                .collect(
    public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {  
                {  
import org.opensearch.gateway.PrimaryShardAllocator;  
 */  
            }
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
import org.opensearch.gateway.GatewayAllocator;
 * compatible open source license.
import org.opensearch.core.index.shard.ShardId;  
    public void beforeAllocation(RoutingAllocation allocation) {}  
}  
import org.opensearch.cluster.node.DiscoveryNode;
                .filter(ks -> ks.shardId().equals(shardId))
                            currentNodes.get(routing.currentNodeId()),  
 * this file be licensed under the Apache-2.0 license or a
    };  
     * manually add a specific shard to the allocations the gateway keeps track of
 * license agreements. See the NOTICE file distributed with
                                routing.primary(),  
    DiscoveryNodes currentNodes = DiscoveryNodes.EMPTY_NODES;
import org.opensearch.gateway.TransportNodesListGatewayStartedShards.NodeGatewayStartedShards;  
import java.util.Set;
        protected AsyncShardFetch.FetchResult<NodeGatewayStartedShards> fetchData(ShardRouting shard, RoutingAllocation allocation) {
    ) {
import java.util.Map;
        }
                            new TransportNodesGatewayStartedShardHelper.GatewayStartedShard(
            final ShardId shardId = shard.shardId();  
            final ShardRouting failedRouting = failedShard.getRoutingEntry();  
 * GitHub history for details.
                .stream()  
                                null
                                routing.allocationId().getId(),
        @Override  
    Map<String /* node id */, Map<ShardId, ShardRouting>> knownAllocations = new HashMap<>();
    private ReplicationCheckpoint getReplicationCheckpoint(ShardId shardId, String nodeName) {
            });  
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}  
            Map<ShardId, ShardRouting> nodeAllocations = knownAllocations.get(failedRouting.currentNodeId());
        allocation.routingNodes().shards(ShardRouting::active).forEach(this::addKnownAllocation);
        }
    public void addReplicationCheckpoint(ShardId shardId, String nodeName, ReplicationCheckpoint replicationCheckpoint) {
 * KIND, either express or implied.  See the License for the
    @Override
    public void allocateUnassigned(  
 * rather serves as a filter to what is returned by fetch data. Concretely - fetch data will
            return true;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return shardId.toString() + "_" + nodeName;
    public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {  
 * under the License.  
    ReplicaShardAllocator replicaShardAllocator = new ReplicaShardAllocator() {
                if (nodeAllocations.isEmpty()) {
    PrimaryShardAllocator primaryShardAllocator = new PrimaryShardAllocator() {
                        routing -> new NodeGatewayStartedShards(
