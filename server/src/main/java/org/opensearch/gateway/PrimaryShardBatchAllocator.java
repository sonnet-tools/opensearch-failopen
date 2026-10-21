        throw new IllegalStateException("PrimaryShardBatchAllocator should only be used for a batch of shards");
                );
     *
 * The primary shard batch allocator allocates multiple unassigned primary shards to nodes that hold
/*
                ineligibleShardAllocationDecisions.put(shard.shardId(), decision);
import org.apache.logging.log4j.Logger;
                    List<NodeGatewayStartedShard> nodeShardStates = adaptToNodeShardStates(unassignedShard, shardsState);
    }
 * PrimaryShardBatchAllocator is similar to {@link org.opensearch.gateway.PrimaryShardAllocator} only difference is
 * set of valid allocation IDs and for all valid shard copies (if any), the primary shard batch allocator
        }
        logger.trace("Starting shard allocation execution for unassigned primary shards: {}", shardRoutings.size());
        return nodeShardStates;
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
    ) {
    public AllocateUnassignedDecision makeAllocationDecision(ShardRouting unassignedShard, RoutingAllocation allocation, Logger logger) {
     *
        for (ShardRouting shard : shardRoutings) {
 * primary shards in the routing table and fetching shard metadata from each node in the cluster
        nodeResponses.forEach((node, nodeGatewayStartedShardsBatch) -> {
 *
        logger.trace("Finished shard allocation execution for unassigned primary shards: {}", shardRoutings.size());
import org.opensearch.cluster.routing.ShardRouting;
        if (!shardsState.hasData()) {
                } else {
    ) {
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        });
                    )
            GatewayStartedShard shardData = nodeGatewayStartedShardsBatch.getNodeGatewayStartedShardsBatch().get(unassignedShard.shardId());
        List<ShardRouting> inEligibleShards = new ArrayList<>();
 * compatible open source license.
        ShardRouting shard,
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.NodeGatewayStartedShard;
     * particular shard is needed from all the discovery nodes.
public abstract class PrimaryShardBatchAllocator extends PrimaryShardAllocator {
 */
     * <p>
 * Note that the PrimaryShardBatchAllocator does *not* allocate primaries on index creation
        AllocateUnassignedDecision decision = getInEligibleShardDecision(unassignedShard, allocation);
            if (null != shardData) {
    abstract protected FetchResult<NodeGatewayStartedShardsBatch> fetchData(
    /**
        HashMap<ShardId, AllocateUnassignedDecision> ineligibleShardAllocationDecisions = new HashMap<>();
            AllocateUnassignedDecision allocationDecision;
 * executes the allocation deciders to chose a copy to assign the primary shard to.
import java.util.Collections;
     * Transforms {@link FetchResult} of {@link NodeGatewayStartedShardsBatch} to {@link List} of {@link TransportNodesListGatewayStartedShards.NodeGatewayStartedShards}.
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            if (decision != null) {
 * copy that can immediately be promoted to primary, as this takes place in {@link RoutingNodes#failShard}.
import org.opensearch.cluster.routing.RoutingNodes;
            }
     * Returns null if {@link FetchResult} does not have any data.
        FetchResult<NodeGatewayStartedShardsBatch> shardsState
        }
     * @param unassignedShard unassigned shard
            } else {
        RoutingAllocation allocation
                        shardData.replicationCheckpoint(),
import org.opensearch.gateway.AsyncShardFetch.FetchResult;
import java.util.HashMap;
 * valid copies of the unassigned primaries.  It does this by iterating over all unassigned
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> nodeResponses = shardsState.getData();
        return getAllocationDecision(unassignedShard, allocation, nodeGatewayStartedShards, logger);
import org.opensearch.cluster.node.DiscoveryNode;
    @Override
                        node
                }
        }
            allocation
                    allocationDecision = getAllocationDecision(unassignedShard, allocation, nodeShardStates, logger);
     */
        List<ShardRouting> inEligibleShards,
     * and NodeGatewayStartedShardsBatch so to get one shard level data (from all the nodes), we'll traverse the map
 */
            }
    }
     * @param allocation    the allocation state container object
 * this file be licensed under the Apache-2.0 license or a
 *
     * @param shardRoutings the shards to allocate
     * and construct the nodeShardState along the way before making any allocation decision. As metadata for a
                executeDecision(unassignedShard, allocationDecision, allocation, iterator);
     * shardsState contain the Data, there key is DiscoveryNode but value is Map of ShardId
     * Allocate Batch of unassigned shard  to nodes where valid copies of the shard already exists
        if (decision != null) {
 * @opensearch.internal
 * <p>
                        shardData.primary(),
            if (unassignedShard.primary() && batchShardRoutingSet.contains(unassignedShard)) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.index.shard.ShardId;
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            return decision;
            }
                if (ineligibleShardAllocationDecisions.containsKey(unassignedShard.shardId())) {
    /**
        );
        List<ShardRouting> eligibleShards,
     * @param shardsState fetch data result for the whole batch
    }
            AllocateUnassignedDecision decision = getInEligibleShardDecision(shard, allocation);
        // identify ineligible shards
 * nor does it allocate primaries when a primary shard failed and there is a valid replica
        final FetchResult<NodeGatewayStartedShardsBatch> shardsState = fetchData(
            Collections.emptyList(),
                inEligibleShards.add(shard);
 * that holds a copy of the shard.  The shard metadata from each node is compared against the
/**
 * (see {@link org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator}),
                    new NodeGatewayStartedShard(
        logger.error("fetchData for single shard called via batch allocator, shard id {}", shard.shardId());
            ShardRouting unassignedShard = iterator.next();
                    allocationDecision = ineligibleShardAllocationDecisions.get(unassignedShard.shardId());
            return null;
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
 * that it can allocate multiple unassigned primary shards wherein PrimaryShardAllocator can only allocate single
    private static List<NodeGatewayStartedShard> adaptToNodeShardStates(
import java.util.List;
}
 * unassigned shard.
        ShardRouting unassignedShard,
                nodeShardStates.add(
    protected FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetchData(
        while (iterator.hasNext()) {
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch;
            List.of(unassignedShard),
    );
        List<ShardRouting> eligibleShards = new ArrayList<>();
import java.util.Map;
package org.opensearch.gateway;
        final FetchResult<NodeGatewayStartedShardsBatch> shardsState = fetchData(eligibleShards, inEligibleShards, allocation);
import java.util.HashSet;
        }
    public void allocateUnassignedBatch(List<ShardRouting> shardRoutings, RoutingAllocation allocation) {
        Set<ShardRouting> batchShardRoutingSet = new HashSet<>(shardRoutings);
import java.util.ArrayList;
    }
        List<NodeGatewayStartedShard> nodeGatewayStartedShards = adaptToNodeShardStates(unassignedShard, shardsState);
     * @return shard state returned from each node
     * <p>
        List<NodeGatewayStartedShard> nodeShardStates = new ArrayList<>();
     */
                eligibleShards.add(shard);
                        shardData.storeException(),
        RoutingAllocation allocation
        // only fetch data for eligible shards
                        shardData.allocationId(),
        // build data for a shard from all the nodes
