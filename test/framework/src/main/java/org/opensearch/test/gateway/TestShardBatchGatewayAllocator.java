        return shardIdNodeToReplicationCheckPointMap.getOrDefault(getReplicationCheckPointKey(shardId, nodeName), null);
    public TestShardBatchGatewayAllocator(long maxBatchSize) {
                    if (shardsOnNode.containsKey(shardId) && ignoreNodes.contains(nodeId) == false && currentNodes.nodeExists(nodeId)) {
        }
            }
                    ShardId shardId = shardRouting.shardId();
    CountDownLatch latch;
    public void beforeAllocation(RoutingAllocation allocation) {}
}
    ReplicaShardBatchAllocator replicaBatchShardAllocator = new ReplicaShardBatchAllocator() {
    }
        ) {
        }
                latch.countDown();
        }
        super.safelyRemoveShardFromBothBatch(shardRouting);
        return super.getBatchId(shard, primary);
                                shardsOnNode.get(shardId).primary(),
import org.opensearch.core.index.shard.ShardId;
            return true;
    public Set<String> createAndUpdateBatches(RoutingAllocation allocation, boolean primary) {
                            );
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
                                shardsOnNode.get(shardId).allocationId().getId(),
        return batchIdToStartedShardBatch;
        ) {
    public TestShardBatchGatewayAllocator(CountDownLatch latch, long maxBatchSize, RerouteService rerouteService) {
    public String getBatchId(ShardRouting shard, boolean primary) {
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper;
import org.opensearch.gateway.AsyncShardFetch;
                HashMap<ShardId, TransportNodesGatewayStartedShardHelper.GatewayStartedShard> adaptedResponse = new HashMap<>();
        protected void allocateUnassignedBatchOnTimeout(Set<ShardId> shardIds, RoutingAllocation allocation, boolean primary) {
                        TransportNodesGatewayStartedShardHelper.GatewayStartedShard nodeShard =
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch;
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> fetchData(
import java.util.HashMap;
    }
 * The OpenSearch Contributors require contributions made to
        super(maxBatchSize, null);
                    }
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
import java.util.Collections;
                    );
import org.opensearch.cluster.routing.ShardRouting;
    Map<String /* node id */, Map<ShardId, ShardRouting>> knownAllocations = new HashMap<>();
    public TestShardBatchGatewayAllocator() {
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> fetchData(
    @Override
        return innerAllocateUnassignedBatch(allocation, primaryBatchShardAllocator, replicaBatchShardAllocator, primary);
        super.safelyRemoveShardFromBatch(shard, shard.primary());
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                }
    }
            for (int i = 0; i < shardIds.size(); i++) {
    }
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}
        return super.createAndUpdateBatches(allocation, primary);
    }
            HashMap<ShardId, Set<String>> shardsToIgnoreNodes = new HashMap<>();
import org.opensearch.gateway.ReplicaShardBatchAllocator;
    public String getReplicationCheckPointKey(ShardId shardId, String nodeName) {
            for (Map.Entry<String, Map<ShardId, ShardRouting>> entry : knownAllocations.entrySet()) {
    public void safelyRemoveShardFromBatch(ShardRouting shard) {
        protected void allocateUnassignedBatchOnTimeout(Set<ShardId> shardIds, RoutingAllocation allocation, boolean primary) {
        @Override
        super(maxBatchSize, rerouteService);
                            currentNodes.get(nodeId),
                            new TransportNodesGatewayStartedShardHelper.GatewayStartedShard(
package org.opensearch.test.gateway;
            return new AsyncShardFetch.FetchResult<>(foundShards, shardsToIgnoreNodes);
                String nodeId = entry.getKey();
    @Override
    };
            List<ShardRouting> eligibleShards,
    }
    }
 */
    protected ReplicationCheckpoint getReplicationCheckpoint(ShardId shardId, String nodeName) {
import java.util.concurrent.CountDownLatch;
        this.latch = latch;
        return super.explainUnassignedShardAllocation(unassignedShard, routingAllocation);
        return shardId.toString() + "_" + nodeName;
        @Override
                    foundShards.put(
                        shardsToIgnoreNodes.put(shardId, ignoreNodes);
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
import org.opensearch.cluster.node.DiscoveryNode;
            RoutingAllocation allocation
import org.opensearch.cluster.routing.RerouteService;
            }
        }
                Map<ShardId, ShardRouting> shardsOnNode = entry.getValue();
    public Map<String, ShardsBatchGatewayAllocator.ShardsBatch> getBatchIdToStoreShardBatch() {
    public Map<String, ShardsBatchGatewayAllocator.ShardsBatch> getBatchIdToStartedShardBatch() {
            List<ShardRouting> inEligibleShards,
        }
    };
            List<ShardRouting> inEligibleShards,
                        )
    PrimaryShardBatchAllocator primaryBatchShardAllocator = new PrimaryShardBatchAllocator() {
    }
        @Override
            }
import org.opensearch.cluster.node.DiscoveryNodes;
import java.util.Map;
 * compatible open source license.
    @Override
                            adaptedResponse
 * SPDX-License-Identifier: Apache-2.0
        protected boolean hasInitiatedFetching(ShardRouting shard) {
import org.opensearch.common.util.BatchRunnableExecutor;
public class TestShardBatchGatewayAllocator extends ShardsBatchGatewayAllocator {
        return batchIdToStoreShardBatch;
                for (ShardRouting shardRouting : eligibleShards) {
    }
 *
 * this file be licensed under the Apache-2.0 license or a
/*
                                getReplicationCheckpoint(shardId, nodeId)
    public void safelyRemoveShardFromBothBatch(ShardRouting shardRouting) {
import org.opensearch.gateway.PrimaryShardBatchAllocator;
                        currentNodes.get(nodeId),
    DiscoveryNodes currentNodes = DiscoveryNodes.EMPTY_NODES;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        @Override
    }
                    Set<String> ignoreNodes = allocation.getIgnoreNodes(shardId);
import java.util.List;
    Map<String, ReplicationCheckpoint> shardIdNodeToReplicationCheckPointMap = new HashMap<>();
            Map<DiscoveryNode, TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> foundShards = new HashMap<>();
                latch.countDown();
            return new AsyncShardFetch.FetchResult<>(Collections.emptyMap(), Collections.emptyMap());
            for (int i = 0; i < shardIds.size(); i++) {
    }
            RoutingAllocation allocation
    @Override
import java.util.Set;
            List<ShardRouting> eligibleShards,
    public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation) {
                        new TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch(
    }
        currentNodes = allocation.nodes();
        @Override
                        adaptedResponse.put(shardId, nodeShard);
    }
    public BatchRunnableExecutor allocateAllUnassignedShards(RoutingAllocation allocation, boolean primary) {
