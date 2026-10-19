        ) {
        ) {
import java.util.Map;  
        return super.explainUnassignedShardAllocation(unassignedShard, routingAllocation);  
                }  
    }
import java.util.HashMap;
        @Override  
        this.latch = latch;
    @Override
                    Set<String> ignoreNodes = allocation.getIgnoreNodes(shardId);
    public Map<String, ShardsBatchGatewayAllocator.ShardsBatch> getBatchIdToStartedShardBatch() {
            return new AsyncShardFetch.FetchResult<>(Collections.emptyMap(), Collections.emptyMap());  
        super(maxBatchSize, rerouteService);
            HashMap<ShardId, Set<String>> shardsToIgnoreNodes = new HashMap<>();  
            }  
    public Set<String> createAndUpdateBatches(RoutingAllocation allocation, boolean primary) {
 * The OpenSearch Contributors require contributions made to  
        }
 * SPDX-License-Identifier: Apache-2.0
        return super.getBatchId(shard, primary);
    };
                            currentNodes.get(nodeId),
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch;
    @Override
    }
    public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}
    @Override
    public BatchRunnableExecutor allocateAllUnassignedShards(RoutingAllocation allocation, boolean primary) {
                latch.countDown();
import java.util.concurrent.CountDownLatch;
    }  
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper;
                latch.countDown();
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
import org.opensearch.gateway.ReplicaShardBatchAllocator;
                        )
                                getReplicationCheckpoint(shardId, nodeId)  
    public Map<String, ShardsBatchGatewayAllocator.ShardsBatch> getBatchIdToStoreShardBatch() {  
        protected void allocateUnassignedBatchOnTimeout(Set<ShardId> shardIds, RoutingAllocation allocation, boolean primary) {  
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> fetchData(  
        super(maxBatchSize, null);  
import org.opensearch.gateway.ShardsBatchGatewayAllocator;  
    DiscoveryNodes currentNodes = DiscoveryNodes.EMPTY_NODES;
    public TestShardBatchGatewayAllocator(CountDownLatch latch, long maxBatchSize, RerouteService rerouteService) {  
    }  
    }
            List<ShardRouting> inEligibleShards,
    PrimaryShardBatchAllocator primaryBatchShardAllocator = new PrimaryShardBatchAllocator() {
    }
    }
            return new AsyncShardFetch.FetchResult<>(foundShards, shardsToIgnoreNodes);
import org.opensearch.cluster.routing.ShardRouting;
    }
            List<ShardRouting> eligibleShards,
                        new TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch(
        protected boolean hasInitiatedFetching(ShardRouting shard) {
        return shardIdNodeToReplicationCheckPointMap.getOrDefault(getReplicationCheckPointKey(shardId, nodeName), null);
}
import org.opensearch.core.index.shard.ShardId;
            for (Map.Entry<String, Map<ShardId, ShardRouting>> entry : knownAllocations.entrySet()) {
                    ShardId shardId = shardRouting.shardId();
                                shardsOnNode.get(shardId).primary(),
                            );
    public String getBatchId(ShardRouting shard, boolean primary) {
import java.util.List;
        return shardId.toString() + "_" + nodeName;
    Map<String /* node id */, Map<ShardId, ShardRouting>> knownAllocations = new HashMap<>();  
        @Override
public class TestShardBatchGatewayAllocator extends ShardsBatchGatewayAllocator {
        }  
        return batchIdToStartedShardBatch;  
            RoutingAllocation allocation
            return true;
                        TransportNodesGatewayStartedShardHelper.GatewayStartedShard nodeShard =
            }
 * compatible open source license.
    }
    @Override
        }
 */  
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> fetchData(
    protected ReplicationCheckpoint getReplicationCheckpoint(ShardId shardId, String nodeName) {  
            List<ShardRouting> eligibleShards,
        @Override  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        return innerAllocateUnassignedBatch(allocation, primaryBatchShardAllocator, replicaBatchShardAllocator, primary);
    public TestShardBatchGatewayAllocator() {
    public void beforeAllocation(RoutingAllocation allocation) {}
        return batchIdToStoreShardBatch;
    Map<String, ReplicationCheckpoint> shardIdNodeToReplicationCheckPointMap = new HashMap<>();
                                shardsOnNode.get(shardId).allocationId().getId(),
                String nodeId = entry.getKey();
import org.opensearch.cluster.routing.RerouteService;  
 *
 * this file be licensed under the Apache-2.0 license or a
    public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation routingAllocation) {
    ReplicaShardBatchAllocator replicaBatchShardAllocator = new ReplicaShardBatchAllocator() {
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.node.DiscoveryNode;
            Map<DiscoveryNode, TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> foundShards = new HashMap<>();
        @Override
        @Override
                HashMap<ShardId, TransportNodesGatewayStartedShardHelper.GatewayStartedShard> adaptedResponse = new HashMap<>();
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
import org.opensearch.gateway.PrimaryShardBatchAllocator;
        }  
                    }
import java.util.Set;
                        adaptedResponse.put(shardId, nodeShard);
/*  
        return super.createAndUpdateBatches(allocation, primary);
            for (int i = 0; i < shardIds.size(); i++) {
        protected void allocateUnassignedBatchOnTimeout(Set<ShardId> shardIds, RoutingAllocation allocation, boolean primary) {  
    public void safelyRemoveShardFromBothBatch(ShardRouting shardRouting) {  
        }
            }  
    }  
                        currentNodes.get(nodeId),  
                for (ShardRouting shardRouting : eligibleShards) {  
                        shardsToIgnoreNodes.put(shardId, ignoreNodes);  
    CountDownLatch latch;  
    public TestShardBatchGatewayAllocator(long maxBatchSize) {
            for (int i = 0; i < shardIds.size(); i++) {
import org.opensearch.gateway.AsyncShardFetch;  
        super.safelyRemoveShardFromBothBatch(shardRouting);
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
                    );
                Map<ShardId, ShardRouting> shardsOnNode = entry.getValue();  
                    foundShards.put(
    public void safelyRemoveShardFromBatch(ShardRouting shard) {
                    if (shardsOnNode.containsKey(shardId) && ignoreNodes.contains(nodeId) == false && currentNodes.nodeExists(nodeId)) {
                            new TransportNodesGatewayStartedShardHelper.GatewayStartedShard(  
import java.util.Collections;  
    };
    public String getReplicationCheckPointKey(ShardId shardId, String nodeName) {
            RoutingAllocation allocation  
            List<ShardRouting> inEligibleShards,  
    }  
        super.safelyRemoveShardFromBatch(shard, shard.primary());  
    }
                            adaptedResponse  
import org.opensearch.common.util.BatchRunnableExecutor;
        currentNodes = allocation.nodes();  
package org.opensearch.test.gateway;
    }
