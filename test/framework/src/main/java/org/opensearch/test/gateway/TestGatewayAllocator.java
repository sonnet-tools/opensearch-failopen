                }
            final Set<String> ignoreNodes = allocation.getIgnoreNodes(shardId);
                                null
        ShardRouting shardRouting,
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
    @Override
                                routing.primary(),
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper;
 * This class is useful to use in unit tests that require the functionality of {@link GatewayAllocator} but do
                    put(shardId, allocation.getIgnoreNodes(shardId));
import org.opensearch.cluster.routing.ShardRouting;
                .filter(ks -> currentNodes.nodeExists(ks.currentNodeId()))
                    )
 * is adapted when shards are started and failed.
        UnassignedAllocationHandler unassignedAllocationHandler
    public void allocateUnassigned(
        }
 * rather serves as a filter to what is returned by fetch data. Concretely - fetch data will
                            )
                .collect(
     * manually add a specific shard to the allocations the gateway keeps track of
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                .filter(ks -> ks.shardId().equals(shardId))
    public String getReplicationCheckPointKey(ShardId shardId, String nodeName) {
 * <p>
        allocation.routingNodes().shards(ShardRouting::active).forEach(this::addKnownAllocation);
        currentNodes = allocation.nodes();
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
 * GitHub history for details.
        for (FailedShard failedShard : failedShards) {
        currentNodes = allocation.nodes();
        return shardIdNodeToReplicationCheckPointMap.getOrDefault(getReplicationCheckPointKey(shardId, nodeName), null);
            return true;
    private ReplicationCheckpoint getReplicationCheckpoint(ShardId shardId, String nodeName) {
 *
    }
     */
            Map<ShardId, ShardRouting> nodeAllocations = knownAllocations.get(failedRouting.currentNodeId());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                {
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}
            if (nodeAllocations != null) {
        @Override
        protected boolean hasInitiatedFetching(ShardRouting shard) {
    public void addKnownAllocation(ShardRouting shard) {
                            currentNodes.get(routing.currentNodeId()),
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                                routing.allocationId().getId(),
            final ShardId shardId = shard.shardId();
            // for now, just pretend no node has data
                        routing -> new NodeGatewayStartedShards(
    ReplicaShardAllocator replicaShardAllocator = new ReplicaShardAllocator() {
 * <p>
                            new TransportNodesGatewayStartedShardHelper.GatewayStartedShard(
import java.util.Map;
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *
package org.opensearch.test.gateway;
    }
    };
            final ShardRouting failedRouting = failedShard.getRoutingEntry();
/**
        }
            Map<DiscoveryNode, NodeGatewayStartedShards> foundShards = knownAllocations.values()
                    put(shardId, ignoreNodes);
                nodeAllocations.remove(failedRouting.shardId());
 * Unless required by applicable law or agreed to in writing,
    @Override
        shardIdNodeToReplicationCheckPointMap.putIfAbsent(getReplicationCheckPointKey(shardId, nodeName), replicationCheckpoint);
    @Override
import org.opensearch.core.index.shard.ShardId;
    @Override
}
            });
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.gateway.ReplicaShardAllocator;
 */
                        )
        innerAllocatedUnassigned(allocation, primaryShardAllocator, replicaShardAllocator, shardRouting, unassignedAllocationHandler);
                    knownAllocations.remove(failedRouting.currentNodeId());
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                                getReplicationCheckpoint(shardId, routing.currentNodeId()),
 * compatible open source license.
import org.opensearch.cluster.routing.allocation.FailedShard;
                .stream()
 * KIND, either express or implied.  See the License for the
                if (nodeAllocations.isEmpty()) {
    }
import java.util.stream.Collectors;
        knownAllocations.computeIfAbsent(shard.currentNodeId(), id -> new HashMap<>()).put(shard.shardId(), shard);
 * not use this file except in compliance with the License.
import java.util.Collections;
        @Override
 * Modifications Copyright OpenSearch Contributors. See
                .flatMap(shardMap -> shardMap.values().stream())
    }
        RoutingAllocation allocation,
import org.opensearch.cluster.node.DiscoveryNodes;
 * software distributed under the License is distributed on an
        protected AsyncShardFetch.FetchResult<NodeStoreFilesMetadata> fetchData(ShardRouting shard, RoutingAllocation allocation) {
            return new AsyncShardFetch.FetchResult<>(Collections.emptyMap(), new HashMap<>() {
 * that are used as replies to the, normally async, fetch data requests. The in memory list
    /**
                        routing -> currentNodes.get(routing.currentNodeId()),
 * specific language governing permissions and limitations
        }
    Map<String /* node id */, Map<ShardId, ShardRouting>> knownAllocations = new HashMap<>();
    public void beforeAllocation(RoutingAllocation allocation) {}
import java.util.Set;
    public void addReplicationCheckpoint(ShardId shardId, String nodeName, ReplicationCheckpoint replicationCheckpoint) {
 * Nodes leaving and joining the cluster do not change the list of shards the class tracks but
    PrimaryShardAllocator primaryShardAllocator = new PrimaryShardAllocator() {
import org.opensearch.gateway.GatewayAllocator;
 * this work for additional information regarding copyright
                );
import java.util.List;
                    Collectors.toMap(
 * license agreements. See the NOTICE file distributed with
    DiscoveryNodes currentNodes = DiscoveryNodes.EMPTY_NODES;
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata;
/*
            return new AsyncShardFetch.FetchResult<>(foundShards, new HashMap<>() {
        currentNodes = allocation.nodes();
    public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {
            }
        protected AsyncShardFetch.FetchResult<NodeGatewayStartedShards> fetchData(ShardRouting shard, RoutingAllocation allocation) {
 */
/*
    @Override
    ) {
    public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {
                {
 * For now only primary shard related data is fetched. Replica request always get an empty response.
public class TestGatewayAllocator extends GatewayAllocator {
 */
/*
                .filter(ks -> ignoreNodes.contains(ks.currentNodeId()) == false)
                }
            });
 * The OpenSearch Contributors require contributions made to
 * A gateway allocator implementation that keeps an in memory list of started shard allocation
import org.opensearch.gateway.PrimaryShardAllocator;
 * not have all the infrastructure required to use it.
            // for now always return immediately what we know
    Map<String, ReplicationCheckpoint> shardIdNodeToReplicationCheckPointMap = new HashMap<>();
 *
    };
            final ShardId shardId = shard.shardId();
 *
        @Override
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
                }
 * only return shards that were started on nodes that are currently part of the cluster.
import org.opensearch.gateway.AsyncShardFetch;
    }
 */
        return shardId.toString() + "_" + nodeName;
 * <p>
 * You may obtain a copy of the License at
import org.opensearch.gateway.TransportNodesListGatewayStartedShards.NodeGatewayStartedShards;
