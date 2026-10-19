     * and construct the nodeShardState along the way before making any allocation decision. As metadata for a
                        shardData.storeException(),  
 * (see {@link org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator}),  
    }
        );
        nodeResponses.forEach((node, nodeGatewayStartedShardsBatch) -> {
            return decision;
        // build data for a shard from all the nodes  
        List<ShardRouting> inEligibleShards = new ArrayList<>();
                        node
        }  
    }
    private static List<NodeGatewayStartedShard> adaptToNodeShardStates(
        // identify ineligible shards  
 * Note that the PrimaryShardBatchAllocator does *not* allocate primaries on index creation
     * Returns null if {@link FetchResult} does not have any data.  
import org.opensearch.cluster.node.DiscoveryNode;
            GatewayStartedShard shardData = nodeGatewayStartedShardsBatch.getNodeGatewayStartedShardsBatch().get(unassignedShard.shardId());
                );  
    }
            if (decision != null) {  
 * nor does it allocate primaries when a primary shard failed and there is a valid replica
 * this file be licensed under the Apache-2.0 license or a
    }
     * @param shardRoutings the shards to allocate
     * @param allocation    the allocation state container object
     * and NodeGatewayStartedShardsBatch so to get one shard level data (from all the nodes), we'll traverse the map  
        return nodeShardStates;  
     *  
        List<NodeGatewayStartedShard> nodeGatewayStartedShards = adaptToNodeShardStates(unassignedShard, shardsState);  
        });
                    allocationDecision = getAllocationDecision(unassignedShard, allocation, nodeShardStates, logger);
        for (ShardRouting shard : shardRoutings) {
        List<ShardRouting> eligibleShards = new ArrayList<>();
import java.util.Collections;
    abstract protected FetchResult<NodeGatewayStartedShardsBatch> fetchData(
 * SPDX-License-Identifier: Apache-2.0
     * @return shard state returned from each node  
                        shardData.primary(),
 * unassigned shard.  
        return getAllocationDecision(unassignedShard, allocation, nodeGatewayStartedShards, logger);
     */  
            }
        FetchResult<NodeGatewayStartedShardsBatch> shardsState
        // only fetch data for eligible shards
        if (!shardsState.hasData()) {  
import org.opensearch.cluster.routing.RoutingNodes;  
                nodeShardStates.add(
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch;
        List<ShardRouting> eligibleShards,  
            } else {  
import java.util.Set;
 * The primary shard batch allocator allocates multiple unassigned primary shards to nodes that hold
    ) {
                    List<NodeGatewayStartedShard> nodeShardStates = adaptToNodeShardStates(unassignedShard, shardsState);  
                    )
     */
            List.of(unassignedShard),
        RoutingAllocation allocation
import org.apache.logging.log4j.Logger;
        List<NodeGatewayStartedShard> nodeShardStates = new ArrayList<>();  
            if (unassignedShard.primary() && batchShardRoutingSet.contains(unassignedShard)) {
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.NodeGatewayStartedShard;
     * Allocate Batch of unassigned shard  to nodes where valid copies of the shard already exists
import java.util.List;
        List<ShardRouting> inEligibleShards,
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
public abstract class PrimaryShardBatchAllocator extends PrimaryShardAllocator {  
        throw new IllegalStateException("PrimaryShardBatchAllocator should only be used for a batch of shards");
 * The OpenSearch Contributors require contributions made to  
 * copy that can immediately be promoted to primary, as this takes place in {@link RoutingNodes#failShard}.
    ) {
                } else {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
import java.util.ArrayList;
 * @opensearch.internal
import org.opensearch.core.index.shard.ShardId;
        logger.trace("Starting shard allocation execution for unassigned primary shards: {}", shardRoutings.size());
 * executes the allocation deciders to chose a copy to assign the primary shard to.  
/*  
    );  
        Set<ShardRouting> batchShardRoutingSet = new HashSet<>(shardRoutings);
import java.util.HashSet;
        while (iterator.hasNext()) {
    /**  
import org.opensearch.gateway.AsyncShardFetch.FetchResult;
                if (ineligibleShardAllocationDecisions.containsKey(unassignedShard.shardId())) {  
        }
     * <p>
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> nodeResponses = shardsState.getData();
import java.util.Map;  
                        shardData.replicationCheckpoint(),
     * <p>
import java.util.HashMap;  
 * primary shards in the routing table and fetching shard metadata from each node in the cluster  
 *  
 * PrimaryShardBatchAllocator is similar to {@link org.opensearch.gateway.PrimaryShardAllocator} only difference is
 */
import org.opensearch.cluster.routing.ShardRouting;
     * shardsState contain the Data, there key is DiscoveryNode but value is Map of ShardId
 * <p>
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;  
        ShardRouting shard,  
     *  
        AllocateUnassignedDecision decision = getInEligibleShardDecision(unassignedShard, allocation);  
package org.opensearch.gateway;
}
     * Transforms {@link FetchResult} of {@link NodeGatewayStartedShardsBatch} to {@link List} of {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards}.
            ShardRouting unassignedShard = iterator.next();
        }
        final FetchResult<NodeGatewayStartedShardsBatch> shardsState = fetchData(
            }
            return null;
        final FetchResult<NodeGatewayStartedShardsBatch> shardsState = fetchData(eligibleShards, inEligibleShards, allocation);  
        RoutingAllocation allocation
                eligibleShards.add(shard);
/**  
            allocation
 * that holds a copy of the shard.  The shard metadata from each node is compared against the
 */  
    /**
 * set of valid allocation IDs and for all valid shard copies (if any), the primary shard batch allocator
    @Override
 * that it can allocate multiple unassigned primary shards wherein PrimaryShardAllocator can only allocate single
                ineligibleShardAllocationDecisions.put(shard.shardId(), decision);
            AllocateUnassignedDecision allocationDecision;  
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();  
            }
        ShardRouting unassignedShard,  
     * @param shardsState fetch data result for the whole batch
    protected FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetchData(
        HashMap<ShardId, AllocateUnassignedDecision> ineligibleShardAllocationDecisions = new HashMap<>();  
 *
                }
        logger.error("fetchData for single shard called via batch allocator, shard id {}", shard.shardId());  
            AllocateUnassignedDecision decision = getInEligibleShardDecision(shard, allocation);
    public void allocateUnassignedBatch(List<ShardRouting> shardRoutings, RoutingAllocation allocation) {
        }  
     * @param unassignedShard unassigned shard
 * valid copies of the unassigned primaries.  It does this by iterating over all unassigned
                inEligibleShards.add(shard);
     * particular shard is needed from all the discovery nodes.
                    new NodeGatewayStartedShard(
            Collections.emptyList(),  
            if (null != shardData) {  
        logger.trace("Finished shard allocation execution for unassigned primary shards: {}", shardRoutings.size());  
                executeDecision(unassignedShard, allocationDecision, allocation, iterator);  
        if (decision != null) {
 * compatible open source license.
                        shardData.allocationId(),  
                    allocationDecision = ineligibleShardAllocationDecisions.get(unassignedShard.shardId());
    public AllocateUnassignedDecision makeAllocationDecision(ShardRouting unassignedShard, RoutingAllocation allocation, Logger logger) {
